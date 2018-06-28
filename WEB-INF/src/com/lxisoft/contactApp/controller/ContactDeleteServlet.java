package com.lxisoft.contactApp.controller;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import com.lxisoft.contactApp.model.*;
import com.lxisoft.contactApp.service.*;
import com.lxisoft.contactApp.service.impl.*;
import com.lxisoft.contactApp.utility.*;

// Extend HttpServlet class
public class ContactDeleteServlet extends HttpServlet 
{
 
      private Contact contact;

      private ContactService contactService=new ContactServiceImpl();

      private static final Logger log=Logger.getLogger(ContactDeleteServlet.class.getName());

      //private static final Logger log=new LogFileUtility().getLoggerObject(ContactDeleteServlet.class.getName());

      
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
      
      {

        try {
               FileInputStream configFile = new FileInputStream("../webapps/contactApp_v2/resource files/logging.properties");
               LogManager.getLogManager().readConfiguration(configFile);

          } catch (IOException ex){
               ex.printStackTrace(); }


        log.info("********************ContactDeleteServlet**********************doGet---------> start");
        
        contactService.delete(request.getParameter("first_name")); 

        request.setAttribute("contactName",request.getParameter("first_name"));   

        // forward to jsp page with request parameters
        request.getRequestDispatcher("Contact_Delete.jsp").forward(request,response);

 
      }

 }