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

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.common.util.EList;

public class SetRevisionTagDatabaseAction extends BimDatabaseAction<String> {
	private final Long roid;
	private final String tag;

	public SetRevisionTagDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Long roid, String tag) {
		super(bimDatabaseSession, accessMethod);
		this.roid = roid;
		this.tag = tag;
	}

	@Override
	public String execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		String trimmedTag = tag.trim();
		Project project = revision.getProject();
		if (project.getParent() != null) {
			throw new UserException("Revision is not contained by a top project.");
		}
		EList<Revision> projRevs = project.getRevisions();
		revision.setTag(trimmedTag);
		getDatabaseSession().store(revision);
		EList<ConcreteRevision> concreteRevisions = revision.getConcreteRevisions();
		for (ConcreteRevision cRev : concreteRevisions) {
			EList<Revision> revisions = cRev.getRevisions();
			for (Revision vRev : revisions) {
				if (projRevs.contains(vRev)) {
					continue;
				}
				vRev.setTag(trimmedTag);
				getDatabaseSession().store(vRev);
			}
		}
		return null;
	}
}