<%@ page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>			
	
	<%
	InputStream inputstream = getClass().getClassLoader().getResourceAsStream("malayalam.properties");
	Reader reader = new InputStreamReader(inputstream, "UTF-8");
	Properties props = new Properties();
	props.load(reader);

String name=props.getProperty("name");
String phone=props.getProperty("phoneNumber");
String address=props.getProperty("address");
String email=props.getProperty("email");
%>

	<form action="ContactServlet" method="post">
			<table style="with: 50%">
				<tr>
					<td> <%=name%> </td>
					<td><input type="text" name="name" /></td>
				</tr>
				
				<tr>
					<td><%=phone%></td>
					<td><input type="text" name="phoneNumber" /></td>
				</tr>
				
				<tr>
					<td><%=address%></td>
					<td><input type="text" name="address" /></td>
				</tr>
				
				<tr>
					<td><%=email%></td>
					<td><input type="text" name="email" /></td>
				</tr>
			 </table>	
			<input type="submit" value="save contact" /></form>
			
	
			
</body>

</html>