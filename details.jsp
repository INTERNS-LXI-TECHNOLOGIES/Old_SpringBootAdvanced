<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<head>
	<title>Details</title>
	<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css\mystyle.css">
	<meta charset="UTF-8">
</head>
<body>
	<%@ page import="java.util.*,com.lxisoft.model.Contact"%>
	<%
	
	Set<Contact> contactSet=(Set<Contact>)request.getAttribute("contacts");
		if(contactSet.size()>1)
			throw new Error();
		
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
	<div class="container">
	<div class="row">
	<div class="col-sm-8">		
	</div>
	<div class="col-sm-4 text-center">
		<a href="details?link=<%out.println(contact.getPhoneNumber());%>&type=edit"><span title="Edit contact"><img src="Images\edit_1.png" class="img-fluid contact_option_icons" title=""></span></a>
		<a href="details?link=<%out.println(contact.getPhoneNumber());%>&type=delete"><span title="Delete contact"><img src="Images\delete_3.png" class="img-fluid contact_option_icons" title=""></span></a>
		<a href="default"><span title="Back"><img src="Images\back_9.jpg" class="img-fluid contact_option_icons" title=""></span></a>
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
				<li><%out.println(contact.getPhoneNumber());%></li>
				<li><%out.println(contact.getEmail());%></li>
			</ul>
		</div>
	</div>
	</div> 
</body>
</html>