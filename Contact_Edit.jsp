<!DOCTYPE html>
<head>
	<title>contact_edit</title>
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.Contact"%>
 <%
 Contact contact = (Contact) request.getAttribute("contact");
 %>

	<div id="commom_top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="common_contactDetails">Contacts</h3>
	</header>
	</div>
    <form action = "contactEditForm" method = "POST">
    <input type="hidden" name="key" value="<%=contact.getFirstName()%>"><br><br> 
	    FirstName :&nbsp;
		<input type="text" name="first_name" required="" value="<%=contact.getFirstName()%>"><br><br>
		LastName :&nbsp;
		<input type="text" name="last_name" required="" value="<%=contact.getLastName()%>"><br><br>
        Email :&nbsp;
		<input type="email" name="Email_Id" checked="checked" required="" value="<%=contact.getEmail()%>"><br><br>
		Phone number:&nbsp;
		<input id="login-phn" type="tel" name="Phone_No" pattern="[6789][0-9]{9}" required="" placeholder="+91" value="<%=contact.getPhNo()%>"><br><br>
		Place :&nbsp;
		<input type="text" name="Place" required="" value="<%=contact.getPlace()%>"><br><br>


		<br>
		<input id="login_submit" type="submit"  value="save"><br><br>
	</form>
	</div>
	
</body>
</html>

