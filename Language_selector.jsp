<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title>LanguageSelector</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
<%@ page import="java.util.*,com.lxisoft.contactApp.model.*,com.lxisoft.contactApp.controller.*,com.lxisoft.contactApp.utility.*"%>
<% String type="ENGLISH";
   String type1="MALAYALAM";

      if(type.equals(request.getParameter("type")))
      
            session.setAttribute("language",type);
      else
           session.setAttribute("language",type1);
           

%>      

<div id="commom_top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="common_contactDetails">Contacts</h3>
	</header>
	</div>

<div id="individual_contacts">

  <% response.sendRedirect("contacts");  
 %>
 	
 </div>
 </body>
 </html> 

