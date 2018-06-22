package com.lxisoft.byta.controller;

import com.lxisoft.byta.model.Contact;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import com.lxisoft.byta.service.*;
import com.lxisoft.byta.model.*;


public class ContactServlet extends HttpServlet {
 

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Long phoneNumber=Long.parseLong(phone);
		
		ContactService contactService=new ContactService();
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phoneNumber");
		Long phoneNumber=Long.parseLong(phone);
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		
		
		ContactDto contactDto=new ContactDto(name,phoneNumber,address,email);
		
		contactService.save(contactDto);
		
		RequestDispatcher rd=request.getRequestDispatcher("/success.jsp");
		rd.forward(request,response);
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String searchName=request.getParameter("searchbyname");
		ContactService contactService=new ContactService();
		ContactDto contactDto=contactService.findContactByName(searchName);
		

			request.setAttribute("contactDto",contactDto);	
		
		RequestDispatcher rd=request.getRequestDispatcher("/viewdetails.jsp");
			rd.forward(request,response);

	}




	
}