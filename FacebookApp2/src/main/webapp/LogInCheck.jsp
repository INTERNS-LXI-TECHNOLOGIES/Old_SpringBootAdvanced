<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
<%
if(request.isUserInRole("admin"))
{
	response.sendRedirect("adminRights.jsp");
}
else if(request.isUserInRole("user"))
{
	response.sendRedirect("question");
}
%>
</body>
</html>