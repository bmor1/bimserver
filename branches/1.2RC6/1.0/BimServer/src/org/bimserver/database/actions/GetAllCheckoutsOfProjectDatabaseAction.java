package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToInCondition;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllCheckoutsOfProjectDatabaseAction extends BimDatabaseAction<Set<Checkout>> {

	private final long poid;
	private final boolean checkSubProjects;

	public GetAllCheckoutsOfProjectDatabaseAction(AccessMethod accessMethod, long poid, boolean checkSubProjects) {
		super(accessMethod);
		this.poid = poid;
		this.checkSubProjects = checkSubProjects;
	}

	@Override
	public Set<Checkout> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = bimDatabaseSession.getProjectByPoid(poid);
		Set<Project> projects = new HashSet<Project>();
		if (checkSubProjects) {
			getSubProjects(project, projects);
		} else {
			projects.add(project);
		}
		Condition condition = new HasReferenceToInCondition(StorePackage.eINSTANCE.getCheckout_Project(), projects);
		Map<Long, Checkout> query = (Map<Long, Checkout>) bimDatabaseSession.query(condition, Checkout.class);
		return CollectionUtils.mapToSet(query);
	}
	
	private void getSubProjects(Project project, Set<Project> projects) {
		projects.add(project);
		for (Project subProject : project.getSubProjects()) {
			getSubProjects(subProject, projects);
		}
	}
}