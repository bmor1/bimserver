package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.query.conditions.Not;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllNonAuthorizedUsersOfProjectDatabaseAction extends BimDatabaseAction<Set<User>>{

	private final int pid;

	public GetAllNonAuthorizedUsersOfProjectDatabaseAction(int pid) {
		this.pid = pid;
	}
	
	@Override
	public Set<User> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new Not(new HasReferenceToCondition(StorePackage.eINSTANCE.getUser_HasRightsOn(), bimDatabaseSession.getProjectById(pid)));
		return CollectionUtils.mapToSet((Map<Long, User>) bimDatabaseSession.query(Database.STORE_PROJECT_ID, -1, condition, User.class));
	}
}