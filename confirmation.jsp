<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css\mystyle.css">
	<meta charset="UTF-8">
</head>
<body>
	<div class="jumbotron top">
	<img class="img-fluid contacts_icon" src="Images\contacts_2.png" alt="Contacts_icon">	
	<h2>Contacts</h2>
	</div>
	<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.Contact"%>

	<%Set<Contact> contactSet=(Set<Contact>)request.getAttribute("contacts");

		Contact contact=null;
		for (Contact c:contactSet) {
			contact=c;
			break;
		}%>
 	<div class="container">
 	<div class="row">
 	<div class="col-sm-2"></div>
 	<div class="col-sm-8 text-center">
 		<div class="dialog">Are you sure you want to delete?</div><br>
 		<a class="dialog-yes" href="edit-delete?link=<%=contact.getPhoneNumber()%>">yes</a>
 		<a class="dialog-no" href="default">no</a>	
 			
 	</div>
 	</div>
 	</div>

</body>
</html>