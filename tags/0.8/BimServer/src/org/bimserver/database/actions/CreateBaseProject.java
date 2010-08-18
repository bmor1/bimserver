package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.BimDatabaseAction;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.StoreFactory;
import org.bimserver.shared.UserException;

public class CreateBaseProject extends BimDatabaseAction<Project>{

	public CreateBaseProject() {
	}

	@Override
	public Project execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDatabaseException, BimDeadlockException {
		final Project project = StoreFactory.eINSTANCE.createProject();
		project.setId(Database.STORE_PROJECT_ID);
		project.setName(Database.STORE_PROJECT_NAME);
		project.setCreatedDate(new Date());
		bimDatabaseSession.store(project, new CommitSet(Database.STORE_PROJECT_ID, -1));
		bimDatabaseSession.saveOidCounter();
		bimDatabaseSession.savePidCounter();
		return project;
	}
}