package com.lxisoft.facebookApp2.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.FacebookApp2.model.Question;
import java.util.*;


public class NewQuestion extends HttpServlet
{
	private Question question;
  
  
  public void doGet(HttpServletRequest request,HttpServletResponse response)
  {
	  
  }
  public void doPost(HttpServletRequest request,HttpServletResponse reponse)
  {
	  String Question = request.getParameter("Question"); 
	  String Option1 = request.getParameter("Option1"); 
	  String Option2 = request.getParameter("Option2"); 
	  String Option3 = request.getParameter("Option3"); 
	  String Answer = request.getParameter("Answer"); 
	  
	  question = new Question();
	  question.setQuestionName("Question");
	  question.setOption1("Option1");
	  question.setOption2("Option2");
	  question.setOption3("Option3");
	  question.setAnswer("Answer");
	  
	  
	  
	  
  }
}
