<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.lxisoft.byta.model.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	<table style="with: 50%">
	<tr><td>
	<% String name = request.getParameter("name");
	   String number = request.getParameter("phoneNumber");
	   String address = request.getParameter("address");
	   String email = request.getParameter("email");
	   
	   %>
	   
	  <!--session.setAttribute("sessionid",name);-->
	   
	<%  
	   String servletname=config.getServletName();
	   out.println(servletname);
	   
	  
	  	
	%>
<a>Welcome   <% 
				out.println(name);
				out.println(number);
				out.println(address);
				out.println(email);
				
%> </a></td></tr>
</table>
</body>
</html>