<html>
<%@ page import="java.util.*" %>
<%@ page import="com.lxisoft.databasedemo.model.Contact"%>
<head>
<style>
body {
    background-color: lightblue;
}
h {
    color: white;
    text-align: center;
}
</style>
<title>
VIEW ALL
</title>
</head>
<body>
<h>
<h1>CONTACTS</h1>
<h2>
<%List<Contact> contacts = new ArrayList<Contact>();
contacts = (List<Contact>)request.getAttribute("contacts");
for(Contact c : contacts)
{
	out.println(c.getId()+" "+c.getName()+" "+c.getNumber());%><br><%
}
%>
<h2>
<h>
<br>
<form action="intex.jsp" method="post">
<input type="submit" value="HOME"></input>
</form>
</body>
</html>