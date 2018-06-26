<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title>ContactDelete</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
<%@ page import="java.util.*,com.lxisoft.contactApp.model.*,com.lxisoft.contactApp.controller.*,com.lxisoft.contactApp.utility.*"%>

<%
 Contact contact = (Contact) request.getAttribute("contact");
 %>

 <%
     Properties p=null;
     try
     {

     if(((String)session.getAttribute("language")==null || ((String)session.getAttribute("language")).equals("ENGLISH")))

            p=(new PropertiesFileUtility()).getPropertyObject("../webapps/contactApp_v2/resource files/english_resource.properties");    
     else  
            p=(new PropertiesFileUtility()).getPropertyObject("../webapps/contactApp_v2/resource files/malayalam_resource.properties");

     }catch(Exception fe)
      {
       fe.printStackTrace();
      }

    %>
<%
    String contactName = (String) request.getAttribute("contactName");
%>
<div id="commom_top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="common_contactDetails"><%=p.getProperty("contacts")%></h3>
	</header>
	</div>

<div id="individual_contacts">
<h2>
  
   <%=contactName%><%=p.getProperty("uraccountisremoved")%>

</h2>   

  <% response.setHeader("Refresh", "3;url=contacts");  
 %>
 	
 </div>
 </body>
 </html> 

