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
import java.awt.Dimension;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.activation.DataSource;
import javax.swing.DropMode;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import org.bimserver.shared.ProjectList;
import org.bimserver.shared.SGeoTag;
import org.bimserver.shared.SProject;
import org.bimserver.shared.SRevision;
import org.bimserver.shared.SUser;
import org.bimserver.shared.UserException;
import org.bimserver.shared.UserList;

public class TreePanel extends JPanel {

	private static final long serialVersionUID = 659074905682926000L;
	private final JTree tree;
	private final ServiceHolder serviceHolder;
	private final ServerTreeNode serverTreeNode;

	public TreePanel(final Client testWindow, final ServiceHolder serviceHolder) {
		this.serviceHolder = serviceHolder;
		setLayout(new BorderLayout());

		RootTreeNode rootTreeNode = new RootTreeNode();
		serverTreeNode = new ServerTreeNode(rootTreeNode, "localhost");
		rootTreeNode.add(serverTreeNode);

		tree = new JTree(rootTreeNode);
		tree.setRootVisible(false);
		tree.setDropMode(DropMode.ON);
		tree.setTransferHandler(new TransferHandler() {
			private static final long serialVersionUID = -5283693046745987552L;

			@Override
			public boolean canImport(TransferSupport support) {
				return true;
			}

			@SuppressWarnings("unchecked")
			@Override
			public boolean importData(TransferSupport support) {
				Transferable transferable = support.getTransferable();
				try {
					Object transferData = transferable.getTransferData(transferable.getTransferDataFlavors()[0]);
					List<File> list = (List<File>) transferData;
					File file = list.get(0);
					final FileInputStream fis = new FileInputStream(file);
					JTree.DropLocation dropLocation = (JTree.DropLocation) support.getDropLocation();
					final ProjectTreeNode ptn = (ProjectTreeNode) dropLocation.getPath().getLastPathComponent();
					testWindow.checkin(ptn.getProject(), new DataSource() {

						@Override
						public String getContentType() {
							return null;
						}

						@Override
						public InputStream getInputStream() throws IOException {
							return fis;
						}

						@Override
						public String getName() {
							return null;
						}

						@Override
						public OutputStream getOutputStream() throws IOException {
							return null;
						}
					}, file.length());
				} catch (UnsupportedFlavorException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		});

		tree.setPreferredSize(new Dimension(150, 500));
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				Object lastPathComponent = e.getPath().getLastPathComponent();
				if (lastPathComponent instanceof ProjectTreeNode) {
					testWindow.showProject(((ProjectTreeNode) lastPathComponent).getProject());
				} else if (lastPathComponent instanceof UserTreeNode) {
					testWindow.showUser(((UserTreeNode) lastPathComponent).getUser());
				}
			}
		});
		add(tree, BorderLayout.CENTER);

		final JPopupMenu projectsMenu = new JPopupMenu();

