<html>
<head>
<title>
SAVE
</title>
</head>
<body>
<%String name= (String)request.getAttribute("name");
String number=(String)request.getAttribute("number");
out.println("SUCCESSFULLY SAVED");%><br>
<%
out.println("NAME:"+name+"   NUMBER:"+number);
%>



</body>
</html>