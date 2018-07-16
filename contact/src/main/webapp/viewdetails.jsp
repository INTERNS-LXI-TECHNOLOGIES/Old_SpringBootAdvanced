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
		
		ContactDto contactDto=(ContactDto)request.getAttribute("contactDto");
	  
	  %>
	   </td>
	  </tr>
	  
	  <tr>
		<td>
	  <%
	  out.println(contactDto.getName());%>
		</td>
	  </tr>
	   
	   <tr>
		 <td>
	  <%
	  out.println(contactDto.getPhoneNumber()); %>
	   </td>
	  </tr>
	    <tr>
			<td>
		<%
	  out.println(contactDto.getAddress());%>
			</td>
	   </tr>
	   <tr>
			<td>
	   <%
	  out.println(contactDto.getEmail());
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