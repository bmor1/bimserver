<%@page import="org.bimserver.settings.ServerSettings"%>
<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="org.bimserver.version.Version"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.settings.Settings"%>
<jsp:useBean id="serverInfo" scope="application" class="org.bimserver.ServerInfo" />
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<jsp:useBean id="errorMessages" scope="request" class="org.bimserver.ErrorMessages" />
<jsp:include page="htmlheader.jsp" />
<%
	if (serverInfo.isAvailable()) {
%>
<div class="sitewrapper">
<div class="header"><a href="main.jsp"> <%
 	Version version = VersionChecker.getInstance().getLocalVersion();
 		Settings settings = ServerSettings.getSettings();
 %> <img class="headerimage"
	src="<%=settings.getCustomLogoAddress() != null ? settings.getCustomLogoAddress() : "images/logo.gif"%>" alt="BIMserver" title="BIMserver <%=version.getVersion()%>" /></a> <%
 	if (loginManager.getService().isLoggedIn()) {
 %>
<div class="menubar">
You are logged in as: <a href="user.jsp?uoid=<%=loginManager.getService().getLoggedInUser().getOid()%>"><%=loginManager.getService().getLoggedInUser().getName()%></a> - <a href="logout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;<br/>
<br/>
<jsp:include page="mainmenu.jsp" />
</div>
<jsp:include page="extra.jsp" /> <%
 	} else {
 			if (request.getSession().getAttribute("loggingout") == null) {
 				request.getSession().removeAttribute("loggingout");
 				Map<String, String> cookies = new HashMap<String, String>();
 				if (request.getCookies() != null) {
 				for (Cookie cookie : request.getCookies()) {
 					cookies.put(cookie.getName(), cookie.getValue());
 				}
 				if (cookies.containsKey("autologin") && cookies.containsKey("username")) {
 					if (loginManager.getService().autologin(cookies.get("username"), cookies.get("autologin"))) {
 %>
<div class="menubar">
You are logged in as: <a href="user.jsp?uoid=<%=loginManager.getService().getLoggedInUser().getOid()%>"><%=loginManager.getService().getLoggedInUser().getName()%></a> - <a href="logout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;<br/>
<br/>
<jsp:include page="mainmenu.jsp" />
</div>
<br />
<br />
<jsp:include page="extra.jsp" /> <%
 	}
 				}
 				}
 			}
 			if (!loginManager.getService().isLoggedIn()) {
 				if (!request.getServletPath().equals("/login.jsp")) {
 					if (request.getQueryString() == null || request.getQueryString().trim().isEmpty()) {
	 					response.sendRedirect(request.getContextPath() + "/login.jsp?origurl="
	 							+ URLEncoder.encode(request.getRequestURI(), "UTF-8"));
 					} else {
	 					response.sendRedirect(request.getContextPath() + "/login.jsp?origurl="
	 							+ URLEncoder.encode(request.getRequestURI() + "?" + request.getQueryString(), "UTF-8"));
 					}
 				}
 			}
 		}
 	} else {
 %>
<div class="error"><%=serverInfo.getErrorMessage()%></div>
<%
	}
%>
</div>
<div class="main">