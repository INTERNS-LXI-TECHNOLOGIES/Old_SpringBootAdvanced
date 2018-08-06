<%@ page import="java.util.*,com.lxisoft.facebookApp2.model.*"%>
<html>
<body>
<center>
<h1>Display All questions </h1>

<table border="2">
<tr>
<th>ID</th>
<th>Questions</th>
<th>Option1</th>
<th>Option2</th>
<th>Option3</th>
<th>Option4</th>
<th>Answer</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%

ArrayList <Question> quest = (ArrayList<Question>)session.getAttribute("list");
for(int i=0;i<quest.size();i++)
{%>
<tr>
<td><%out.println(quest.get(i).getQuestionId());%></td>

<td><%out.println(quest.get(i).getQuestionName());%></td>




<td><%out.println(quest.get(i).getOption1());%></td>

<td><%out.println(quest.get(i).getOption2());%></td>



<td><%out.println(quest.get(i).getOption3()); %></td>



<td><%out.println(quest.get(i).getOption4());%></td>




<td><%out.println(quest.get(i).getAnswer());%></td>
<td><form action="UpdateServlet" method="get">
<input type="hidden" name="Editid" value="<%=quest.get(i).getQuestionId()%>" > 
<input type="submit"  value="edit">
</form></td>
<td><form action="DeleteServlet" method="post">
<input type="hidden" name="DeleteId" value="<%=quest.get(i).getQuestionId()%>" >
<input type="submit"  value="delete"> 
</form></td>

</tr>

<%}%>
</table>
<form action="AdminIndex.jsp" method="">

<button>BACK TO HOME</button>
<center>
</form>





</body>
</html>