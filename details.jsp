<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
<%out.println("\t\t\tCONTACT DETAILS");%>
<%String name =(String)request.getAttribute("UserName");String phNo=(String)request.getAttribute("phone");out.println("names :"+name+"phno :"+phNo);%>
</body>
</html>