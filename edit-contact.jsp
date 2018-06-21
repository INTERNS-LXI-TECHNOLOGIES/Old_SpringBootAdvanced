<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>Create contact</title>
	<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css\mystyle.css">
	<meta charset="UTF-8">
</head>
<body>
	<%@ page import= "com.lxisoft.model.Contact, java.util.*" %>
	
	<% Set<Contact> contactSet=(Set<Contact>)request.getAttribute("contacts");
		
	Contact contact=null;
	for (Contact c:contactSet) {
		contact=c;
		break;
	}
	%>
	<div class="jumbotron top">
	<img class="img-fluid contacts_icon" src="Images\contacts_2.png" alt="Contacts_icon">	
	<h2>Contacts</h2>
	</div>
	<div class="container text-center">
	<div class="row">
	<div class="col-sm-2">
	</div>
	<%@ page import="java.util.*,com.lxisoft.model.Contact" %>
	<form id="form1" class="form-horizontal form_style col-sm-8" action="edit-delete" method="POST">
		<label class="col-sm-3">First Name</label>
		<input class="col-sm-5" type="text" name="first_name"  pattern="[^,]+" required="" value=<%=contact.getFirstName()%>> <br>
		<label class="col-sm-3">Last Name</label>
		<input class="col-sm-5" type="text" name="last_name" pattern="[^,]+" required="" value=<%=contact.getLastName()%>> <br>
		<label class="col-sm-3">Phone number</label>
		<input class="col-sm-5" type="tel" name="phone_number" pattern="[6789][0-9]{9}" required="" value=<%=contact.getPhoneNumber()%> placeholder="+91" readonly=""> <br>
		<label class="col-sm-3">Email&nbsp;</label>
		<input class="col-sm-5" type="email" name="email" checked="checked" pattern="[^,]+"	value=<%=contact.getEmail()%> required="" ><br><br>
		<input type="submit" value="Update">
	</form>
	</div>
	</div>	
</body>
</html>							 