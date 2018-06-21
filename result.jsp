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
	<div class="container"> 

	<!--<img src="add-512.png" alt="Mountain View">-->

	<div class="contact_container">
		<%@ page import="java.util.*,com.lxisoft.model.Contact" %>
		<%

			Set<Contact> resultSet;
			resultSet=(TreeSet<Contact>)request.getAttribute("contacts");
			//NameSorter nameSorter=new NameSorter();
			//Collections.sort(contactList);	
			
			//Collections.sort(contactList);
			if(resultSet.size()>0)
			{
				for(Contact contact:resultSet)
				{%>
				<div class="row individual_contact_row">
				<div class="col-sm-8 individual_contact">
				<img class="individual_contact_icon" src="Images\contact_1.png" alt="contact_picture"><p><a href="details?link=<%out.println(contact.getPhoneNumber());%>"><% out.println(contact); %></a></p>
				</div>
				<div class="col-sm-4 text-center">
					<a href="#"><img class="align" src="Images\edit_1.png"></a>
					<a href="#"><img class="align" src="Images\delete_3.png"></a>
				</div>
				</div> 
			<%}
			}
			else
			{%>
				<p class="text-info error-message">Sorry...no contact could not be found</p>
				<%response.setHeader("Refresh", "3;url=default");
				
			}%>

	</div>
	</div>
</body>
</html>                                                                                       