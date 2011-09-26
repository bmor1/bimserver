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

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

import org.bimserver.shared.SProject;
import org.bimserver.shared.SRevision;
import org.bimserver.shared.SUser;

public class RevisionPanel extends JPanel {

	private static final long serialVersionUID = 5029176190990026107L;

	private RevisionTableModel revisionTableModel;
	private JPopupMenu revisionMenu;
	private JTable revisionTable;

	public RevisionPanel(ServiceHolder serviceHolder, final Client testWindow) {
		setLayout(new BorderLayout());
		JLabel label = new JLabel("Revisions");
		add(label, BorderLayout.NORTH);

		revisionTableModel = new RevisionTableModel(serviceHolder);
		revisionTable = new JTable();

		revisionMenu = new JPopupMenu();
		JMenuItem checkoutItem = new JMenuItem("Checkout...");
		checkoutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SRevision revision = revisionTableModel.getRevision(revisionTable.getSelectedRow());
				testWindow.checkout(revision);
			}
		});
		JMenuItem downloadItem = new JMenuItem("Download...");	
		downloadItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SRevision revision = revisionTableModel.getRevision(revisionTable.getSelectedRow());
				testWindow.download(revision);
			}
		});
		
//		JMenuItem editAsTree = new JMenuItem("Edit as tree...");
//		revisionMenu.add(editAsTree);
		revisionMenu.add(checkoutItem);
		revisionMenu.add(downloadItem);

		revisionTable.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2 && mouseEvent.getButton() == MouseEvent.BUTTON1) {
					final SRevision revision = revisionTableModel.getRevision(revisionTable.getSelectedRow());
					File tmp = new File("tmp");
					if (!tmp.isDirectory()) {
						tmp.mkdir();
					}
					File file = new File(tmp, revision.getProjectName() + "." + revision.getId() + ".ifc");
					try {
						testWindow.download(revision.getProjectId(), revision.getId(), new FileOutputStream(file), false);
						Desktop.getDesktop().open(file);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		revisionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		revisionTable.setDragEnabled(true);
		revisionTable.setTransferHandler(new TransferHandler() {
			private static final long serialVersionUID = 5916286741958199845L;

			@Override
			protected Transferable createTransferable(JComponent c) {
				final SRevision revision = revisionTableModel.getRevision(revisionTable.getSelectedRow());
				final List<File> list = new ArrayList<File>();
				return new Transferable(){

					@Override
					public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
						if (list.size() == 0) {
							File tmp = new File("tmp");
							if (!tmp.isDirectory()) {
								tmp.mkdir();
							}
							File file = new File(tmp, revision.getProjectName() + "-" + revision.getId() + ".ifc");
							list.add(file);
							try {
								testWindow.checkout(revision, new FileOutputStream(file), false);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
						}
						return list;
					}

					@Override
					public DataFlavor[] getTransferDataFlavors() {
						return new DataFlavor[]{DataFlavor.javaFileListFlavor};
					}

					@Override
					public boolean isDataFlavorSupported(DataFlavor flavor) {
						return false;
					}
				};
			}

			@Override
			public int getSourceActions(JComponent c) {
				return COPY_OR_MOVE;
			}
		});
		revisionTable.setModel(revisionTableModel);
		revisionTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					revisionMenu.show(revisionTable, e.getX(), e.getY());
				}
			}
		});
		JScrollPane scrollpaneRevisions = new JScrollPane(revisionTable);
		add(scrollpaneRevisions, BorderLayout.CENTER);
	}

	public void showProject(SProject project) {
		revisionTableModel.showProject(project);
	}

	public void showUser(SUser user) {
		revisionTableModel.showUser(user);
	}
}