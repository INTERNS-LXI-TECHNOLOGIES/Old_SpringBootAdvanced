package com.lxisoft.contactApp.controller;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import com.lxisoft.contactApp.model.*;
import com.lxisoft.contactApp.service.*;
import com.lxisoft.contactApp.service.impl.*;

// Extend HttpServlet class
public class ContactDeleteServlet extends HttpServlet 
{
 
      private Contact contact;

      private ContactService contactService=new ContactServiceImpl();

      private static final Logger log=Logger.getLogger(ContactDeleteServlet.class.getName());


      
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
      
      {
        log.info("********************ContactDeleteServlet**********************doGet---------> start");
        
        contactService.delete(request.getParameter("first_name")); 

        request.setAttribute("contactName",request.getParameter("first_name"));   

        // forward to jsp page with request parameters
        request.getRequestDispatcher("Contact_Delete.jsp").forward(request,response);

 
      }

 }