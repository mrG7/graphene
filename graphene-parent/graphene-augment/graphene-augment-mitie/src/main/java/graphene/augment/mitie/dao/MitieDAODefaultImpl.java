package graphene.augment.mitie.dao;

import graphene.augment.mitie.model.MitieResponse;
import graphene.business.commons.exception.DataAccessException;

import java.io.IOException;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MitieDAODefaultImpl implements MitieDAO {
	@Inject
	private Logger logger;
	@Inject
	private MITIERestAPIConnection connection;

	private ObjectMapper mapper = new ObjectMapper();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.graphene.augment.mitie.dao.MitieDAO#augment(java.lang.String)
	 */
	@Override
	public MitieResponse augment(String input) throws DataAccessException {
		MitieResponse x = null;
		String results;
		try {
			results = connection.performQuery(input.trim());
			x = mapper.readValue(results, MitieResponse.class);
		} catch (DataAccessException | IOException e) {
			logger.error("augment : "+e.getMessage());
			throw new graphene.business.commons.exception.DataAccessException(
					"Could not augment the text with MITIE: " + e.getMessage());
		}
		return x;

	}
}
