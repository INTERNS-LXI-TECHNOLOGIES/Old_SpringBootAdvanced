<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.lxisoft.byta.model.*"%>
<%@ page import="com.lxisoft.byta.controller.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	  out.println(contact.getPhoneNumber()); %>
	   </td>
	  </tr>
	    <tr>
			<td>
		<%
	  out.println(contact.getAddress());%>
			</td>
	   </tr>
	   <tr>
			<td>
	   <%
	  out.println(contact.getEmail());
	  %>
	   
		</td>
	</tr>
	</table>
	  <!--session.setAttribute("sessionid",name);-->
	   
	<%  
	   String servletname=config.getServletName();
	   out.println(servletname);
	   
	  
	  	
	%>
</body>
</html>