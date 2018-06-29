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
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;


public class ContactServlet extends HttpServlet {
	
	static Logger LOGGER=Logger.getLogger(ContactServlet.class.getName());
	
	static{
		
		try{
			LogManager.getLogManager().readConfiguration(new FileInputStream("E:/lxi softwares/apache-tomcat-7.0.72/webapps/contact/contact.properties"));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGER.info("into post method");
		
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
		
		LOGGER.info("into get method");
		
		String searchName=request.getParameter("searchbyname");
		ContactService contactService=new ContactService();
		ContactDto contactDto=contactService.findContactByName(searchName);
		
		/*LOGGER.setLevel(Level.INFO);
		
		FileHandler fh=new FileHandler("E:/contactlog.txt");
		LOGGER.addHandler(fh);
		
		LOGGER.info("sample info");
		LOGGER.warning("warning info");*/

		request.setAttribute("contactDto",contactDto);	
		
		RequestDispatcher rd=request.getRequestDispatcher("/viewdetails.jsp");
			rd.forward(request,response);

	}




	
}