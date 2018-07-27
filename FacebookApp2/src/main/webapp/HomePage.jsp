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
  .button
{
	background-color:cornflowerBlue;
	color:white;
	border:none;
	padding:10px 15px;
	text-align:center;
	font-size:15px;
	
}
.button:hover
{
	background-color:green;
}
</style>

<body>
   
   <h1 align = "center" class = "oblique">WELCOME USER!!!!!!!</h1>
   
   <div id = "division"></div>
   
   <div id = "center" align = "center">
   <p>
   
   
   <div id = "sub" align = "center">
  </br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
  
  <%@ page import= "com.lxisoft.facebookApp2.controller.*"%>
  <%@ page import = "com.lxisoft.facebookApp2.model.*"%>
  <%@ page import="java.util.ArrayList"%>
  
  
  <h2></h2>
  <% 
 
		 	
        int count = Integer.parseInt(request.getParameter("count"));
		
       if(count==0)
	   {
			ArrayList<QuizResult> quizResultList=new ArrayList<QuizResult>();
			session.setAttribute("result",quizResultList);
	   }
		
		String choice = "null";
        
		ArrayList<Question> questionList =(ArrayList<Question>)session.getAttribute("questions");

			if(questionList!=null)
			{
			
				
				if(count<3)
			
				{
	
  %>
        <form action ="HomePage.jsp" method = "get">
        <input type ="hidden" name="count" value="<%=count+1%>" >
			

		<h1><%out.println((count+1)+".");%><%out.println(questionList.get(count).getQuestionName());%></h1>
		<h1>&nbsp</h1>
		<input type ="radio" class = "button" name = "option" value = "<%=questionList.get(count).getOption1()%>" checked ><%out.println(questionList.get(count).getOption1());%></br>
		<input type ="radio" class = "button" name = "option" value = "<%=questionList.get(count).getOption2()%>" ><%out.println(questionList.get(count).getOption2());%></br>
		<input type ="radio" class = "button" name = "option" value = "<%=questionList.get(count).getOption3()%>" >
		<%out.println(questionList.get(count).getOption3());%></br>
		
		<input type ="submit" class = "button" value = "submit Answer" name="choice"/>
		</br>
		<%
		    
			choice = request.getParameter("option");
			
			if(choice!=null)
			{
				    ArrayList<QuizResult> quizResultList = (ArrayList<QuizResult>)session.getAttribute("result");
					QuizResult quizResult = new QuizResult();
				
			 
					quizResult.setQuestion(questionList.get(count-1));
					out.println(questionList.get(count-1).getQuestionName());
					quizResult.setChoice(choice);
					out.println(quizResult.getChoice());
				
					 quizResultList.add(quizResult);
					 session.setAttribute("result",quizResultList);
					
                				 
				
				
			}
			%>
			 </form>
			<%
	
		}  
		%>

      
			<%
			
				if(count>=3)
				{
					%>
					
					<form action = "questions" method = "post">
					<input type = "submit" class = "button" value = "Generate Answer"/>
			<%
			   choice = request.getParameter("option");
			  
			  if(choice!=null)
			  {
				  ArrayList<QuizResult> quizResultList=(ArrayList<QuizResult>)session.getAttribute("result");
				 QuizResult quizResult = new QuizResult();
				  
				  quizResult.setQuestion(questionList.get(count-1));
				  quizResult.setChoice(choice);
				  quizResultList.add(quizResult);
				  session.setAttribute("result",quizResultList);
			
                }			
			
			}%>
			</form>
			<%
			}
			%>
	
    </div >
    </p>
    </div>
	
	

</body>
</html>