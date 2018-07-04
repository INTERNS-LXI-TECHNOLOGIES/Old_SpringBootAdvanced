<%@ page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>	

        		
	<%
		String userName=(String)request.getParameter("j_username");
		String password=(String)request.getParameter("j_password");
	
	%>
	
	
	
<table border = "0">
            <tr>
               <td> <%=userName  %></td>
               <td> <%=password  %></td>
			   
            </tr>
            
         </table>
	<form action="createcontact.jsp" >
	
	 <input type="submit" value="create contact" />
		
	</form>
	
	<form action="searchcontact.jsp">
		<input type="submit" value="search contact"/>
	
	</form>
	
	<form action="updatecontact.jsp">
		<input type="submit" value="update contact"/>
	
	</form>
	
	<form action="deletecontact.jsp">
		<input type="submit" value="delete contact"/>
	
	</form>
			
</body>

</html>