<%@ page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title></title>
</head>
<body>
<div>
<%
    InputStream inputstream = getClass().getClassLoader().getResourceAsStream("malayalam.properties");
    Reader reader = new InputStreamReader(inputstream, "UTF-8");
    Properties props = new Properties();
    props.load(reader);
String name=props.getProperty("name");
String phone=props.getProperty("phNo");
String address=props.getProperty("address");
%>

	<form action="sampleUrl" method="post">
        <tr>
                <td> <%=name%> </td>
                <td><input type="text" name="name" placeholder="Name.." required=""/></td>
        </tr>

        <tr>
                <td><%=phone%></td>
                <td><input type="text" name="phNo" placeholder="Phone no.." required=""/></td>
        </tr>

        <tr>
                <td><%=address%></td>
                <td><input type="text" name="address" placeholder="Place.."required=""/></td>
         </tr>
     <input type="submit" value="Submit">
     <input type="reset" value="Reset">


</div>
</body>
</html>