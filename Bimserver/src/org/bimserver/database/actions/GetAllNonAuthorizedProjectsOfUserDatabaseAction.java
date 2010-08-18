package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.query.conditions.Not;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.StorePackage;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllNonAuthorizedProjectsOfUserDatabaseAction extends BimDatabaseAction<Set<Project>> {

	private final int uid;

	public GetAllNonAuthorizedProjectsOfUserDatabaseAction(int uid) {
		this.uid = uid;
	}

	@Override
	public Set<Project> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new Not(new HasReferenceToCondition(StorePackage.eINSTANCE.getProject_HasAuthorizedUsers(), bimDatabaseSession.getUserById(uid))).and(
				new Not(new AttributeCondition(StorePackage.eINSTANCE.getProject_Name(), new StringLiteral(Database.STORE_PROJECT_NAME))));
		return CollectionUtils.mapToSet((Map<Long, Project>) bimDatabaseSession.query(Database.STORE_PROJECT_ID, -1, condition, Project.class));
	}
}