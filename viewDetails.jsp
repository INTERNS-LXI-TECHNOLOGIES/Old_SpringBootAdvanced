
<%@ page import="com.lxisoft.model.*"%>
<%@ page import="com.lxisoft.controller.*" %>


<!DOCTYPE html>
<html>
<head>
<title>Success</title>
</head>
<body>
	<table style="with: 50%">
	<tr>
		<td>
	  <% 
		
		Contact contact=(Contact)request.getAttribute("contact");
	  
	  %>
	   </td>
	  </tr>
	  
	  <tr> 
		<td>
	  <%
	  out.println(contact.getName());%>
		</td>
	  </tr>
	   
	   <tr>
		 <td>
	  <%
	  out.println(contact.getPhNo()); %>
	   </td>
	  </tr>
	    <tr>
			<td>
		<%
	  out.println(contact.getAddress());%>
			</td>
	   </tr>
	</table>
	  <!--session.setAttribute("sessionid",name);-->
</body>
</html>