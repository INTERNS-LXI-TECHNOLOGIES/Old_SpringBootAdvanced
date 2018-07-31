<%@ page import="java.util.*,com.lxisoft.facebookApp2.model.*"%>
<html>
<body>
<center>

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
</tr>






<form action="UpdateServlet" method="post">

 <%Questions1 quest=(Questions1)request.getAttribute("admin");
 
       if(quest==null)
	   {
		  response.sendRedirect("error.jsp");
	   }
	   else
	   {
 
 %>
 <tr>
<td><input type="text" value= "<%=quest.getId()%>" name="ID"></td>
<td><input type="text" value=" <%=quest.getQuestion()%>" name="questions"></td>
<td><input type="text" value="<%=quest.getOption1()%>" name="option1"></td>
<td><input type="text" value="<%=quest.getOption2()%>" name="option2"></td>
<td><input type="text" value="<%=quest.getOption3()%>" name="option3"></td>
<td><input type="text" value="<%=quest.getOption4()%>" name="option4"></td>
<td><input type="text" value="<%=quest.getAnswer()%>" name="answer"></td>
<input type="submit" value="update">

	   <%}%>

</form>








<%session.setAttribute("quest",quest);%>
</tr>
<form action="index.jsp" method="">

<button>BACK TO HOME</button>
</form>
</center>
</body>
</html>