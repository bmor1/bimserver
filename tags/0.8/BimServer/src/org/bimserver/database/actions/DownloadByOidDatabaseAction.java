package org.bimserver.database.actions;

import java.util.Map;

import org.bimserver.BimDatabaseAction;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.User;
import org.bimserver.database.store.VirtualRevision;
import org.bimserver.emf.BasicEmfModel;
import org.bimserver.emf.EmfModel;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EObject;

public class DownloadByOidDatabaseAction extends BimDatabaseAction<EmfModel<Long>> {

	private final int pid;
	private final int rid;
	private final long oid;
	private final int uid;

	public DownloadByOidDatabaseAction(int pid, int rid, long oid, int uid) {
		this.pid = pid;
		this.rid = rid;
		this.oid = oid;
		this.uid = uid;
	}

	@Override
	public EmfModel<Long> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = bimDatabaseSession.getProjectById(pid);
		User user = bimDatabaseSession.getUserById(uid);
		if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		VirtualRevision virtualRevision = bimDatabaseSession.getVirtualRevision(pid, rid);
		EmfModel<Long> emfModel = new BasicEmfModel<Long>(getSize(virtualRevision));
		for (ConcreteRevision concreteRevision : virtualRevision.getRevisions()) {
			Map<Long, EObject> mapWithOid = bimDatabaseSession.getMapWithOid(concreteRevision.getProject().getId(), concreteRevision.getId(), oid);
			merge(emfModel, new BasicEmfModel<Long>(mapWithOid));
		}
		emfModel.setProjectName(virtualRevision.getProject().getName());
		emfModel.setRevisionNr(virtualRevision.getId());
		emfModel.setAuthor(virtualRevision.getLastRevision().getUser().getName());
		emfModel.setAuthorizedUser(bimDatabaseSession.getUserById(uid).getName());
		emfModel.setDate(virtualRevision.getLastRevision().getDate());
		emfModel.setDescription(virtualRevision.getProject().getDescription());
		return emfModel;
	}
}