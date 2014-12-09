package graphene.dao.es;

import graphene.dao.LoggingDAO;
import graphene.model.idl.G_Workspace;
import graphene.model.query.EntityQuery;
import graphene.util.validator.ValidationUtils;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.search.sort.Sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.PostInjection;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.joda.time.DateTime;
import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggingDAODefaultESImpl extends BasicESDAO implements LoggingDAO {
	@Inject
	@Symbol(JestModule.ES_LOGGING_INDEX)
	private String indexName;

	@Inject
	public LoggingDAODefaultESImpl(ESRestAPIConnection c,
			JestClient jestClient, Logger logger) {
		this.auth = null;
		this.c = c;
		this.jestClient = jestClient;
		this.mapper = new ObjectMapper(); // can reuse, share globally
		this.logger = logger;
	}

	@PostInjection
	public void initialize() {
		this.setIndex(indexName);
		this.setType("queryLog");
		super.initialize();
	}

	@Override
	public boolean recordQuery(String queryString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recordLogin(String userName, DateTime date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recordExport(String queryString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EntityQuery> getQueries(String userId, String partialTerm,
			int limit) {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		if (ValidationUtils.isValid(userId)) {

			if (ValidationUtils.isValid(partialTerm)) {
				// use the partial name to filter
				searchSourceBuilder.query(QueryBuilders.filteredQuery(
						QueryBuilders.fuzzyQuery("value", partialTerm),
						FilterBuilders.andFilter(FilterBuilders.termFilter(
								"userId", userId))));
			} else {
				// don't filter on name, get all of them.
				searchSourceBuilder.query(QueryBuilders.matchQuery("userId",
						userId));
			}
		} else {
			if (ValidationUtils.isValid(partialTerm)) {
				// use the partial name to filter
				searchSourceBuilder.query(QueryBuilders.fuzzyQuery("value",
						partialTerm));
			} else {
				searchSourceBuilder.query(QueryBuilders.matchAllQuery());
			}
		}
		SortBuilder byDate = SortBuilders.fieldSort("timeInitiated")
				.order(SortOrder.DESC).ignoreUnmapped(true);

		Search search = new Search.Builder(searchSourceBuilder.sort(byDate)
				.toString()).addIndex(indexName).addType(type).build();
		System.out.println(searchSourceBuilder.toString());
		JestResult result;
		List<EntityQuery> returnValue = new ArrayList<EntityQuery>(0);
		try {
			result = jestClient.execute(search);
			returnValue = result.getSourceAsObjectList(EntityQuery.class);
			for (EntityQuery u : returnValue) {
				System.out.println(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;

	}

	@Override
	public void recordQuery(EntityQuery sq) {
		EntityQuery returnVal = sq;
		Index saveAction;
		if (ValidationUtils.isValid(returnVal)) {
			if (!ValidationUtils.isValid(returnVal.getId())) {
				// auto id
				saveAction = new Index.Builder(sq).index(indexName).type(type)
						.build();
			} else {
				// use id that was provided
				saveAction = new Index.Builder(returnVal).index(indexName)
						.id(returnVal.getId()).type(type).build();
			}
			try {
				JestResult result = jestClient.execute(saveAction);
				if (!ValidationUtils.isValid(returnVal.getId())
						&& ValidationUtils.isValid(result.getValue("_id"))) {

				}
			} catch (ExecutionException | InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			logger.error("Attempted to save a null user object!");
		}
		return;
	}

}
