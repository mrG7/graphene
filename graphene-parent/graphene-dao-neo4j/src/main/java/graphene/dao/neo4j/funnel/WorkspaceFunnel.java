package graphene.dao.neo4j.funnel;

import graphene.dao.neo4j.Neo4JEmbeddedService;
import graphene.dao.neo4j.annotations.UserGraph;
import graphene.model.funnels.Funnel;
import graphene.model.idl.G_Workspace;
import graphene.model.idl.G_WorkspaceFields;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.joda.time.DateTime;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

public class WorkspaceFunnel implements Funnel<Node, G_Workspace> {
	private final Neo4JEmbeddedService n4jService;

	@Inject
	public WorkspaceFunnel(@UserGraph final Neo4JEmbeddedService n4jService2) {
		n4jService = n4jService2;
	}

	@Override
	public G_Workspace from(final Node f) {
		G_Workspace d = null;
		if (f != null) {
			try (Transaction tx = n4jService.beginTx()) {
				d = new G_Workspace();
				d.setActive((boolean) f.getProperty(G_WorkspaceFields.active.name(), true));

				d.setModified(new DateTime(f.getProperty(G_WorkspaceFields.modified.name(), 0l)).getMillis());
				d.setTitle((String) f.getProperty(G_WorkspaceFields.title.name()));
				d.setId((String) f.getProperty(G_WorkspaceFields.id.name()));
				tx.success();
			}
		}
		return d;
	}

	@Override
	public Node to(final G_Workspace f) {
		// TODO Auto-generated method stub
		return null;
	}

}
