<%@page import="com.lxisoft.byta.model.*"%>  
  
<p>You are successfully logged in!</p>  
<%  
ContactDto contact=(ContactDto)request.getAttribute("contacts"); 
 
 
out.println("Welcome, "+contact.getName());  
			 out.println(contact.getNo());
			 out.println(contact.getPlace());

%>  