		final JPopupMenu userMenu = new JPopupMenu();
		final JMenuItem deleteUser = new JMenuItem("Delete");
		deleteUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object lastPathComponent = tree.getSelectionPath().getLastPathComponent();
				if (lastPathComponent instanceof UserTreeNode) {
					int showConfirmDialog = JOptionPane.showConfirmDialog(testWindow, "Are you sure you want to delete this user?", "Delete user", JOptionPane.YES_NO_OPTION);
					if (showConfirmDialog == JOptionPane.YES_OPTION) {
						try {
							serviceHolder.getService().deleteUser(((UserTreeNode) lastPathComponent).getUser().getId());
						} catch (UserException e1) {
							e1.printStackTrace();
						}
						updateUsers(serverTreeNode);
					}
				}
			}
		});
		userMenu.add(deleteUser);

		final JPopupMenu usersMenu = new JPopupMenu();
		final JMenuItem addUser = new JMenuItem("Add User");
		addUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newUserName = JOptionPane.showInputDialog(testWindow, "What is the name of the new user?", "Add new user", JOptionPane.OK_OPTION
						| JOptionPane.INFORMATION_MESSAGE);
				String newPassword = JOptionPane.showInputDialog(testWindow, "What is the password new user?", "Add new user", JOptionPane.OK_OPTION
						| JOptionPane.INFORMATION_MESSAGE);
				try {
					serviceHolder.getService().addUser(newUserName, newPassword, newUserName);
				} catch (UserException e1) {
					e1.printStackTrace();
				}
				updateUsers(serverTreeNode);
			}
		});
		usersMenu.add(addUser);

		final JPopupMenu serverMenu = new JPopupMenu();
		final JMenuItem addProject = new JMenuItem("Add Project");
		addProject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newProjectName = JOptionPane.showInputDialog(testWindow, "What is the name of the new project?", "Add new project", JOptionPane.OK_OPTION
						| JOptionPane.INFORMATION_MESSAGE);
				if (newProjectName != null) {
					try {
						serviceHolder.getService().addProject(newProjectName, new SGeoTag());
					} catch (UserException e1) {
						e1.printStackTrace();
					}
					updateProjects(serverTreeNode);
				}
			}
		});
		final JMenuItem connectDisconnect = new JMenuItem("(Re)connect");
		connectDisconnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (connectDisconnect.getText().equals("(Re)connect")) {
					SettingsFrame settingsFrame = new SettingsFrame(testWindow);
					settingsFrame.setVisible(true);
//					if (TreePanel.this.serviceHolder.connect(testWindow.getServiceHolder().getAddress(), testWindow.getServiceHolder().getUsername(), testWindow.getServiceHolder().getPassword())) {
//						updateProjects(serverTreeNode);
//						updateUsers(serverTreeNode);
//						testWindow.setTitle("BIM Server Tester - " + testWindow.getServiceHolder().getUsername());
//						projectTree.expandRow(0);
//					} else {
//						JOptionPane.showMessageDialog(testWindow, "Connection failed", "Connection failed", JOptionPane.ERROR_MESSAGE);
//					}
				} else {
					serviceHolder.disconnect();
					serverTreeNode.clearProjects();
					serverTreeNode.clearUsers();
					tree.updateUI();
					testWindow.setTitle("BIM Server Tester - Not connected");
					tree.collapseRow(0);
				}
			}
		});
		serverMenu.add(connectDisconnect);
		projectsMenu.add(addProject);
		
		final JMenuItem deleteProject = new JMenuItem("Delete");
		deleteProject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object lastPathComponent = tree.getSelectionPath().getLastPathComponent();
				if (lastPathComponent instanceof ProjectTreeNode) {
					int showConfirmDialog = JOptionPane.showConfirmDialog(testWindow, "Are you sure you want to delete this project?", "Delete project", JOptionPane.YES_NO_OPTION);
					if (showConfirmDialog == JOptionPane.YES_OPTION) {
						try {
							serviceHolder.getService().deleteProject(((ProjectTreeNode) lastPathComponent).getProject().getId());
							updateProjects(serverTreeNode);
						} catch (UserException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		serverMenu.addPopupMenuListener(new PopupMenuListener() {
			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				if (!serviceHolder.isConnected()) {
//					connectDisconnect.setEnabled(true);
//					connectDisconnect.setText("Connect");
				} else {
//					connectDisconnect.setEnabled(false);
//					connectDisconnect.setText("Disconnect");
				}
			}
		});

		final JMenuItem processChangeSet = new JMenuItem("Process ChangeSet...");
		processChangeSet.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectTreeNode ptn = (ProjectTreeNode) tree.getSelectionPath().getLastPathComponent();
				testWindow.processChangeSet(ptn.getProject());
			}});
		
		final JPopupMenu projectMenu = new JPopupMenu();
		final JMenuItem checkin = new JMenuItem("Checkin new revision...");
		final JMenuItem checkout = new JMenuItem("Checkout latest revision...");
		checkout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectTreeNode ptn = (ProjectTreeNode) tree.getSelectionPath().getLastPathComponent();
				try {
					SRevision revision = serviceHolder.getService().getLastRevision(ptn.getProject().getId());
					testWindow.checkout(revision);
				} catch (UserException e1) {
					e1.printStackTrace();
				}
			}
		});
		final JMenuItem download = new JMenuItem("Download latest revision...");
		download.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectTreeNode ptn = (ProjectTreeNode) tree.getSelectionPath().getLastPathComponent();
				try {
					SRevision revision = serviceHolder.getService().getLastRevision(ptn.getProject().getId());
					testWindow.download(revision);
				} catch (UserException e1) {
					e1.printStackTrace();
				}
			}
		});

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					int rowForLocation = tree.getRowForLocation(e.getX(), e.getY());
					if (rowForLocation != -1) {
						tree.setSelectionRow(rowForLocation);
					}
					if (tree.getSelectionPath() != null) {
						Object object = tree.getSelectionPath().getLastPathComponent();
						if (object instanceof ServerTreeNode) {
							serverMenu.show(tree, e.getX(), e.getY());
						} else if (object instanceof ProjectTreeNode) {
							projectMenu.show(tree, e.getX(), e.getY());
						} else if (object instanceof ProjectsTreeNode) {
							projectsMenu.show(tree, e.getX(), e.getY());
						} else if (object instanceof UsersTreeNode) {
							usersMenu.show(tree, e.getX(), e.getY());
						} else if (object instanceof UserTreeNode) {
							userMenu.show(tree, e.getX(), e.getY());
						}
					}
				}
			}
		});

		projectMenu.addPopupMenuListener(new PopupMenuListener() {

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				try {
					if (serviceHolder.getService().getAllRevisionsOfProject(((ProjectTreeNode) tree.getSelectionPath().getLastPathComponent()).getProject().getId()) == null) {
						checkout.setEnabled(false);
						checkin.setText("Checkin initial revision...");
					} else {
						checkout.setEnabled(true);
						checkin.setText("Checkin new revision...");
					}
				} catch (UserException e1) {
					e1.printStackTrace();
				}
			}
		});
		checkin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectTreeNode ptn = (ProjectTreeNode) tree.getSelectionPath().getLastPathComponent();
				testWindow.checkin(ptn.getProject());
			}
		});
		projectMenu.add(processChangeSet);
		projectMenu.add(checkin);
		projectMenu.addSeparator();
		projectMenu.add(checkout);
		projectMenu.add(download);
		projectMenu.addSeparator();
		projectMenu.add(deleteProject);
	}

	private void updateProjects(ServerTreeNode serverTreeNode) {
		ProjectList projectList;
		try {
			projectList = serviceHolder.getService().getAllProjects();
			serverTreeNode.clearProjects();
			if (projectList != null) {
				for (SProject p : projectList.getProjects()) {
					ProjectTreeNode projectTreeNode = new ProjectTreeNode(p);
					serverTreeNode.add(projectTreeNode);
				}
			}
			tree.updateUI();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	private void updateUsers(ServerTreeNode serverTreeNode) {
		UserList userList;
		try {
			userList = serviceHolder.getService().getAllUsers();
			serverTreeNode.clearUsers();
			if (userList != null) {
				for (SUser u : userList.getUsers()) {
					UserTreeNode userTreeNode = new UserTreeNode(u);
					serverTreeNode.add(userTreeNode);
				}
			}
			tree.updateUI();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	public void updateTree() {
		updateProjects(serverTreeNode);
		updateUsers(serverTreeNode);
	}

	public void expandTree() {
		tree.expandRow(0);
	}
}