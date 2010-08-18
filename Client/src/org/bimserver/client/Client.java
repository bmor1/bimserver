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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.shared.ChangeSet;
import org.bimserver.shared.ChangeSetResult;
import org.bimserver.shared.CheckinResult;
import org.bimserver.shared.CheckoutResult;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SProject;
import org.bimserver.shared.SRevision;
import org.bimserver.shared.SUser;
import org.bimserver.shared.UserException;
import org.bimserver.utils.SwingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client extends JFrame {

	private static final long serialVersionUID = -3971471091403217662L;
	private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
	public static final String APP_NAME = "BIM Server Client";
	private final ServiceHolder serviceHolder = new ServiceHolder();
	private final RevisionPanel revisionPanel;
	private final CheckoutsPanel checkoutsPanel;
	private final TreePanel treePanel;

	public static void main(String[] args) {
		new Client();
	}

	public Client() {
		SwingUtil.setLookAndFeelToNice();

		try {
			setIconImage(ImageIO.read(getClass().getResource("logo_small.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		revisionPanel = new RevisionPanel(serviceHolder, this);
		revisionPanel.setMinimumSize(new Dimension(200, 150));
		checkoutsPanel = new CheckoutsPanel(serviceHolder, this);
		checkoutsPanel.setMinimumSize(new Dimension(200, 150));
		treePanel = new TreePanel(this, serviceHolder);

		JMenu auth = new JMenu("File");
		JMenuItem changeAuth = new JMenuItem("(Re)connect");
		changeAuth.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				SettingsFrame settingsFrame = new SettingsFrame(Client.this);
				settingsFrame.setVisible(true);
			}});
		auth.add(changeAuth);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(auth);
		setJMenuBar(menuBar);

		setTitle(APP_NAME + " - Not connected");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane right = new JSplitPane(JSplitPane.VERTICAL_SPLIT, revisionPanel, checkoutsPanel);

		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(300, 300));
		topPanel.add(treePanel, BorderLayout.WEST);
		topPanel.add(right, BorderLayout.CENTER);

		Console console = new Console();
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, console);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		setVisible(true);
		ConsoleAppender.setLogHandler(console);
		setSize(640, 550);
		LOGGER.info("Application started");
	}

	public void checkin(SProject project) {
		JFileChooser chooser = new JFileChooser();
		int showOpenDialog = chooser.showOpenDialog(this);
		if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			checkin(project, new FileDataSource(file), file.length());
		}
	}

	public void checkin(SProject project, DataSource dataSource, long fileSize) {
		String showInputDialog = JOptionPane.showInputDialog(Client.this, "Please give a short description of you changes", "Checkin",
				JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
		CheckinResult upload;
		try {
			upload = serviceHolder.getService().checkin(project.getId(), showInputDialog, fileSize, new DataHandler(dataSource));
			JOptionPane.showMessageDialog(this, "New revision number: " + upload.getRevisionNr(), "Checkin succesfull", JOptionPane.OK_OPTION
					| JOptionPane.INFORMATION_MESSAGE);
			revisionPanel.showProject(project);
		} catch (UserException e) {
			JOptionPane.showMessageDialog(this, e.getUserMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	void checkout(SRevision revision, OutputStream out, boolean report) {
		try {
			CheckoutResult checkout = serviceHolder.getService().checkout(revision.getProjectId(), revision.getId(), ResultType.IFC);
			try {
				InputStream inputStream = checkout.getFile().getInputStream();
				byte[] buffer = new byte[1024];
				int red = inputStream.read(buffer);
				int totalRed = 0;
				while (red != -1) {
					out.write(buffer, 0, red);
					totalRed += red;
					red = inputStream.read(buffer);
				}
				out.close();
				if (report) {
					JOptionPane.showMessageDialog(Client.this, "Revision: " + revision.getId() + "\n" + totalRed + " bytes written", "Checkout succesfull",
							JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
				}
				SProject project = new SProject();
				project.setName(revision.getProjectName());
				checkoutsPanel.showProject(project);
			} catch (IOException e1) {
				e1.printStackTrace();
			}		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	void checkout(SRevision revision) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("IFC File", "ifc"));
		int showSaveDialog = chooser.showSaveDialog(this);
		if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			FileOutputStream fileOutputStream;
			try {
				fileOutputStream = new FileOutputStream(selectedFile);
				checkout(revision, fileOutputStream, true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void showProject(SProject project) {
		revisionPanel.showProject(project);
		checkoutsPanel.showProject(project);
	}

	public void showUser(SUser user) {
		revisionPanel.showUser(user);
		checkoutsPanel.showUser(user);
	}

	public void processChangeSet(SProject project) {
		JFileChooser chooser = new JFileChooser();
		int showOpenDialog = chooser.showOpenDialog(this);
		if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			processChangeSet(project, file);
		}
	}

	private void processChangeSet(SProject project, File file) {
		String showInputDialog = JOptionPane.showInputDialog(Client.this, "Please give a short description of you changes", "Process ChangeSet",
				JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
		JAXBContext context;
		ChangeSet changeSet = null;
		try {
			context = JAXBContext.newInstance(ChangeSet.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			changeSet = (ChangeSet)unmarshaller.unmarshal(new FileInputStream(file));
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ChangeSetResult upload = serviceHolder.getService().processChangeSet(project.getId(), showInputDialog, changeSet);
			JOptionPane.showMessageDialog(this, "New revision number: " + upload.getNewRevisionNr(), "Processing of ChangeSet succesfull", JOptionPane.OK_OPTION
					| JOptionPane.INFORMATION_MESSAGE);
			revisionPanel.showProject(project);
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	public void download(SRevision revision) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("IFC File", "ifc"));
		int showSaveDialog = chooser.showSaveDialog(this);
		if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			FileOutputStream fileOutputStream;
			try {
				fileOutputStream = new FileOutputStream(selectedFile);
				download(revision.getProjectId(), revision.getId(), fileOutputStream, true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void download(int pid, int rid, FileOutputStream out, boolean report) {
		try {
			CheckoutResult checkout = serviceHolder.getService().download(pid, rid, ResultType.IFC);
			try {
				InputStream inputStream = checkout.getFile().getInputStream();
				byte[] buffer = new byte[1024];
				int red = inputStream.read(buffer);
				int totalRed = 0;
				while (red != -1) {
					out.write(buffer, 0, red);
					totalRed += red;
					red = inputStream.read(buffer);
				}
				out.close();
				if (report) {
					JOptionPane.showMessageDialog(Client.this, "Revision: " + rid + "\n" + totalRed + " bytes written", "Download succesfull",
							JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	public ServiceHolder getServiceHolder() {
		return serviceHolder;
	}

	public void updateTree() {
		treePanel.updateTree();
	}

	public void expandTree() {
		treePanel.expandTree();
	}
}