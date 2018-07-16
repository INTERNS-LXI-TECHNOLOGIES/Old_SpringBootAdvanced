<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title>ContactDetails</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
<%@ page import="java.util.*,com.lxisoft.contactApp.model.*,com.lxisoft.contactApp.controller.*,com.lxisoft.contactApp.utility.*"%>
<%
     Properties p=null;
     try
     {

     if(((String)session.getAttribute("language")==null || ((String)session.getAttribute("language")).equals("ENGLISH")))

            p=(new PropertiesFileUtility()).getPropertyObject("../webapps/contactApp_v3/resource files/english_resource.properties");    
     else  
            p=(new PropertiesFileUtility()).getPropertyObject("../webapps/contactApp_v3/resource files/malayalam_resource.properties");

     }catch(Exception fe)
      {
       fe.printStackTrace();
      }

    %>
 <%
 Contact contact = (Contact) request.getAttribute("contact");
 %>
<div id="commom_top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="common_contactDetails"><%=p.getProperty("contacts")%></h3>
	</header>
	</div>

  <div id="option_icons">
		<a href="contactsForm?type=edit&first_name=<%=contact.getFirstName()%>"><img class="align" src="Images\edit132.png" alt="edit_contact" title=<%=p.getProperty("editContact")%>></a>
		
		<a href="contactDeletForm?first_name=<%=contact.getFirstName()%>"><img class="align" src="Images\delete131.png" alt="remove_button" title=<%=p.getProperty("removeContact")%>></a>

		<a href="contacts"><img class="align" src="Images\back121.png" alt="back_button" title=<%=p.getProperty("back")%>></a>

  </div>

  <img id="indiviual_contact_icon" src="Images\contact_2.png" alt="contact_icon" title="ContactIcon">
	 <div id="contact_detail_container">
	 <div id="contact_name">


	      <p><%=contact%></p>
          <!-- <p><%=contact.getLastName()%></p> -->
          <p><%=contact.getEmail()%></p>
          <p><%=contact.getPhNo()%></p>
          <p><%=contact.getPlace()%></p>

			
	 </div>
	</div> 


 
 
</body>
</html>