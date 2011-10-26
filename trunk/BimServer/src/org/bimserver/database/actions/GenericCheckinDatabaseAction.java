package org.bimserver.database.actions;

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

import java.util.Arrays;
import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.exceptions.UserException;

public abstract class GenericCheckinDatabaseAction extends BimDatabaseAction<ConcreteRevision>{

	private final IfcModelInterface model;

	public GenericCheckinDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, IfcModelInterface model) {
		super(bimDatabaseSession, accessMethod);
		this.model = model;
	}

	private ConcreteRevision getLastConcreteRevision(Project project) {
		Date lastDate = new Date();
		ConcreteRevision lastRevision = null;
		for (ConcreteRevision concreteRevision : project.getConcreteRevisions()) {
			if (concreteRevision.getDate().after(lastDate) || lastRevision == null) {
				lastDate = concreteRevision.getDate();
				lastRevision = concreteRevision;
			}
		}
		return lastRevision; 
	}
	
	protected void checkCheckSum(Project project) throws UserException {
		if (!project.getConcreteRevisions().isEmpty()) {
			ConcreteRevision concreteRevision = getLastConcreteRevision(project);
			int revisionId = -1;
			for (Revision revision : concreteRevision.getRevisions()) {
				if (revision.getProject() == project) {
					revisionId = revision.getId();
				}
			}
			if (concreteRevision.getState() == CheckinState.ERROR) {
				// When in error state, user usually tries the same file again, this should not give the 'duplicate model' error
				return;
			}
			byte[] revisionChecksum = concreteRevision.getChecksum();
			if (revisionChecksum != null && getModel().getChecksum() != null) {
				if (Arrays.equals(revisionChecksum, getModel().getChecksum())) {
					throw new UserException("Uploaded model is the same as last revision (" + revisionId + "), duplicate model not stored");
				}
			}
		}
	}
	
	public ConcreteRevision createNewConcreteRevision(BimDatabaseSession session, long size, long poid, long uoid, String comment, CheckinState checkinState) throws BimDatabaseException, BimDeadlockException {
		ConcreteRevision concreteRevision = StoreFactory.eINSTANCE.createConcreteRevision();
		concreteRevision.setSize(size);
		Date date = new Date();
		concreteRevision.setDate(date);
		Project project = getProjectByPoid(poid);
		concreteRevision.setId(project.getConcreteRevisions().size() + 1);
		User user = getUserByUoid(uoid);
		concreteRevision.setProject(project);
		concreteRevision.setState(checkinState);
		createNewVirtualRevision(session, project, concreteRevision, comment, date, user, size, checkinState);

		for (Checkout checkout : project.getCheckouts()) {
			if (checkout.getUser() == user) {
				checkout.setActive(false);
				session.store(checkout);
			}
		}

		Project parent = project.getParent();
		while (parent != null) {
			Revision revision = StoreFactory.eINSTANCE.createRevision();
			revision.setComment(comment);
			revision.setDate(date);
			revision.setUser(user);
			revision.setProject(parent);
			revision.setState(checkinState);
			if (parent.getLastRevision() != null) {
				Revision lastRevision = parent.getLastRevision();
				for (ConcreteRevision oldRevision : lastRevision.getConcreteRevisions()) {
					if (oldRevision.getProject() != project && oldRevision.getProject() != parent) {
						revision.getConcreteRevisions().add(oldRevision);
						revision.setSize(revision.getSize() + oldRevision.getSize());
						session.store(revision);
					}
					session.store(oldRevision);
				}
			}
			revision.getConcreteRevisions().add(concreteRevision);
			revision.setSize(revision.getSize() + concreteRevision.getSize());
			revision.setLastConcreteRevision(concreteRevision);
			if (parent.getLastRevision() == null) {
				revision.setId(1);
			} else {
				revision.setId(parent.getLastRevision().getId() + 1);
			}
			parent.setLastRevision(revision);
			session.store(revision);
			session.store(parent);
			parent = parent.getParent();
		}
		session.store(project);
		session.store(user);
		session.store(concreteRevision);
		return concreteRevision;
	}

	private void createNewVirtualRevision(BimDatabaseSession session, Project project, ConcreteRevision revision, String comment, Date date, User user, long size, CheckinState checkinState)
			throws BimDeadlockException, BimDatabaseException {
		Revision virtualRevision = StoreFactory.eINSTANCE.createRevision();
		virtualRevision.setLastConcreteRevision(revision);
		virtualRevision.setComment(comment);
		virtualRevision.setDate(date);
		virtualRevision.setUser(user);
		virtualRevision.setSize(size);
		virtualRevision.setState(checkinState);
		virtualRevision.setId(project.getRevisions().size() + 1);
		virtualRevision.getConcreteRevisions().add(revision);
		virtualRevision.setProject(project);
		session.store(virtualRevision);
	}

	public IfcModelInterface getModel() {
		return model;
	}
}