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
public class ContactSearchServlet extends HttpServlet 
{
 
      private Contact contact;

      private ContactService contactService=new ContactServiceImpl();

      private Set<Contact> contactSet;

      private static final Logger log=Logger.getLogger(ContactSearchServlet.class.getName());

  
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
   {

     log.info("********************ContactSearchServlet**********************doGet---------> start");

          contactSet=new TreeSet<Contact>();

          contactSet=contactService.findAll();
     

          request.setAttribute("contactSet",contactSet);

         // forward to jsp page with request parameters
        // response.sendRedirect("Index.jsp");
         request.getRequestDispatcher("Index.jsp").forward(request,response);

      log.info("********************ContactSearchServlet**********************doGet---------> End");


   }




}
