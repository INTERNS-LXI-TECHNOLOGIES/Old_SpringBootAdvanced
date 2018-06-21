<!DOCTYPE html>
<head>
	<title>home</title>
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
    <%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.Contact"%>

    <%
    Set<Contact> contactSet = (TreeSet<Contact>) request.getAttribute("contactSet");
    %>
	<div id="top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="contact_clr">Contacts</h3>
	</header>
	</div>

    <div id="top">
    <form action="contactEditForm" method="GET">
    <input id="inputsearch" type="text" name="first_name" placeholder="Search..">

    </form>
  
    </div>

    <div id="create"> 
    <a href="Contact_Create.jsp">
    <img id="contact_createIcon" src="Images\add_contact_2.png" alt="create_contact" title="CreateContact">
    </a>
    </div>

    <div id="contact_list">
       <%for(Contact contact:contactSet) {%>

 		<div id="individual_contacts"><img id="contact_icon" src="Images\contact_2.png" alt="contact_icon">
 		<a href="ContactsForm?first_name=<%=contact.getFirstName()%>"><%=contact%></a>
         
         </div>
 		
 		<!-- <a href="contactDeletForm?first_name=<%=contact.getFirstName()%>">delete</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 		<a href="ContactsForm?type=edit&first_name=<%=contact.getFirstName()%>">edit</a></p></div>
 -->    <div id="edit_delete">
				<a href="ContactsForm?type=edit&first_name=<%=contact.getFirstName()%>"><span title="Edit"><img class="align" src="Images\edit13.png" title=""></span></a>
				<a href="contactDeletForm?first_name=<%=contact.getFirstName()%>"><span title="Delete"><img class="align" src="Images\remove1.png" title=""></span></a>
        </div>



        
 	
 	<%}%>
 </ul>
</div></body>
</html>
