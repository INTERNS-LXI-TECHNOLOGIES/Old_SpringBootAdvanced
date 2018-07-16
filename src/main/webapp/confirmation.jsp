<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
<link rel="stylesheet" type="text/css" href="css\mystyle.css">
<meta charset="UTF-8">
</head>
<body>
	<%@ page
		import="com.lxisoft.contacts.controller.*,java.util.*,com.lxisoft.contacts.model.Contact,java.io.*"%>
	<%
		Contact contact = null;
		if ((contact = (Contact) request.getAttribute("contact")) == null)
			contact = (Contact) session.getAttribute("currentContact");
		String language = (String) session.getAttribute("language");
		String resourcePath = ((language == null) || language.equals("ENG"))
				? "../webapps/"+request.getContextPath()+"/resource/english.properties"
				: "../webapps/"+request.getContextPath()+"/resource/malayalam.properties";
		language = ((language == null) || language.equals("ENG")) ? "മലയാളം" : "ENG";
		InputStreamReader reader = new InputStreamReader(new FileInputStream(resourcePath), "UTF-8");
		Properties props = new Properties();
		props.load(reader);
	%>
	<div class="jumbotron top">
		<img class="img-fluid contacts_icon" src="Images\contacts_2.png"
			alt="Contacts_icon">
		<h2><%=props.getProperty("contacts")%></h2>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 text-center">
				<div class="dialog"><%=props.getProperty("delete_message")%></div>
				<br> <a class="dialog-yes"
					href="delete?link=<%=contact.getPhoneNumber()%>"><%=props.getProperty("yes")%></a>
				<a class="dialog-no" href="getAll"><%=props.getProperty("no")%></a>

			</div>
		</div>
	</div>

</body>
</html>