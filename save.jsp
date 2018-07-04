<html>
<head>
<title> 
SAVE CONTACT
</title>
</head>
<body>
<%String name= (String)request.getAttribute("name");
String address= (String)request.getAttribute("address");
String number=(String)request.getAttribute("number");

out.println("SUCCESSFULLY SAVED...");
%>

<br/>
<br/>
<br/>
<br/>
<%
out.println();

out.println("NAME: "+name);
%>
<br/>
<%
out.println("ADDRESS: "+address);
%>
<br/>
<%
out.println("NUMBER: "+number);
%>

</body>
</html>