<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title>Details</title>
		<script type="text/javascript" src="js\my-script.js"></script>
	<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css\mystyle.css">

	<meta charset="UTF-8">
</head>
<body>
	<%@ page import="java.util.*,com.lxisoft.contacts.model.Contact,java.io.*"%>
	<%
	    String language= (String)session.getAttribute("language");
        String resourcePath=((language==null) || language.equals("ENG"))?"../webapps/contacts-v4/resource/english.properties":"../webapps/contacts-v4/resource/malayalam.properties";
        language=((language==null) || language.equals("ENG"))?"മലയാളം":"ENG";
        InputStreamReader reader=new InputStreamReader(new FileInputStream(resourcePath),"UTF-8");
        Properties props = new Properties();
        props.load(reader);
		Contact contact=(Contact)request.getAttribute("contact");
		session.setAttribute("currentContact",contact);
	%>
	
	<div class="jumbotron top">
	<img class="img-fluid contacts_icon" src="Images\contacts_2.png" alt="Contacts_icon">	
	<h2><%= props.getProperty("contacts")%></h2>
	</div>
	<div class="container">
	<div class="row">
	<div class="col-sm-8">		
	</div>
	<div class="col-sm-4 text-center">
		<a href="edit-contact.jsp"><span title=<%= props.getProperty("edit")%>><img src="Images\my_edit.png" class="img-fluid contact_option_icons" title=""></span></a>
		<span title=<%= props.getProperty("delete")%>><img src="Images\my_delete.png" class="img-fluid contact_option_icons" onclick="document.getElementById('id01').style.display='block'" title=""></span>
		<a href="getAll"><span title=<%= props.getProperty("contacts")%>><img src="Images\my_contact.png" class="img-fluid contact_option_icons" title=""></span></a>
	</div>
	</div>
	<div class="row contact_detail_container">
	<div class="col-sm-1">
	</div>
	<div class="col-sm-5 contact_name">
			<img src="Images\contact_2.png"> 
			<p><%out.println(contact);%></p>
	</div>
	<div class="col-sm-5 contact_information text-center">
			<ul>
				<li class="phone-number"><%out.println(contact.getPhoneNumber());%></li>
				<li><%out.println(contact.getEmail());%></li>
			</ul>
		</div>
	</div>
	</div>
	<div id="id01" class="outer-dialog-box text-center">
	 	<div class="confirmation-message text-center animate">
 		<div class="dialog"><%= props.getProperty("delete_message")%></div><br>
 		<a class="dialog-yes" href="delete?link=<%=contact.getPhoneNumber()%>"><%= props.getProperty("yes")%></a>
 		<button type="button" class="dialog-no" onclick="document.getElementById('id01').style.display='none'"><%= props.getProperty("no")%></button>	
 			
 	</div> </div>
</body>
</html>