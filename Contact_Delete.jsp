<!DOCTYPE html>
<head>
	<title>ContactDelete</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
<%@ page import="java.util.*,com.lxisoft.contactApp.model.*,com.lxisoft.contactApp.controller.*"%>
<%
    String contactName = (String) request.getAttribute("contactName");
%>
<div id="commom_top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="common_contactDetails">Contacts</h3>
	</header>
	</div>

<div id="individual_contacts">
<h2>
  
   <%=contactName +" ur account is removed"%>

</h2>   

  <% response.setHeader("Refresh", "3;url=contacts");  
 %>
 	
 </div>
 </body>
 </html> 

