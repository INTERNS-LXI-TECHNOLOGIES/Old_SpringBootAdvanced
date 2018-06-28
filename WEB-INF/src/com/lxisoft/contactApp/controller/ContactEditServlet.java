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
public class ContactEditServlet extends HttpServlet 
{
 
      private Contact contact; 

      private Set<Contact> contactSet; 

      private ContactService contactService=new ContactServiceImpl();

      private static final Logger log=Logger.getLogger(ContactEditServlet.class.getName());

      //private static final Logger log=new LogFileUtility().getLoggerObject(ContactEditServlet.class.getName());


      static 
      {
        try {
               FileInputStream configFile = new FileInputStream("../webapps/contactApp_v2/resource files/logging.properties");
               LogManager.getLogManager().readConfiguration(configFile);

          } catch (IOException ex){
               ex.printStackTrace(); }
      }


public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException

   {
     
      log.info("********************ContactEditServlet**********************doPost---------> start");
            
      contact=new Contact(request.getParameter("key"),request.getParameter("last_name"),request.getParameter("Email_Id"),request.getParameter("Place"),request.getParameter("Phone_No"));

      contactService.update(contact);
         
      request.setAttribute("contact",contact);

      // forward to jsp page with request parameters
      request.getRequestDispatcher("Contact_Details.jsp").forward(request,response);

      log.info("********************ContactEditServlet**********************doPost---------> end"); 
 
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
   {
      
         log.info("********************ContactSearchServlet**********************doGet---------> start");

          contactSet=new TreeSet<Contact>();

          contactSet=contactService.findOne(request.getParameter("first_name"));

          request.setAttribute("contactSet",contactSet);     

          // forward to jsp page with request parameters
          request.getRequestDispatcher("Index.jsp").forward(request,response);  

        log.info("********************ContactSearchServlet**********************doGet------------> end");

   }



}