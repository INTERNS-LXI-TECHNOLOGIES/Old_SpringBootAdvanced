<html>
<%@ page import="java.util.*" %>
<%@ page import="com.model.Contact"%>
<head>

<title>
VIEW
</title>
</head>
<body>
 <% 
List<Contact> list = new ArrayList<Contact>();
list = (List<Contact>)request.getAttribute("data");
for(int i=0; i<list.size();i++)
		{
			out.println(list.get(i).getName()+" "+list.get(i).getNumber()); %><br><% 
		}%>
</body>
</html>