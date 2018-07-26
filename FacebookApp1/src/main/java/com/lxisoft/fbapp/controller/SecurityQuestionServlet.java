package com.lxisoft.fbapp.controller;
import java.io.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import com.lxisoft.fbapp.service.*;
import com.lxisoft.fbapp.model.*;

/**
*@author Anjali
*servlet class to retrive random questions
*
*/
public class SecurityQuestionServlet extends HttpServlet{
	
	/**
	*doget method to retrive questions set from database and pass to jsp
	*
	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	
		SecurityQuestionService service=new SecurityQuestionService();
		
		Set<SecurityQuestion> questions=service.findSecurityQuestion();
		
		/*for(SecurityQuestion s:questions){
			System.out.println(s.getQuestion());
		
		}*/
		
		HttpSession session=request.getSession();
		session.setAttribute("securityquestions",questions);
		
		RequestDispatcher rd=request.getRequestDispatcher("/GameLoader.jsp");
		rd.forward(request,response);
	}


}