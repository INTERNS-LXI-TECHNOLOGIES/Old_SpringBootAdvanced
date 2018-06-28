<%@ page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<%
    InputStream inputstream = getClass().getClassLoader().getResourceAsStream("malayalam.properties");
    Reader reader = new InputStreamReader(inputstream, "UTF-8");
    Properties props = new Properties();
    props.load(reader);
String search=props.getProperty("search");
%>
<form action="sampleUrl" method="get">
		<table>
			<tr>
				<td> <%=search%></td>
				<td> <input type="text" name="searchByName"/> </td>
			</tr>
		</table>	
		
		<input type="submit" value="search.." />
	</form>

</body>
</html>
