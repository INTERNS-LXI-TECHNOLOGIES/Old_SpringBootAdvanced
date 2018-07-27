<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
<%
if(request.isUserInRole("admin"))
{
	response.sendRedirect("adminPage.jsp");
}
else if(request.isUserInRole("user"))
{
	response.sendRedirect("HomePage.jsp");
}
%>
</body>
</html>