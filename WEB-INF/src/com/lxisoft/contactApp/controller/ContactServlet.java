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
public class ContactServlet extends HttpServlet 
{
 
      private Contact contact;
      
      private ContactService contactService=new ContactServiceImpl();

      private static final Logger log=Logger.getLogger(ContactServlet.class.getName());

      

   public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException

    {

      log.info("********************ContactServlet**********************doPost---------> start");
            
      contact=new Contact(request.getParameter("first_name"),request.getParameter("last_name"),request.getParameter("Email_Id"),request.getParameter("Place"),request.getParameter("Phone_No"));

      contactService.save(contact);
         
      request.setAttribute("contact",contact);

      // forward to jsp page with request parameters
      request.getRequestDispatcher("Contact_Details.jsp").forward(request,response);

      log.info("********************ContactServlet**********************doGet------------> end");
          
    }

   public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException

   {
      log.info("********************ContactServlet**********************doGet---------> start");
         
         contact=contactService.findByName(request.getParameter("first_name"));
       
         request.setAttribute("contact",contact);  
         
         String type="edit";

         if(type.equals(request.getParameter("type")))
         {
              log.info("******************if condition"+type.equals(request.getParameter("type")));
              
              // forward to jsp page with request parameters
              request.getRequestDispatcher("Contact_Edit.jsp").forward(request,response);

         }
         else
         {
             log.info("********************if condition"+type.equals(request.getParameter("type")));
              
             // forward to jsp page with request parameters 
             request.getRequestDispatcher("Contact_Details.jsp").forward(request,response);     
            
         }
         
        log.info("********************ContactServlet**********************doGet---------> end");

   }

   
  
}