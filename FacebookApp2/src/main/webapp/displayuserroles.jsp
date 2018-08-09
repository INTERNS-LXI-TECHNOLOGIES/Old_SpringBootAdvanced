<%@ page import="java.util.*,com.lxisoft.facebookApp2.model.*"%>
<html>
<body>
<center>
<h1> USERS LIST</h1>
<table border="2">
<tr>

<th>USERNAME</th>
<th>Role As</th>
</tr>


<%

ArrayList<User>users=(ArrayList<User>)session.getAttribute("list");
for(int i=0;i<users.size();i++)
{
	if(users.get(i).getRoleName().equals("users"))
	{
	%>

<tr>


<td><%out.println(users.get(i).getUserName());%></td>
<!--<td><<!--%out.println(users.get(i).getRoleName());%></td>-->



<td><form action="SelectUserServlet" method="post">
<input type="hidden" name="username" value="<%=users.get(i).getUserName()%>" > 
<input type="hidden" name="rolename" value="admin" > 
 <button class="button" type="submit">SetAsAdmin</button><BR/><br/><br/></center>


</tr>
	<%}}%>
</table>

<h1> Admin LIST</h1>
<table border="2">
<tr>

<th>Admin</th>
<th>Role As</th>
</tr>


<%



for(int i=0;i<users.size();i++)
{
	if(users.get(i).getRoleName().equals("admin"))
	{
	%>
<tr>


<td><%out.println(users.get(i).getUserName());%></td>
<!--<td><<!--%out.println(users.get(i).getRoleName());%></td>-->



<td><form action="SelectUserServlet" method="post">
<input type="hidden" name="username" value="<%=users.get(i).getUserName()%>" > 
<input type="hidden" name="rolename" value="user" > 
 <button class="button" type="submit">Remove As Admin</button><BR/><br/><br/></center>


</tr>
	<%}}%>
</table>
</center>
</body>
</html>
