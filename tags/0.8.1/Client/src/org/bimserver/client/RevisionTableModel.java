package org.bimserver.client;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.bimserver.shared.SProject;
import org.bimserver.shared.SRevision;
import org.bimserver.shared.SRevisionList;
import org.bimserver.shared.SUser;
import org.bimserver.shared.UserException;

public class RevisionTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -1528523705646440767L;
	private List<SRevision> allRevisions = new ArrayList<SRevision>();
	private final ServiceHolder serviceHolder;

	public RevisionTableModel(ServiceHolder serviceHolder) {
		this.serviceHolder = serviceHolder;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return allRevisions.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		SRevision revision = allRevisions.get(row);
		switch (col) {
		case 0:
			return revision.getId();
		case 1:
			return dateFormat.format(revision.getDate());
		case 2:
			return revision.getUsername();
		case 3:
			return revision.getComment();
		case 4:
			return revision.getSize();
		}
		return null;
	}

	public void showProject(SProject project) {
		SRevisionList revisionList;
		try {
			revisionList = serviceHolder.getService().getAllRevisionsOfProject(project.getId());
			if (revisionList == null) {
				this.allRevisions.clear();
			} else {
				List<SRevision> revisions = revisionList.getRevisions();
				Collections.sort(revisions, new Comparator<SRevision>(){
					@Override
					public int compare(SRevision o1, SRevision o2) {
						return o1.getId() - o2.getId();
					}});
				this.allRevisions = revisions;
			}
			update();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getColumnName(int column) {
		switch(column) {
		case 0: return "Revision";
		case 1: return "Date";
		case 2: return "Author";
		case 3: return "Comment";
		case 4: return "Size";
		}
		return "";
	}

	public SRevision getRevision(int selectedRow) {
		return allRevisions.get(selectedRow);
	}

	public void update() {
		for (TableModelListener listener : getTableModelListeners()) {
			listener.tableChanged(new TableModelEvent(this));
		}
	}

	public void showUser(SUser user) {
		try {
			SRevisionList revisionList = serviceHolder.getService().getAllRevisionsByUser(user.getId());
			if (revisionList == null) {
				this.allRevisions.clear();
			} else {
				List<SRevision> revisions = revisionList.getRevisions();
				Collections.sort(revisions, new Comparator<SRevision>(){
					@Override
					public int compare(SRevision o1, SRevision o2) {
						return o1.getId() - o2.getId();
					}});
				this.allRevisions = revisions;
			}
			update();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
}