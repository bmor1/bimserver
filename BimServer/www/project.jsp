<%@page import="java.util.List"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SCheckout"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.serializers.EmfSerializerFactory"%>
<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.rights.RightsManager"%>
<%@page import="org.bimserver.shared.SRevisionSummary"%>
<%@page import="org.bimserver.shared.SRevisionIdComparator"%>
<%@page import="org.bimserver.shared.SCheckoutDateComparator"%>
<%@page import="org.bimserver.shared.SUserNameComparator"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTag"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.interfaces.objects.SObjectState"%>
<%@page import="org.bimserver.interfaces.objects.SSIPrefix"%>
<%@page	import="org.bimserver.interfaces.objects.SClashDetectionSettings"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="org.bimserver.shared.SProjectNameComparator"%>
<%@page import="org.bimserver.database.store.SIPrefix"%>
<%@page import="org.bimserver.utils.WebUtils"%>
<%@page import="org.bimserver.interfaces.objects.SCheckinState"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp"%>
<%
	if (loginManager.getService().isLoggedIn()) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
		long poid = Long.parseLong(request.getParameter("poid"));
		try {
	SProject project = loginManager.getService().getProjectByPoid(poid);
	SClashDetectionSettings sClashDetectionSettings = loginManager.getService().getClashDetectionSettings(project.getClashDetectionSettingsId());
	List<SRevision> revisions = loginManager.getService().getAllRevisionsOfProject(poid);
	Collections.sort(revisions, new SRevisionIdComparator(false));
	List<SRevision> revisionsInc = loginManager.getService().getAllRevisionsOfProject(poid);
	Collections.sort(revisionsInc, new SRevisionIdComparator(false));
	List<SCheckout> checkouts = loginManager.getService().getAllCheckoutsOfProjectAndSubProjects(poid);
	Collections.sort(checkouts, new SCheckoutDateComparator());
	List<SCheckout> activeCheckouts = new ArrayList<SCheckout>();
	for (SCheckout checkout : checkouts) {
		if (checkout.isActive()) {
			activeCheckouts.add(checkout);
		}
	}
	List<SUser> users = loginManager.getService().getAllAuthorizedUsersOfProject(poid);
	Collections.sort(users, new SUserNameComparator());
	List<SUser> nonAuthorizedUsers = loginManager.getService().getAllNonAuthorizedUsersOfProject(poid);
	SRevision lastRevision = null;
	if (project.getLastRevisionId() != -1) {
		lastRevision = loginManager.getService().getRevision(project.getLastRevisionId());
	}
	boolean anonymousAccess = project.getHasAuthorizedUsers().contains(loginManager.getService().getAnonymousUser().getOid());
	boolean hasUserManagementRights = project.getHasAuthorizedUsers().contains(loginManager.getUoid());
	boolean userHasCheckinRights = loginManager.getService().userHasCheckinRights(project.getOid());
	boolean hasEditRights = loginManager.getService().userHasRights(project.getOid());
	boolean hasCreateProjectRights = (loginManager.getUserType() == SUserType.ADMIN || ServerSettings.getSettings().isAllowUsersToCreateTopLevelProjects());
if (emfSerializerFactory.resultTypeEnabled(ResultType.O3D_JSON) && lastRevision != null) {
%>
<jsp:include page="o3d.jsp"/>
<%
}
%>
<div class="sidebar">
<ul>
<% if (hasEditRights) { %> <li><a class="link"
	href="editproject.jsp?poid=<%=poid %>">Edit</a></li>
<% } %>
<%
	if (emfSerializerFactory.resultTypeEnabled(ResultType.O3D_JSON) && lastRevision != null) {
%>
<li>
 <a id="visualiselink" class="link">Visualise</a></li>
 <%} %> 
 <%
if (lastRevision != null) {
%>
<li>
 <a id="browserlink" class="link">Browser</a></li>
 <%} %>
 <li><a class="rss"	href="<%=request.getContextPath() %>/syndication/revisions?poid=<%=poid %>">Revisions feed</a></li>
 <li><a class="rss" href="<%=request.getContextPath() %>/syndication/checkouts?poid=<%=poid %>">Checkouts feed</a></li>
 </ul>
 <br/>
<%=JspHelper.showProjectTree(project, loginManager.getService()) %>
</div>

<div class="content">
<%if (request.getParameter("message") != null) {
	out.println("<div class=\"error\">" + request.getParameter("message") + "</div>");
}
%>
<div id="guide">
  <div id="guidewrap">
    <ol id="breadcrumb">
	  <li><%= JspHelper.generateBreadCrumbPath(project, loginManager.getService()) %></li>
    </ol>
  </div>
</div>
<h1>Project details (<%=project.getName() %>)</h1>
<div class="tabber" id="projecttabber">
<div class="tabbertab" id="detailstab" title="Details">
<% if (project.getRevisions().isEmpty()) { %> <% if (userHasCheckinRights) { %>
<div class="info"><img src="images/warning.png" alt="warning" />There
are no revisions yet, click <a id="revisiontablink" href="#">on the
revisions tab</a> to add a first revision, or <a id="subprojecttablink"
	href="#">add a subproject.</a></div>
<% } %> <%}%>
<table class="formtable">
	<tr>
		<td class="first">Name</td>
		<td><%=project.getName() %></td>
	</tr>
	<%
	if (project.getParentId() != -1) {
		SProject parentProject = loginManager.getService().getProjectByPoid(project.getParentId());
%>
	<tr>
		<td class="first">Parent</td>
		<td><a href="project.jsp?poid=<%=parentProject.getOid() %>"><%=parentProject.getName() %></a></td>
	</tr>
	<%
	}
	SUser createdBy = loginManager.getService().getUserByUoid(project.getCreatedById());
	SGeoTag geoTag = loginManager.getService().getGeoTag(project.getGeoTagId());
%>
	<tr>
		<td class="first">Created on</td>
		<td><%=dateFormat.format(project.getCreatedDate()) %></td>
	</tr>
	<tr>
		<td class="first">Created by</td>
		<td><a href="user.jsp?uoid=<%=createdBy.getOid()%>"><%=createdBy.getUsername() %></a></td>
	</tr>
	<% if (lastRevision != null) {%>
	<tr>
		<td class="first">Last update on</td>
		<td><%=dateFormat.format(lastRevision.getDate()) %></td>
	</tr>
	<tr>
		<td class="first">Last update by</td>
		<td><a href="user.jsp?uoid=<%=lastRevision.getUserId() %>"><%=loginManager.getService().getUserByUoid(lastRevision.getUserId()).getUsername() %></a></td>
	</tr>
	<% } %>
	<tr>
		<td class="first">State</td>
		<td><%=project.getState().name().toLowerCase() %></td>
	</tr>
	<tr>
		<td class="first">Anonymous access</td>
		<td><%=anonymousAccess %></td>
	</tr>
	<tr>
		<td class="first">Description</td>
		<td><%=project.getDescription() %></td>
	</tr>
<% if (emfSerializerFactory.resultTypeEnabled(ResultType.KMZ)) {
	String url = WebUtils.getWebServer(request.getRequestURL().toString());
	String link = "http://" + url + getServletContext().getContextPath() + "download?poid=" + project.getOid() + "&resultType=KMZ";
%>
	<tr>
		<td class="first">Google Earth Link</td>
		<td><a href="<%=link %>"><%=link %></a></td>
	</tr>
<% } %>
	<tr>
		<td class="first">Uniform length measure unit for combined
		revisions</td>
		<% if (project.getExportLengthMeasurePrefix() == null){ project.setExportLengthMeasurePrefix(SSIPrefix.meter);} %>
		<td><%=project.getExportLengthMeasurePrefix().name() %></td>
	</tr>
	<% if (geoTag.isEnabled()) { %>
	<tr>
		<td class="first">Coordinates</td>
		<td><%=geoTag.getX() + "," + geoTag.getY() + "," + geoTag.getZ() %></td>
	</tr>
	<tr>
		<td class="first">Direction angle</td>
		<td><%=geoTag.getDirectionAngle() %></td>
	</tr>
	<tr>
		<td class="first">EPSG</td>
		<td><%=geoTag.getEpsg() %></td>
	</tr>
	<% } %>
</table>
<br />
<%if (lastRevision != null) { %> Click <a
	href="revision.jsp?roid=<%=lastRevision.getOid() %>">here</a> to go to
the latest revision<br />
<br />
<p></p>
<div class="tabber" id="downloadtabber">
<div class="tabbertab" id="detailstab" title="Simple Download">
<form action="<%=request.getContextPath() %>/download" method="get">
Download: <input type="hidden" name="roid"
	value="<%=project.getLastRevisionId() %>" /> <select name="resultType" id="detailsdownloadcheckoutselect">
	<%
	for (ResultType resultType : emfSerializerFactory.getMultipleResultTypes()) {
%>
	<option value="<%=resultType.name() %>"
		<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : "" %>><%= resultType.getNiceName() %></option>
	<%	
	}
%>
</select> <label for="simplezip_<%=lastRevision.getId() %>">Zip </label><input
	type="checkbox" name="zip" id="simplezip_<%=lastRevision.getId() %>" />
<input name="download" type="submit" value="Download">
<% if (userHasCheckinRights) { %>
<input name="checkout" type="submit" value="Checkout" id="detailscheckoutbutton">
<% } %>
</form>
</div>
<div class="tabbertab" id="" title="Advanced Download">
<script>
var projects = new Object();
<%=JspHelper.writeDownloadProjectTreeJavaScript(project, loginManager) %>
</script>
<form method="get" action="<%=request.getContextPath() %>/download">
<table class="formatted maintable">
	<tr>
		<th>Project</th>
		<th>Last revision</th>
		<th>Revision</th>
	</tr>
	<%=JspHelper.writeDownloadProjectTree("download", project, loginManager, 0, null) %>
</table>
Download: <select name="resultType">
	<%
	for (ResultType resultType : emfSerializerFactory.getMultipleResultTypes()) {
%>
	<option value="<%=resultType.name() %>"
		<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : "" %>><%= resultType.getNiceName() %></option>
	<%	
	}
%>
</select> <label for="advancedzip_<%=lastRevision.getId() %>">Zip </label><input
	type="checkbox" name="zip" id="advancedzip_<%=lastRevision.getId() %>" />
<input type="submit" value="Download"> <input type="hidden"
	name="multiple" value="true" /></form>
</div>
</div>
<% } %>
</div>
<div class="tabbertab" id="subprojectstab"
	title="Sub Projects<%=project.getSubProjects().size() == 0 ? "" : " (" + project.getSubProjects().size() + ")" %>">
<% if (hasCreateProjectRights) { %> <a
	href="addproject.jsp?parentoid=<%=project.getOid() %>">Add sub project</a><br />
<br />
<%
}
	if (project.getSubProjects().size() == 0) {
%> <div class="none">No subprojects</div> <%
	} else {
%>
<table class="formatted">
	<tr>
		<th>Name</th>
		<th>Last Revision</th>
		<th>Revisions</th>
		<th>Checkouts</th>
		<th>Authorized users</th>
		<% if (userHasCheckinRights) { %>
		<th>Actions</th>
		<% } %>
	</tr>
	<%
	Set<SProject> subProjects = new TreeSet<SProject>(new SProjectNameComparator());
	for (long subPoid : project.getSubProjects()) {
		SProject subProject = loginManager.getService().getProjectByPoid(subPoid);
		subProjects.add(subProject);
	}
	for (SProject subProject : subProjects) {
		SRevision lastSubProjectRevision = null;
		if (subProject.getLastRevisionId() != -1) {
			lastSubProjectRevision = loginManager.getService().getRevision(subProject.getLastRevisionId());
		}
%>
	<tr <%=(loginManager.getService().userHasCheckinRights(subProject.getOid()) == true ? "" : " class=\"checkinrights\"")%>
		<%=subProject.getState() == SObjectState.DELETED ? " class=\"deleted\"" : "" %>>
		<td><a href="project.jsp?poid=<%=subProject.getOid() %>"><%=subProject.getName() %></a></td>
		<td><%=lastSubProjectRevision == null ? "No revisions" : ("<a href=\"revision.jsp?roid=" + lastSubProjectRevision.getOid() + "\">" + lastSubProjectRevision.getId() + "</a> by <a href=\"user.jsp?id=" + lastSubProjectRevision.getUserId() + "\">" + loginManager.getService().getUserByUoid(lastSubProjectRevision.getUserId()).getUsername() + "</a>")%></td>
		<td><%=subProject.getRevisions().size() %></td>
		<td><%=subProject.getCheckouts().size() %></td>
		<td><%=subProject.getHasAuthorizedUsers().size() %></td>
		<% if (userHasCheckinRights) { %>
		<% if (subProject.getState() == SObjectState.ACTIVE) { %>
		<td><a
			href="deleteproject.jsp?ppid=<%=project.getOid() %>&poid=<%=subProject.getOid() %>">delete</a></td>
		<% } else if (subProject.getState() == SObjectState.DELETED) { %>
		<td><a
			href="undeleteproject.jsp?ppid=<%=project.getOid() %>&poid=<%=subProject.getOid() %>">undelete</a></td>
		<% } %>
		<% } %>
	</tr>
	<%
	}
%>
</table>
<% } %>
</div>

<div class="tabbertab" id="revisionstab"
	title="Revisions<%=revisions.size() == 0 ? "" : " (" + revisions.size() + ")"%>">
<%
	String checkoutWarning = loginManager.getService().getShowCheckoutWarning(project.getOid(), loginManager.getUoid());
	if (checkoutWarning != null) {
		out.write("<div class=\"warning\"><img src=\"images/warning.png\" alt=\"warning\" />" + checkoutWarning + "</div>");
	}
	if (userHasCheckinRights) {
%> <a href="#" id="uploadlink">Upload (note: Subprojects present)</a>
<div id="upload"><jsp:include page="upload.jsp">
	<jsp:param name="poid" value="<%=poid %>" />
</jsp:include> <%
	List<SProject> projects = loginManager.getService().getAllProjects();
	if (!projects.isEmpty() && (projects.size() > 1 || !projects.get(0).getRevisions().isEmpty())) {
	boolean atLeastOne = false;
	for (SProject sProject : projects) {
		if (!sProject.getRevisions().isEmpty()) {
			atLeastOne = true;
			break;
		}
	}
	if (atLeastOne) {
%>
<form method="post" action="branch.jsp">
<fieldset>
<legend>Checkin existing revision</legend>
 <label>Project/Revision</label>
<select name="roid">
	<%
		for (SProject sProject : projects) {
			if (!sProject.getRevisions().isEmpty()) {
%>
	<optgroup label="<%=sProject.getName() %>">
		<%
		List<SRevision> checkinRevisions = loginManager.getService().getAllRevisionsOfProject(sProject.getOid());
		Collections.sort(checkinRevisions, new SRevisionIdComparator(false));
	for (SRevision sRevision : checkinRevisions) {
%>
		<option value="<%=sRevision.getOid() %>"><%=sRevision.getId() %></option>
		<%}
%>
	</optgroup>
	<%
}
}
%>
</select> <label>Comment</label> <input type="text" name="comment" /> <input
	type="submit" value="Checkin as new revision" /> <input type="hidden"
	name="action" value="branchtoexistingproject" /> <input type="hidden"
	name="destpoid" value="<%=poid %>" />
</fieldset>
</form>
<% }
} %>
</div>
<%
	}
	if (revisions.size() > 1) {
%>
<fieldset><legend>Compare</legend>
<div id="compareajaxloader">Comparing... <img
	src="images/ajax-loader.gif" /></div>
<form method="get" action="compare.jsp" id="compareform"><input
	type="hidden" name="poid" value="<%=poid %>" /> Revision <select
	name="roid1">
	<%
for (SRevision otherRevision : revisionsInc) {
%>
	<option value="<%=otherRevision.getOid() %>"><%=otherRevision.getId() %></option>
	<%
}
%>
</select> with Revision <select name="roid2">
	<%
for (SRevision otherRevision : revisionsInc) {
%>
	<option value="<%=otherRevision.getOid() %>"><%=otherRevision.getId() %></option>
	<%
}
%>
</select>
<select name="type">
<option value="ALL">All</option>
<option value="ADD">Added</option>
<option value="MODIFY">Modified</option>
<option value="DELETE">Deleted</option>
</select>
<button type="submit" name="compare" value="Compare">Compare</button>
</form>
</fieldset>
<%}
if (revisions.size() > 0) {	
%>
<table class="formatted">
	<tr>
		<th>Id</th>
		<th>Date</th>
		<th>User</th>
		<th>Comment</th>
		<% if (project.getParentId() == -1 && sClashDetectionSettings.isEnabled()) { %>
		<th>Clashes</th>
		<% } %>
		<th>Size</th>
		<th>Status / Actions</th>
	</tr>
	<%
		for (SRevision revision : revisions) {
			SUser revisionUser = loginManager.getService().getUserByUoid(revision.getUserId());
			boolean isTagged = revision.getTag() != null;
%>
	<tr <%=isTagged?"class=\"tagged\"":""%> id="rev<%=revision.getOid() %>"
		<%=lastRevision != null && revision.getId() == lastRevision.getId() ? "class=\"lastrevision\"" : "" %>>
		<td><a href="revision.jsp?roid=<%=revision.getOid() %>"><%=revision.getId() %></a></td>
		<td style="white-space: nowrap;"><%=dateFormat.format(revision.getDate()) %></td>
		<td><a href="user.jsp?uoid=<%=revision.getUserId() %>"><%=revisionUser.getUsername() %></a></td>
		<td><div class="commentbox">
			<div><%=revision.getComment()%></div><a href="#" class="morelink">more</a>
		</div></td>
		<% if (project.getParentId() == -1 && sClashDetectionSettings.isEnabled()) { %>
		<td class="clashesfield">
		<img src="images/ajax-loader.gif" align="left" style="margin-right: 5px; display: <%=revision.getState() == SCheckinState.SEARCHING_CLASHES ? "block" : "none"%>"/>
		<span class="statusfield"><%
			if (revision.getState() == SCheckinState.DONE) {
				out.print(revision.getLastClashes().size());
			} else if (revision.getState() == SCheckinState.SEARCHING_CLASHES) {
				out.print("Searching clashes...");
			} else if (revision.getState() == SCheckinState.CLASHES_ERROR) {
				out.print("Error: " + revision.getLastError());
			}
		%>
		</span>
		</td>
		<% } %>
		<td class="sizefield"><%=(revision.getState() == SCheckinState.DONE || revision.getState() == SCheckinState.SEARCHING_CLASHES || revision.getState() == SCheckinState.CLASHES_ERROR) ? revision.getSize() : "" %></td>
		<td class="downloadfield">
		<img src="images/ajax-loader.gif" align="left" style="margin-right: 5px; display: <%=(revision.getState() == SCheckinState.DONE || revision.getState() == SCheckinState.ERROR || revision.getState() == SCheckinState.CLASHES_ERROR || revision.getState() == SCheckinState.SEARCHING_CLASHES) ? "none" : "block"%>"/>
		<span class="statusfield">
		<%
			if (revision.getState() == SCheckinState.ERROR) {
				out.print("Error: " + revision.getState().name().toLowerCase());
			} else if (revision.getState() == SCheckinState.STORING) {
				out.print("Storing...");
			}
		%>
		</span>
		<form method="get" action="<%=request.getContextPath() %>/download" class="<%=revision.getState() == SCheckinState.DONE || revision.getState() == SCheckinState.CLASHES_ERROR || revision.getState() == SCheckinState.SEARCHING_CLASHES ? "" : "blockinvisible" %>">
		<input type="hidden" name="roid" value="<%=revision.getOid() %>" />
<select name="resultType" class="revisionsdownloadcheckoutselect">
			<%
	for (ResultType resultType : emfSerializerFactory.getMultipleResultTypes()) {
%>
			<option value="<%=resultType.name() %>"
				<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : "" %>><%=resultType.getNiceName() %></option>
			<%	
	}
%>
		</select> <label for="revisionzip_<%=revision.getId() %>">Zip </label><input
			type="checkbox" name="zip" id="revisionzip_<%=revision.getId() %>" />
		<input name="download" type="submit" value="Download" />
<% if (userHasCheckinRights) { %>
		<input name="checkout" type="submit" value="Checkout" class="revisionscheckoutbutton" />
<% } %>
		</form>
		</td>
	</tr>
	<%
		}
%>
</table>
<%
	} else {
%>
<div class="none">No revisions<%=userHasCheckinRights ? ", upload an IFC file" : "" %></div>
<%
	}
%></div>
<%
	if (lastRevision != null) {
%>
<div class="tabbertab" id="querytab" title="Query">Note: Queries
will be done on the latest revision (<a
	href="revision.jsp?roid=<%=lastRevision.getOid() %>"><%=lastRevision.getId() %></a>),
open a specific revision to query other revisions<br />
<br/>
<jsp:include page="query.jsp">
	<jsp:param name="poid" value="<%=poid %>" />
	<jsp:param name="roid" value="<%=lastRevision.getOid() %>" />
</jsp:include></div>
<div id="clashes" class="tabbertab" title="Clashes">
<div id="clashdetectiondiv"></div>
</div>
<%
}
%> <%
	if (checkouts.size() > 0) {
%>
<div class="tabbertab" id="checkoutstab"
	title="Checkouts<%=checkouts.size() == 0 ? "" : " (" + activeCheckouts.size() + ")" %>">
<%
	boolean showCheckoutToggle = false;
	for (SCheckout checkout : checkouts) {
		if (!checkout.isActive()) {
			showCheckoutToggle = true;
		}
	}
	if (showCheckoutToggle) {
%>
<label for="showinactivecheckouts">Show inactive checkouts </label><input id="showinactivecheckouts" type="checkbox"/>
<% } %>
<table class="formatted">
	<tr>
		<th>Revision Id</th>
		<th>User</th>
		<th>Date</th>
		<th>Active</th>
		<th>Status / Actions</th>
	</tr>
	<%
		for (SCheckout checkout : checkouts) {
			SUser checkoutUser = loginManager.getService().getUserByUoid(checkout.getUserId());
%>
	<tr class="<%=checkout.isActive() ? "" : "inactivecheckoutrow" %>">
		<td><a href="revision.jsp?roid=<%=checkout.getRevisionId() %>"><%=loginManager.getService().getRevision(checkout.getRevisionId()).getId() %></a></td>
		<td><a href="user.jsp?uoid=<%=checkout.getUserId() %>"><%=checkoutUser.getUsername() %></a></td>
		<td><%=dateFormat.format(checkout.getDate()) %></td>
		<td><%=checkout.isActive() %></td>
		<td>
		<form method="get" action="<%=request.getContextPath() %>/download">
		<input type="hidden" name="roid"
			value="<%=checkout.getRevisionId() %>" /> <select name="resultType">
			<%
	for (ResultType resultType : emfSerializerFactory.getMultipleResultTypes()) {
%>
			<option value="<%=resultType.name() %>"
				<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : "" %>><%=resultType.getNiceName() %></option>
			<%	
	}
%>
		</select> <label for="checkoutsdownloadzip_<%=checkout.getOid() %>">Zip </label><input type="checkbox" name="zip" id="checkoutsdownloadzip_<%=checkout.getOid() %>" /> <input name="download" type="submit" value="Download" />
			</form>
		</td>
	</tr>
	<%
		}
%>
</table>
</div>
<%
	}
%>
<div class="tabbertab" id="authorizeduserstab"
	title="Authorized users<%=users.size() == 0 ? "" : " (" + users.size() + ")" %>">
<% if (nonAuthorizedUsers.size() > 0 && hasUserManagementRights) { %>
<form method="post" action="addusertoproject.jsp"><select
	name="uoid">
	<%
	for (SUser user : nonAuthorizedUsers) {
%>
	<option value="<%=user.getOid() %>"><%=user.getName() + " (" + user.getUsername() + ")" %></option>
	<%
	}
%>
</select> <input type="hidden" name="poid" value="<%=poid %>" /> <input
	type="hidden" name="type" value="project" /> <input type="submit"
	value="Add" /></form>
<% } %> <%
	if (users.size() > 0) {
%>
<table class="formatted">
	<tr>
		<th>Name</th>
		<th>Username</th>
		<th>Type</th>
		<% if (userHasCheckinRights) { %>
		<th>Actions</th>
		<% } %>
	</tr>
	<%
		for (SUser user : users) {
%>
	<tr>
		<td><a href="user.jsp?uoid=<%=user.getOid() %>"><%=user.getName() %></a></td>
		<td><a href="user.jsp?uoid=<%=user.getOid() %>"><%=user.getUsername() %></a></td>
		<td><%=JspHelper.getNiceUserTypeName(user.getUserType()) %></td>
		<% if (userHasCheckinRights) { %>
		<td>
		<% if (hasUserManagementRights && user.getUserType() != SUserType.ADMIN) { %><a
			href="revokepermission.jsp?type=project&poid=<%=poid %>&amp;uoid=<%=user.getOid() %>">revoke</a>
		<% } %>
		</td>
		<% } %>
	</tr>
	<%
		}
%>
</table>
<%
	} else {
%>
<div class="none">None</div>
<%
	}
%>
</div>
</div>
<script>
	var poid = <%=poid%>;
	var lastRevisionOid = <%=lastRevision == null ? -1 : lastRevision.getOid()%>;
	$(document).ready(function(){
		$("#revisiontablink").click(function (){
			document.getElementById("projecttabber").tabber.tabShow(2);	
			return false;
		});
		$("#subprojecttablink").click(function (){
			document.getElementById("projecttabber").tabber.tabShow(1);
			return false;
		});
		<%
		if (!loginManager.getService().getSubProjects(project.getOid()).isEmpty()) {
%>
			$("#uploadlink").show();
			$("#uploadlink").click(function(){
				$("#upload").show();
				$("#uploadlink").hide();
			});
			$("#upload").hide();
<%
		} else {
%>
			$("#upload").show();
			$("#uploadlink").hide();
<%
		}
%>
		var updateInactiveCheckouts = function(){
			if ($('#showinactivecheckouts').is(':checked')) {
				$(".inactivecheckoutrow").show();
			} else {
				$(".inactivecheckoutrow").hide();
			}
		}
		$("#showinactivecheckouts").change(updateInactiveCheckouts);
		updateInactiveCheckouts();
		var refreshFunction = function() {
			$.ajax({ url: "/progress", cache: false, context: document.body, data: {poid: poid}, success: function(data){
				if (data.lastRevision != lastRevisionOid) {
					location.reload();
				} else {
					revisions = data.revisions;
					for (result in revisions) {
						var item = revisions[result];
						var state = item.state;
						if (state == "DONE") {
							$("#rev" + item.roid).children(".sizefield").text(item.totalsize);
							$("#rev" + item.roid).children(".downloadfield").children("img").hide();
							$("#rev" + item.roid).children(".downloadfield").children("form").removeClass("blockinvisible");
							$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("");
							$("#rev" + item.roid).children(".clashesfield").children("img").hide();
							$("#rev" + item.roid).children(".clashesfield").children(".statusfield").text(item.clashes);
						} else if (state == "ERROR") {
							$("#rev" + item.roid).children(".downloadfield").children("img").hide();
							$("#rev" + item.roid).children(".downloadfield").children("form").addClass("blockinvisible");
							$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("Error: " + item.lastError);
							$("#rev" + item.roid).children(".clashesfield").children("img").hide();
						} else if (state == "SEARCHING_CLASHES") {
							$("#rev" + item.roid).children(".clashesfield").children("img").show();
							$("#rev" + item.roid).children(".clashesfield").children(".statusfield").text("Searching clashes...");
							$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("");
							$("#rev" + item.roid).children(".downloadfield").children("form").removeClass("blockinvisible");
							$("#rev" + item.roid).children(".downloadfield").children("img").hide();
						} else if (state == "CLASHES_ERROR") {
							$("#rev" + item.roid).children(".clashesfield").children("img").hide();
							$("#rev" + item.roid).children(".clashesfield").children(".statusfield").text("Error: " + item.lastError);
							$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("");
							$("#rev" + item.roid).children(".downloadfield").children("form").removeClass("blockinvisible");
							$("#rev" + item.roid).children(".downloadfield").children("img").hide();
						} else {
							$("#rev" + item.roid).children(".downloadfield").children("img").show();
							$("#rev" + item.roid).children(".downloadfield").children("form").addClass("blockinvisible");
							if (state == "STORING") {
								$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("Storing...");
							} else {
								$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("");
							}
							$("#rev" + item.roid).children(".clashesfield").children("img").hide();
						} 
						if (item.islast) {
							$("#rev" + item.roid).addClass("lastrevision");
						} else {
							$("#rev" + item.roid).removeClass("lastrevision");
						}
					}
			    }
			}});
		};
		refreshFunction();
		window.setInterval(refreshFunction, 2000);
	});
</script>
<%
	if (lastRevision != null) {
%>
<script>
	$(document).ready(function(){
		$("#compareajaxloader").hide();
		$("#browserajaxloader").hide();
		<%
			String clashesUrl = "clashes.jsp?poid=" + poid;
			if (request.getParameter("margin") != null) {
				clashesUrl += "&margin=" + request.getParameter("margin");
			}
			if (request.getParameter("revisions") != null) {
				clashesUrl += "&revisions=" + request.getParameter("revisions");
			}
			if (request.getParameter("ignore") != null) {
				clashesUrl += "&ignore=" + request.getParameter("ignore");
			}
		%>
		$("#clashdetectiondiv").load("<%=clashesUrl%>");
		$("#compareform").submit(function(){
			$("#compareform").hide();
			$("#compareajaxloader").show();
		});
		$("#browserajaxlink").click(function(){
			$("#browserajaxloader").show();
			$("#browser").load("browser.jsp?roid=<%=lastRevision.getOid()%>");
		});
		$(".commentbox div").css("height", "18px");
		$(".commentbox div").css("width", "200px");
		$(".commentbox div").css("overflow", "hidden");
		$(".commentbox div").each(function(index, element){
			if ($(element).attr("scrollHeight") == 18) {
				$(element).parent().children("a").hide();
			}
		});
		$(".commentbox .morelink").click(function(event){
			$(event.target).parent().children("div").css("height", "auto");
			$(event.target).parent().children("div").css("overflow", "visible");
			$(event.target).hide();
			return false;
		});

		checkDetailsCheckoutButton = function(){
			$("#detailscheckoutbutton").attr("disabled", $("#detailsdownloadcheckoutselect").val() != "IFC" && $("#detailsdownloadcheckoutselect").val() != "IFCXML");
		};
		$("#detailsdownloadcheckoutselect").change(checkDetailsCheckoutButton);
		checkDetailsCheckoutButton();

		checkRevisionsCheckoutButton = function(event){
			$(event.target).parent().children(".revisionscheckoutbutton").attr("disabled", $(event.target).val() != "IFC" && $(event.target).val() != "IFCXML");
		};
		$(".revisionsdownloadcheckoutselect").change(checkRevisionsCheckoutButton);

		$("#visualiselink").click(function(){
			showOverlay("Visualisation", "visualize.jsp?roid=<%=project.getLastRevisionId() %>");
			return false;
		});

		$("#browserlink").click(function(){
			showOverlay("Browser", "browser.jsp?roid=<%=project.getLastRevisionId() %>");
			return false;
		});
		
		updateTreeSelectListeners();
	});
	
	function setOffSupers(baseName, pid) {
		var project = projects["project" + pid];
		if (project.superproject != null && project.superproject != "undefined") {
			$("#" + baseName + "_" + project.superproject.id).val("[off]");
			setOffSupers(baseName, project.superproject.id);
		}
	}
	
	function setOffSubs(baseName, pid) {
		var project = projects["project" + pid];
		for (var i in project.subprojects) {
			$("#" + baseName + "_" + project.subprojects[i].id).val("[off]");
			setOffSubs(baseName, project.subprojects[i].id);
		}
	}
	
	function updateTreeSelectListeners() {
		$(".treeselect").change(function(e){
			var idString = e.target.id;
			var baseName = idString.substring(0, idString.indexOf("_"));
			var id = idString.substring(idString.indexOf("_") + 1);
			if ($("#" + baseName + "_" + id).val() != "[off]") {
				var revisionId = e.target.value;
				var project = projects["project" + id];
				setOffSupers(baseName, project.id);
				setOffSubs(baseName, project.id);
			}
		});
	}
</script>
<%
	}
		} catch (UserException e) {
			if (e.getCause() instanceof OutOfMemoryError) {
				response.sendRedirect(getServletContext().getContextPath());
			} else {
				e.printStackTrace();
				out.println(e.getUserMessage());
			}
		}
	}
%>
</div>
<jsp:include page="footer.jsp" />