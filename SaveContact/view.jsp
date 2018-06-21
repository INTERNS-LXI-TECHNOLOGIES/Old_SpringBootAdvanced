<html>
<%@ page import="java.util.*" %>
<head>
<title>
VIEW
</title>
</head>
<body>
<%
List<String> detail = new ArrayList<String>();
detail= (ArrayList<String>)request.getAttribute("data");
out.println( detail);

%>
</body>
</html>