package org.bimserver.database.actions;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.Merger;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadByGuidsDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long actingUoid;
	private final Set<String> guids;
	private final Set<Long> roids;

	public DownloadByGuidsDatabaseAction(AccessMethod accessMethod, Set<Long> roids, Set<String> guids, long actingUoid) {
		super(accessMethod);
		this.roids = roids;
		this.guids = guids;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModel execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		Set<String> foundGuids = new HashSet<String>();
		LinkedHashSet<IfcModel> ifcModels = new LinkedHashSet<IfcModel>();
		Project project = null;
		for (Long roid : roids) {
			Revision virtualRevision = bimDatabaseSession.getVirtualRevision(roid);
			project = virtualRevision.getProject();
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			Map<ConcreteRevision, Set<Long>> map = new HashMap<ConcreteRevision, Set<Long>>();
			for (String guid : guids) {
				if (!foundGuids.contains(guid)) {
					for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
						ObjectIdentifier objectIdentifier = bimDatabaseSession.getOidOfGuid(guid, concreteRevision.getProject().getId(), concreteRevision.getId());
						if (objectIdentifier != null) {
							if (!map.containsKey(concreteRevision)) {
								map.put(concreteRevision, new HashSet<Long>());
							}
							map.get(concreteRevision).add(objectIdentifier.getOid());
//							long oidOfGuid = objectIdentifier.getOid();
//							if (oidOfGuid != -1) {
//								foundGuids.add(guid);
//								IfcModel subModel = bimDatabaseSession.getMapWithOids(concreteRevision.getProject().getId(), concreteRevision.getId(), oidOfGuid);
//								subModel.setDate(concreteRevision.getDate());
//								ifcModels.add(subModel);
//								continue;
//							}
						}
					}
				}
			}
			for (ConcreteRevision concreteRevision : map.keySet()) {
				Set<Long> oids = map.get(concreteRevision);
				IfcModel model = bimDatabaseSession.getMapWithOids(concreteRevision.getProject().getId(), concreteRevision.getId(), oids);
				model.setDate(concreteRevision.getDate());
				ifcModels.add(model);
			}
		}
		IfcModel ifcModel = Merger.merge(project, ifcModels);
		for (String guid : guids) {
			if (!foundGuids.contains(guid)) {
				throw new UserException("Guid " + guid + " not found");
			}
		}
		ifcModel.setRevisionNr(1);
		ifcModel.setAuthorizedUser(bimDatabaseSession.getUserByUoid(actingUoid).getName());
		ifcModel.setDate(new Date());
		return ifcModel;
	}
}