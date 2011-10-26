package org.bimserver.servlets;

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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.bimserver.LoginManager;
import org.bimserver.shared.ChangeSet;
import org.bimserver.shared.UserException;

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 7852327471215749104L;

	public UploadServlet() {
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginManager loginManager = (LoginManager)request.getSession().getAttribute("loginManager");
		if (loginManager == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		int pid = -1;
		String comment = null;
		String type = null;
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = (List<FileItem>)upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				InputStream in = null;
				long size = 0;
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						if ("pid".equals(item.getFieldName())) {
							pid = Integer.parseInt(item.getString());
						}
						if ("comment".equals(item.getFieldName())) {
							comment = item.getString();
						}
						if ("type".equals(item.getFieldName())) {
							type = item.getString();
						}
					} else {
						size = item.getSize();
						in = item.getInputStream();
					}
				}
				if (pid != -1) {
					if (size == 0) {
						response.sendRedirect("project.jsp?id=" + pid + "&message=Uploaded file empty, or no file uploaded at all");
					} else {
						final InputStream realStream = in;
						if (type.equals("ifc")) {
							try {
								loginManager.getService().checkin(pid, comment, size, new DataHandler(new DataSource(){
									
									@Override
									public String getContentType() {
										return null;
									}
									
									@Override
									public InputStream getInputStream() throws IOException {
										return realStream;
									}
									
									@Override
									public String getName() {
										return null;
									}
									
									@Override
									public OutputStream getOutputStream() throws IOException {
										return null;
									}}));
								response.sendRedirect("project.jsp?id=" + pid);
							} catch (UserException e) {
								response.sendRedirect("project.jsp?id=" + pid + "&message=" + e.getCause().getMessage());
							}
						} else if (type.equals("changeset")) {
							try {
								JAXBContext context = JAXBContext.newInstance(ChangeSet.class);
								Unmarshaller unmarshaller = context.createUnmarshaller();
								ChangeSet changeSet = (ChangeSet)unmarshaller.unmarshal(realStream);
								loginManager.getService().processChangeSet(pid, comment, changeSet);
								response.sendRedirect("project.jsp?id=" + pid);
							} catch (JAXBException e) {
								e.printStackTrace();
							} catch (UserException e) {
								e.printStackTrace();
							}
						}
					}
				} else {
					response.getWriter().println("ERROR no pid");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
	}
}