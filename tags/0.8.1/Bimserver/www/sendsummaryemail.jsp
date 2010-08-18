<%@page import="org.bimserver.shared.SProject"%>
<%@page import="org.bimserver.shared.SRevisionSummary"%>
<%@page import="org.bimserver.JspHelper"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@page import="org.bimserver.ServerSettings"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	try {
		String address = request.getParameter("address");
		int pid = Integer.parseInt(request.getParameter("pid"));
		SProject project = loginManager.getService().getProjectById(pid);
		int rid = Integer.parseInt(request.getParameter("rid"));
		
		String senderName = loginManager.getService().getCurrentUser().getName();
		String senderAddress = loginManager.getService().getCurrentUser().getUsername();
		if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
			senderAddress = ServerSettings.getSettings().getEmailSenderAddress();
		}
		
		Properties props = new Properties();
		props.put("mail.smtp.host", ServerSettings.getSettings().getSmtpServer());
	
		Session mailSession = Session.getDefaultInstance(props);
	
		Message msg = new MimeMessage(mailSession);
	
		InternetAddress addressFrom = new InternetAddress(senderAddress);
		addressFrom.setPersonal(senderName);
		msg.setFrom(addressFrom);
	
		InternetAddress[] addressTo = new InternetAddress[1];
		addressTo[0] = new InternetAddress(address);
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		msg.setSubject("BIMserver Revision Summary");
		SRevisionSummary revisionSummary = loginManager.getService().getRevisionSummary(pid, rid);
//		String html = JspHelper.writeSummaryTable(project, rid, revisionSummary);
//		msg.setContent(html, "text/html");
		Transport.send(msg);
		out.append("Revision summary succesfully e-mailed to " + address);
	} catch (Exception e) {
		out.append("An error has occured while sending revision summary: " + e.getMessage());
	}
%>