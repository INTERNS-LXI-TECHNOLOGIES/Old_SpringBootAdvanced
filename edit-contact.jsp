<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>Edit contact</title>
	<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css\mystyle.css">
	<meta charset="UTF-8">
</head>
<body>
	<%@ page import= "com.lxisoft.contacts.model.Contact, java.util.*,java.io.*" %>
	
	<% 	String language= (String)session.getAttribute("language");
        String resourcePath=((language==null) || language.equals("ENG"))?"../webapps/contacts-v4/resource/english.properties":"../webapps/contacts-v4/resource/malayalam.properties";
        language=((language==null) || language.equals("ENG"))?"മലയാളം":"ENG";
        InputStreamReader reader=new InputStreamReader(new FileInputStream(resourcePath),"UTF-8");
        Properties props = new Properties();
        props.load(reader);

		Contact contact=null;
		if((contact=(Contact)request.getAttribute("contact"))==null)
			contact=(Contact)session.getAttribute("currentContact");
	%>
	
	<div class="jumbotron top">
	<img class="img-fluid contacts_icon" src="Images\contacts_2.png" alt="Contacts_icon">	
	<h2><%= props.getProperty("contacts")%></h2>
	</div>
	<div class="container text-center">
	<div class="row">
	<div class="col-sm-2">
	</div>
	<form id="form1" class="form-horizontal form_style col-sm-8" action="get" method="POST">
		<label class="col-sm-3"><%= props.getProperty("first_name")%></label>
		<input class="col-sm-5" type="text" name="first_name"  pattern="[^,]+" required="" value=<%=contact.getFirstName()%>> <br>
		<label class="col-sm-3"><%= props.getProperty("last_name")%></label>
		<input class="col-sm-5" type="text" name="last_name" pattern="[^,]+" required="" value=<%=contact.getLastName()%>> <br>
		<label class="col-sm-3"><%= props.getProperty("phone_number")%></label>
		<input class="col-sm-5" type="tel" name="phone_number" pattern="[6789][0-9]{9}" required="" value=<%=contact.getPhoneNumber()%> placeholder="+91" readonly=""> <br>
		<label class="col-sm-3"><%= props.getProperty("email")%>&nbsp;</label>
		<input class="col-sm-5" type="email" name="email" checked="checked" pattern="[^,]+"	value=<%=contact.getEmail()%> required="" ><br><br>
		<input type="submit" value=<%= props.getProperty("update")%>>
	</form>
	</div>
	</div>	
</body>
</html>							 