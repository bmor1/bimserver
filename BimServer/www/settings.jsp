<%@page import="org.bimserver.interfaces.objects.SIgnoreFile"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.bimserver.ServerInitializer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.ServiceInterface"%>
<%@page import="org.bimserver.shared.UserException"%>
<div class="sidebar">
<ul>
	<li><a href="<%=getServletContext().getContextPath()%>/settings?action=downloadignorefile">Download ignore.xml</a></li>
	<li><a href="<%=getServletContext().getContextPath()%>/settings?action=downloadsettingsfile">Download settings.xml</a></li>
</ul>
</div>
<div class="content">
<%
	ServiceInterface service = loginManager.getService();
	if (request.getParameter("action") != null) {
		String action = request.getParameter("action");
		if (action.equals("disableSerializer")) {
			SSerializer serializer = loginManager.getService().getSerializerByName(request.getParameter("serializer"));
			serializer.setEnabled(false);
			loginManager.getService().updateSerializer(serializer);
		} else if (action.equals("enableSerializer")) {
			SSerializer serializer = loginManager.getService().getSerializerByName(request.getParameter("serializer"));
			serializer.setEnabled(true);
			loginManager.getService().updateSerializer(serializer);
		}
	}
%>
<div class="tabber" id="settingstabber">
<div class="tabbertab" id="ignorefilestab" title="Ignore files">
<a href="addignorefile.jsp">Add Ignore File</a>
<table class="formatted">
<tr><th>Name</th><th>Serializers</th><th>Actions</th></tr>
<%
	List<SIgnoreFile> ignoreFiles = service.getAllIgnoreFiles();
	for (SIgnoreFile ignoreFile : ignoreFiles) {
%>
	<tr>
		<td><%=ignoreFile.getName() %></td>
		<td><%=ignoreFile.getSerializers().size() %></td>
		<td><a href="editignorefile.jsp?ifid=<%=ignoreFile.getOid()%>">Edit</a> <a href="deleteignorefile.jsp?ifid=<%=ignoreFile.getOid()%>">Delete</a></td></tr>
<%
	}
%>
</table>
</div>
<div class="tabbertab" id="serializerstab" title="Serializers">
<a href="addserializer.jsp">Add Serializer</a>
<table class="formatted">
<tr><th>Name</th><th>Description</th><th>Type</th><th>Content Type</th><th>Ignore file</th><th>State</th><th>Actions</th></tr>
<%
	List<SSerializer> serializers = service.getAllSerializers(false);
	for (SSerializer serializer : serializers) {
		SIgnoreFile ignoreFile = null;
		if (serializer.getIgnoreFileId() != -1) {
			ignoreFile = service.getIgnoreFileById(serializer.getIgnoreFileId());
		}
%>
	<tr>
		<td><%=serializer.getName() %></td>
		<td><%=serializer.getDescription() %></td>
		<td><%=serializer.getClassName() %></td>
		<td><%=serializer.getContentType() %></td>
		<td><%=ignoreFile == null ? "none" : ignoreFile.getName() %></td>
		<td class="<%=serializer.isEnabled() ? "enabledSerializer" : "disabledSerializer" %>"> <%=serializer.isEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
<%
	if (serializer.isEnabled()) {
%>
<a href="settings.jsp?action=disableSerializer&serializer=<%=serializer.getName() %>">Disable</a>
<%
	} else {
%>
<a href="settings.jsp?action=enableSerializer&serializer=<%=serializer.getName() %>">Enable</a>
<%
	}
%>
			<a href="deleteserializer.jsp?sid=<%=serializer.getOid()%>">Delete</a>
		</td>
	</tr>
<%
	}
%>
</table>
</div>
</div>
<%@ include file="footer.jsp"%>