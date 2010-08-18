package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.BimDatabaseAction;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.query.literals.BooleanLiteral;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.StorePackage;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllCheckoutsOfProjectDatabaseAction extends BimDatabaseAction<Set<Checkout>> {

	private final int pid;

	public GetAllCheckoutsOfProjectDatabaseAction(int pid) {
		this.pid = pid;
	}

	@Override
	public Set<Checkout> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = bimDatabaseSession.getProjectById(pid);
		Condition condition = new HasReferenceToCondition(StorePackage.eINSTANCE.getCheckout_Project(), project);
		condition = condition.and(new AttributeCondition(StorePackage.eINSTANCE.getCheckout_Active(), new BooleanLiteral(true)));
		Map<Long, Checkout> query = (Map<Long, Checkout>) bimDatabaseSession.query(Database.STORE_PROJECT_ID, -1, condition, Checkout.class);
		return CollectionUtils.mapToSet(query);
	}
}