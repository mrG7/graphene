package graphene.dao.sql;

import org.apache.tapestry5.ioc.Registry;
import org.slf4j.Logger;

public class QueryDSLTest {

	protected Registry registry;
	protected DBConnectionPoolService cp;
	protected Logger logger;
//
//	@BeforeSuite
//	public void setup() {
//
//		RegistryBuilder builder = new RegistryBuilder();
//		builder.add(UtilModule.class);
//		builder.add(DAOSQLModule.class);
//		registry = builder.build();
//		registry.performRegistryStartup();
//		cp = registry.getService("GrapheneConnectionPool",
//				DBConnectionPoolService.class);
//		logger = registry.getService(Logger.class);
//	}
//
//	@Test
//	public void testConnection() {
//		try {
//			Connection conn = cp.getConnection();
//			Properties p = conn.getClientInfo();
//			conn.close();
//
//			System.out.println(p.toString());
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//	}
}
