package com.lxisoft.controller;
import com.lxisoft.model.*;
import com.lxisoft.repository.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
/**
*This ContactServlet program implements an application that is used to create web application
*in orderto receive and process user request through Http protocol this class should
*extend HttpServlet and override doGet and/or doPost methods
@author Prasad
@version 1.0
@since 12-06-2018
*/
public class UpdateServlet extends HttpServlet{
    /**
    *instance variable contactSet is used to store a set of contacts
    */
	//private Set<Contact> contactSet = new TreeSet<Contact>();
  private ContactRepo contactRepo = new ContactRepo();
  private Contact contact = new Contact();
/**
*doPost method is a override method from HttpServlet class
*this method is designed to send data along with the request to web resource
@param request is used to handle client request
@param response is used to respond client requests
@throws ServletException and IOException
*/

      public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    
      String name=request.getParameter("remove");
    
   contact=new Contact(name,null,null);
    
    ContactRepo contactRepo=new ContactRepo();
    contactRepo.removeContact(contact);
    
    RequestDispatcher rd=request.getRequestDispatcher("/removeSuccess.jsp");
    rd.forward(request,response);

  }
}
