<!DOCTYPE html>
<head>
	<title>ContactDetails</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
  <div id="commom_top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="common_contactDetails">Contacts</h3>
	</header>
	</div>

<%@ page import="java.util.*,com.lxisoft.contactApp.model.*,com.lxisoft.contactApp.controller.*"%>
 <%
 Contact contact = (Contact) request.getAttribute("contact");
 %>

  <div id="option_icons">
		<a href="contactsForm?type=edit&first_name=<%=contact.getFirstName()%>"><img class="align" src="Images\edit13.png" alt="edit_contact" title="Edit"></a>
		
		<a href="contactDeletForm?first_name=<%=contact.getFirstName()%>"><img class="align" src="Images\remove1.png" alt="remove_button" title="Delete"></a>

		<a href="contacts"><img class="align" src="Images\back2.png" alt="back_button" title="Back"></a>

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