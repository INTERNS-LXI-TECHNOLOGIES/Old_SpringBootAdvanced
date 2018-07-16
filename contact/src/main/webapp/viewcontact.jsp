<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ page import="com.lxisoft.byta.controller.*"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<!-- String name=(String)session.getAttribute("sessionid");-->
<%	 
	String name=(String)pageContext.getAttribute("uname",pageContext.SESSION_SCOPE);
	
	out.println("Welcome "+name);

%>

</body>
</html>