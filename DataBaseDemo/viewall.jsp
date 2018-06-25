<html>
<%@ page import="java.util.*" %>
<%@ page import="com.lxisoft.databasedemo.model.Contact"%>
<head>
<title>
VIEW ALL
</title>
</head>
<body>
<%List<Contact> contacts = new ArrayList<Contact>();
contacts = (List<Contact>)request.getAttribute("contacts");
for(Contact c : contacts)
{
	out.println(c.getId()+" "+c.getName()+" "+c.getNumber());%><br><%
}
%>

</body>
</html>