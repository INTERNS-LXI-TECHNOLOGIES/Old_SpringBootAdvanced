package com.lxisoft.servlet;
import com.lxisoft.model.*;
import com.lxisoft.file.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
/**
*This ContactServlet program implements an application that is used to create web application
*in orderto receive and process user request through Http protocol this class should
*extend HttpServlet and override doGet and/or doPost methods
*@author Prasad
@version 1.0
@since 12-06-2018
*/
public class ContactServlt extends HttpServlet{
    /**
    *instance variable contactSet is used to store a set of contacts
    */
	Set<Contact> contactSet = new TreeSet<Contact>();

/**
*doGet method is a override method from HttpServlet class
*this method is designed to get response context from web resource
*@param request is used to handle client request
*@param response is used to respond client requests
*@throws servletException and IOException
*/
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
	System.out.println("inside doget");
	response.setContentType("text/html");

  contactSet = FileHandler.readFromFile();
  request.setAttribute("ContactSet",contactSet);
  getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
 }
/**
*doPost method is a override method from HttpServlet class
*this method is designed to send data along with the request to web resource
*@param request is used to handle client request
*@param response is used to respond client requests
*@throws servletException and IOException
*/

public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
	   String name = request.getParameter("name");
        String phone = request.getParameter("phNo");
        String address = request.getParameter("address");
        // contactList.add(new Contact(name,phone,address));
         FileHandler.writeToFile(new Contact(name,phone,address));

            contactSet = FileHandler.readFromFile();
            System.out.println("in do post"+contactSet);
            request.setAttribute("ContactSet",contactSet);
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);  
         
}
}
