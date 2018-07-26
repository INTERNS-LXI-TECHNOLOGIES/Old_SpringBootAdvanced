<!DOCTYPE html>
 <!--
      This page is about the homepage of facebook app
      @author:silpa
      @version:1.0
	  @copy write
--> 

<html lang="en">
<head>
  <link rel = "stylesheet" type = "text/css" href = "sample.css"/>
  <meta charset = "UTF-8">
 
  <title align = "center">Home Page</title>
 
</head>
<style>
  body{
	  background-image:url("pic.jpg");
	  background-size: cover;
  }
  .oblique{
	  font-style:oblique;
	  color:blue;
  }
  .button{
	  background-color:cornflowerBlue;
	  color:white;
	  border:none;
	  padding:10px 15px;
	  text-align:center;
	  font-size:15px;
  }
</style>

<body>
   
   <h1 align = "center" class = "oblique">WELCOME USER!!!!!!!</h1>
   
   <div id = "division"></div>
   
   <div id = "center" align = "center">
   <p>
   
   
   <div id = "sub" align = "center">
  </br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
  
  <%@ page import= "com.lxisoft.facebookApp2.Controller.*"%>
  <%@ page import = "com.lxisoft.facebookApp2.model.*"%>
  <%@ page import="java.util.ArrayList"%>
  
  <h2></h2>
  <form action ="question" method = "get">
  <%
    ArrayList<QuizResult> quizResulSet;
    int questionId = 1;
	ArrayList<Question> questionList =(ArrayList<Question> )session.getAttribute("questions");
	if(questionList==null)
	{
	out.println(" null");
	}
	else
	{
		for(Question question:questionList)
		{
			
	%>
	<h1><%out.println(questionId+".");%><%out.println(question.getQuestionName());%></h1>
	<h1>&nbsp</h1>
	<input type ="button" class = "button" name = "option" value = "<%=question.getOption1()%>" >
	<input type ="button" class = "button" name = "option" value = "<%=question.getOption2()%>" >
	<input type ="button" class = "button" name = "option" value = "<%=question.getOption3()%>" >

	
	<%
	    response.sendRedirect("HomePage.jsp");
		quizResulSet.add(QuizResult(question,));
		questionId++;
		}
		%></br>
   <%
	}
	%>
	<input type = "submit" value = "submit">
	</form>
    </div >
    </p>
    </div>
	
	

</body>
</html>