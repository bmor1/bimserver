package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.interfaces.SConverter;
import org.bimserver.models.store.NewProjectNotification;
import org.bimserver.models.store.NewRevisionNotification;
import org.bimserver.models.store.Notification;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.pb.NotificationInterfaceReflectorImpl;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.pb.Reflector;
import org.bimserver.shared.pb.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsManager extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);
	private final Set<NotificationContainer> listeners = new HashSet<NotificationContainer>();
	private final BlockingQueue<Notification> queue = new ArrayBlockingQueue<Notification>(1000);
	private final BimServer bimServer;
	private volatile boolean running;

	public NotificationsManager(BimServer bimServer) {
		setName("NotificationsManager");
		this.bimServer = bimServer;
	}

	public void register(User user, NotificationInterface notificationInterface) {
		listeners.add(new NotificationContainer(user, notificationInterface));
	}

	public void notify(Notification notification) {
		queue.add(notification);
	}

	@Override
	public void run() {
		initConnections();
		SConverter sConverter = new SConverter();
		running = true;
		try {
			while (running) {
				try {
					Notification notification = queue.take();
					for (NotificationContainer notificationContainer : listeners) {
						try {
							NotificationInterface notificationInterface = notificationContainer.getNotificationInterface();
							boolean isAdmin = notificationContainer.getUser().getUserType() == UserType.ADMIN;
							if (notification instanceof NewProjectNotification) {
								NewProjectNotification newProjectNotification = (NewProjectNotification)notification;
								Project project = newProjectNotification.getProject();
								if (isAdmin || RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(notificationContainer.getUser(), project)) {
									notificationInterface.newProject(sConverter.convertToSObject((NewProjectNotification) notification));
								}
							} else if (notification instanceof NewRevisionNotification) {
								NewRevisionNotification newRevisionNotification = (NewRevisionNotification) notification;
								Project project = newRevisionNotification.getRevision().getProject();
								if (isAdmin || RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(notificationContainer.getUser(), project)) {
									notificationInterface.newRevision(sConverter.convertToSObject(newRevisionNotification));
								}
							}
						} catch (Exception e) {
							LOGGER.error("", e);
						}
					}
				} catch (InterruptedException e) {
					throw e;
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		} catch (InterruptedException e) {
			if (running) {
				LOGGER.error("", e);
			}
		}
	}

	private void initConnections() {
		DatabaseSession databaseSession = bimServer.getDatabase().createSession();
		try {
			IfcModel allOfType = databaseSession.getAllOfType(StorePackage.eINSTANCE.getUser(), false, null);
			for (IdEObject idEObject : allOfType.getValues()) {
				if (idEObject instanceof User) {
					User user = (User) idEObject;
					String url = user.getNotificationUrl();
					if (url != null && !url.isEmpty()) {
						InetSocketAddress address = new InetSocketAddress(url.substring(0, url.indexOf(":")), Integer.parseInt(url.substring(url.indexOf(":") + 1)));
						try {
							SocketChannel channel = new SocketChannel();
							channel.connect(address);
							register(user, new NotificationInterfaceReflectorImpl(new Reflector(bimServer.getProtocolBuffersMetaData(), bimServer.getNotificationInterfaceService(), channel)));
						} catch (IOException e) {
							LOGGER.info("Notification host seems down: " + url);
						}
					}
				}
			}
			databaseSession.commit();
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			databaseSession.close();
		}
	}

	public void shutdown() {
		running = false;
		this.interrupt();
	}
}