package com.lxisoft.byta.controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.lxisoft.byta.service.*;

public class ContactUpdateServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			
		String contactName=request.getParameter("update");
		String phone=request.getParameter("newPhonenumber");
		Long newPhone=Long.parseLong(phone);
		
		ContactService contactService=new ContactService();
		contactService.updateContact(contactName,newPhone);
		
		RequestDispatcher rd=request.getRequestDispatcher("/updatesuccess.jsp");
		rd.forward(request,response);
		
	}	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String name=request.getParameter("delete");
		ContactService contactService=new ContactService();
		contactService.deleteContact(name);
		
		RequestDispatcher rd=request.getRequestDispatcher("/deletesuccess.jsp");
		rd.forward(request,response);
		
	}

}