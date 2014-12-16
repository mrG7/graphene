package graphene.dao.es;

import graphene.business.commons.exception.DataAccessException;
import graphene.model.idl.G_SearchTuple;
import graphene.model.query.EntityQuery;
import graphene.util.validator.ValidationUtils;
import io.searchbox.client.JestClient;
import io.searchbox.core.Count;
import io.searchbox.core.CountResult;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;

import javax.annotation.Nullable;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.index.query.CommonTermsQueryBuilder;
import org.elasticsearch.index.query.CommonTermsQueryBuilder.Operator;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.slf4j.Logger;

public class ESRestAPIConnectionImpl implements ESRestAPIConnection {
	@Inject
	private Logger logger;

	@Inject
	private JestClient client;

	@Inject
	@Symbol(JestModule.ES_SEARCH_INDEX)
	private String indexName;

	@Override
	public String getIndexName() {
		return indexName;
	}

	@Override
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	@Override
	public void createIndex(String indexName, String settings) {
		try {
			if (settings != null) {
				logger.debug("Creating index " + indexName + " with settings "
						+ settings);
				client.execute(new CreateIndex.Builder(indexName).settings(
						ImmutableSettings.builder().loadFromSource(settings))
						.build());
			} else {
				logger.debug("Creating index " + indexName
						+ " with default settings");
				client.execute(new CreateIndex.Builder(indexName).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createIndex(String indexName, int shards, int replicas) {
		try {
			if (shards > 0 && replicas > 0) {
				logger.debug("Creating index " + indexName + " with " + shards
						+ "shard(s) and " + replicas + " replica(s).");
				ImmutableSettings.Builder sb = ImmutableSettings
						.settingsBuilder();
				sb.put("number_of_shards", shards);
				sb.put("number_of_replicas", replicas);
				client.execute(new CreateIndex.Builder(indexName).settings(
						sb.build().getAsMap()).build());
			} else {
				logger.debug("Creating index " + indexName
						+ " with default settings");
				client.execute(new CreateIndex.Builder(indexName).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the client
	 */
	@Override
	public final JestClient getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public final void setClient(JestClient client) {
		this.client = client;
	}

	private String createCleanUrl(@Nullable String basicAuth, String baseUrl) {
		if (basicAuth != null) {
			logger.debug("Auth information provided, using auth info.");
			String cleanAuth = basicAuth.replaceAll("@", "%40");
			String cleanURL = baseUrl.replace("http://", "http://" + cleanAuth
					+ "@");
			return cleanURL;
		}
		logger.debug("No auth information provided, using without auth info.");
		return baseUrl;
	}

	@Override
	public long performCount(@Nullable String basicAuth, String baseUrl,
			String index, String type, String fieldName, String term)
			throws DataAccessException {
		try {
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			QueryBuilder qb = QueryBuilders.matchQuery(fieldName, term);
			SearchSourceBuilder query = searchSourceBuilder.query(qb);
			Count action = new Count.Builder().addIndex(index)
					.query(query.toString()).build();
			CountResult result = client.execute(action);
			long longCount = result.getCount().longValue();
			logger.debug("Found a count of: " + longCount);
			return longCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(
					"Could not connect to one of the external resources needed for your request: "
							+ e.getMessage());
		}
	}

	@Override
	public String performQuery(@Nullable String basicAuth, String baseurl,
			String index, String type, String fieldName, String term,
			long from, long size) throws DataAccessException {
		try {
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			QueryBuilder qb = QueryBuilders.matchQuery(fieldName, term);
			searchSourceBuilder.query(qb);
			Search action = new Search.Builder(searchSourceBuilder.toString())
					.addIndex(index).setParameter("from", from)
					.setParameter("size", size).build();
			SearchResult result = client.execute(action);
			String resultString = result.getJsonString();
			// logger.debug(resultString);
			return resultString;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(
					"Could not connect to one of the external resources needed for your request: "
							+ e.getMessage());
		}
	}

	@Override
	public String performQuery(String basicAuth, String baseurl, String index,
			String type, EntityQuery q) throws DataAccessException {
		String retval = null;
		try {
			if (q.getAttributeList().get(0).getValue().isEmpty()) {
				retval = performIndexQuery(index, q);
			} else {
				// retval = performMatchQuery(index, q);
				retval = performCommonTermsQuery(index, q);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(
					"Could not connect to one of the external resources needed for your request: "
							+ e.getMessage());
		}
		return retval;
	}

	private String performIndexQuery(String index, EntityQuery q)
			throws Exception {

		if (q.getMaxResult() == 0) {
			logger.warn("NO MAX RESULT SUPPLIED FOR EntityQuery!  Setting to one.");
			q.setMaxResult(1l);
		}
		Search action = new Search.Builder("").addIndex(index)
				.setParameter("from", q.getFirstResult())
				.setParameter("size", q.getMaxResult()).build();
		logger.debug("Action:\n" + action.toString());
		SearchResult result = client.execute(action);
		String resultString = result.getJsonString();
		return resultString;
	}

	/**
	 * @param index
	 * @param q
	 * @throws Exception
	 */
	private String performCommonTermsQuery(String index, EntityQuery q)
			throws Exception {
		StringBuffer terms = new StringBuffer();
		// Dead simple, just coalesces the values as one long phrase
		for (G_SearchTuple<String> qi : q.getAttributeList()) {
			terms.append(qi.getValue() + " ");
		}
		String queryTerms = terms.toString().trim();
		if (ValidationUtils.isValid(queryTerms)) {
			logger.debug("Searching for terms: " + queryTerms + " from query "
					+ q);
			// Let's decide that at least half of the terms listed need to
			// appear.
			Integer halfTerms = q.getAttributeList().size() / 2;
			if (halfTerms <= 1) {
				halfTerms = 1;
			}
			CommonTermsQueryBuilder qbc = QueryBuilders.commonTerms("_all",
					queryTerms).lowFreqOperator(Operator.AND);

			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			HighlightBuilder h = new HighlightBuilder().field("narr.narr");
			searchSourceBuilder.query(qbc).highlight(h).minScore(0.5f);
			if (q.getMaxResult() == 0) {
				logger.warn("NO MAX RESULT SUPPLIED FOR EntityQuery!  Setting to 200.");
				q.setMaxResult(200l);
			}
			logger.debug("SSB: \n" + searchSourceBuilder.toString());
			Search action = new Search.Builder(searchSourceBuilder.toString())
					.addIndex(index).setParameter("from", q.getFirstResult())
					.setParameter("size", q.getMaxResult()).build();
			logger.debug("Action:\n" + action.toString());
			SearchResult result = client.execute(action);
			String resultString = result.getJsonString();
			return resultString;
		}
		return null;
	}

	private String performMatchQuery(String index, EntityQuery q)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		// Dead simple, just coalesces the values as one long phrase
		for (G_SearchTuple<String> qi : q.getAttributeList()) {
			sb.append(qi.getValue() + " ");
		}
		String terms = sb.toString().trim();
		if (ValidationUtils.isValid(terms)) {
			logger.debug("Searching for terms: " + terms + " from query " + q);
			// Let's decide that at least half of the terms listed need to
			// appear.
			Integer halfTerms = q.getAttributeList().size() / 2;
			if (halfTerms <= 1) {
				halfTerms = 1;
			}
			MatchQueryBuilder qbc = QueryBuilders.matchPhraseQuery("_all",
					terms.toString());

			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(qbc);
			if (q.getMaxResult() == 0) {
				logger.warn("NO MAX RESULT SUPPLIED FOR EntityQuery!  Setting to one.");
				q.setMaxResult(10l);
			}
			logger.debug("SSB: \n" + searchSourceBuilder.toString());
			Search action = new Search.Builder(searchSourceBuilder.toString())
					.addIndex(index).setParameter("from", q.getFirstResult())
					.setParameter("size", q.getMaxResult()).build();
			logger.debug("Action:\n" + action.toString());
			SearchResult result = client.execute(action);
			String resultString = result.getJsonString();
			return resultString;
		}
		return null;
	}
}
