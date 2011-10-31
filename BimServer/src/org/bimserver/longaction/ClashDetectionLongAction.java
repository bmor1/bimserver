package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.actions.FindClashesDatabaseAction;
import org.bimserver.database.actions.SendClashesEmailDatabaseAction;
import org.bimserver.interfaces.SConverter;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.Clash;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class ClashDetectionLongAction extends LongAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClashDetectionLongAction.class);
	private final long actingUoid;
	private final long poid;
	private final User user;
	private final BimServer bimServer;

	public ClashDetectionLongAction(BimServer bimServer, User user, long actingUoid, long poid) {
		this.bimServer = bimServer;
		this.user = user;
		this.actingUoid = actingUoid;
		this.poid = poid;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		long roid = -1;
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false, null);
			Revision revision = project.getLastRevision();
			revision.setState(CheckinState.SEARCHING_CLASHES);
			roid = revision.getOid();
			session.store(revision);
			session.commit();
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		session = bimServer.getDatabase().createSession(true);
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false, null);
			ClashDetectionSettings clashDetectionSettings = StoreFactory.eINSTANCE.createClashDetectionSettings();
			clashDetectionSettings.setMargin(project.getClashDetectionSettings().getMargin());
			clashDetectionSettings.getRevisions().add(project.getLastRevision());
			FindClashesDatabaseAction findClashesDatabaseAction = new FindClashesDatabaseAction(bimServer, session, AccessMethod.INTERNAL, clashDetectionSettings, roid);
			Set<? extends Clash> clashes = findClashesDatabaseAction.execute();
			Revision revision = project.getLastRevision();
// Temporarily disabled, should be enabled when lazy loading is working
//			for (Clash clash : clashes) {
//				revision.getLastClashes().add(clash);
//				session.store(clash);
//			}
			revision.setNrClashes(clashes.size());
			revision.setState(CheckinState.DONE);
			session.store(revision);

			Set<String> emailAddresses = new HashSet<String>();
			for (Clash clash : clashes) {
				emailAddresses.add(clash.getRevision1().getUser().getUsername());
				emailAddresses.add(clash.getRevision2().getUser().getUsername());
			}
			if (!emailAddresses.isEmpty()) {
				String[] emailAddressesArray = new String[emailAddresses.size()];
				emailAddresses.toArray(emailAddressesArray);
				
				SendClashesEmailDatabaseAction sendClashesEmailDatabaseAction = new SendClashesEmailDatabaseAction(bimServer, session, AccessMethod.INTERNAL, actingUoid, poid, new SConverter().convertToSObject(clashDetectionSettings), emailAddresses);
				sendClashesEmailDatabaseAction.execute();
			}
			session.commit();
		} catch (Throwable e) {
			LOGGER.error("", e);
			try {
				BimDatabaseSession rollBackSession = bimServer.getDatabase().createSession(true);
				try {
					Throwable throwable = e;
					while (throwable.getCause() != null) {
						throwable = throwable.getCause();
					}
					Revision revision = rollBackSession.get(StorePackage.eINSTANCE.getRevision(), roid, false, null);
					revision.setState(CheckinState.CLASHES_ERROR);
					revision.setLastError(throwable.getMessage());
					rollBackSession.store(revision);
					rollBackSession.commit();
				} finally {
					rollBackSession.close();
				}
			} catch (BimDeadlockException e1) {
				LOGGER.error("", e1);
			} catch (BimDatabaseException e1) {
				LOGGER.error("", e1);
			}
		} finally {
			session.close();
		}
	}

	@Override
	public String getDescription() {
		return "ClashDetectionLongAction " + user.getName();
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void init() {
	}

	@Override
	public LongActionKey getKey() {
		return new ClashDetectionLongActionKey(poid);
	}
}