<%@ page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>			
	
	<form action="ContactUpdateServlet" method="post">
		<table>
			<tr>
				<td> enter name to update </td>
				<td> <input type="text" name="update" </td>
				<td> enter new phone number </td>
				<td> <input type="text" name="newPhonenumber" </td>
			</tr>	
		</table>
	 <input type="submit" value="updateNumber" />
		
	</form>
	
			
</body>

</html>