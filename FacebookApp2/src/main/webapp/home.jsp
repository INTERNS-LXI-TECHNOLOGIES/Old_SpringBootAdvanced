<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<%String name = request.getRemoteUser();
	session.setAttribute("username",name);
	String name1=(String)session.getAttribute("username");
	out.println("hello.."+name1 +" welcome to home");%>
</body>
</html>