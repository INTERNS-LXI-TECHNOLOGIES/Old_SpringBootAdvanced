<%@page import="com.lxisoft.byta.model.*"%>  
  
<p>You are successfully logged in!</p>  
<%  
ContactDto contact=(ContactDto)request.getAttribute("contacts"); 
 
 
out.println("Welcome, "+contact.getName());  
			 out.println(contact.getNo());
			 out.println(contact.getPlace());

%>  
 <form action="index.jsp" method="post">

<p>change name?</p>
<button>clickme</button>
</form>