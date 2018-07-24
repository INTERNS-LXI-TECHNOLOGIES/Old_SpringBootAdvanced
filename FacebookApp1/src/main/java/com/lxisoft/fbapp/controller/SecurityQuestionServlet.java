package com.lxisoft.fbapp.controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lxisoft.fbapp.service.*;

/**
*@author Anjali
*servlet class to retrive random questions
*
*/
public class SecurityQuestionServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	
		SecurityQuestionService service=new SecurityQuestionService();
		
		service.findSecurityQuestion();
		
	}


}