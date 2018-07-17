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

/**
 * Servlet class for working as a controller for getting the all contact.
 * 
 * @author Sarangi Balu
 * 
 * @version $version-stub$
 *
 */

// Extend HttpServlet class
public class ContactSearchServlet extends HttpServlet 
{     
      /**
       * Reference to Contact class
      */
      private Contact contact;

      /**
       * Reference to Service class
       */
      private ContactService contactService=new ContactServiceImpl();

      /**
       * Reference to set full contacts
       */

      private Set<Contact> contactSet;

      /**
       * Reference to Logger class to get log messages
       */

      private static final Logger log=Logger.getLogger(ContactSearchServlet.class.getName());

      //private static final Logger log=new LogFileUtility().getLoggerObject(ContactSearchServlet.class.getName()); 


   /**
   * method for initial working
   *
   * @throws ServletException
   *             if undesired condition occures
   */
    public void init() throws ServletException
     {
    log.fine("execution starts");

    log.fine("execution ends");
    }   

   /**
   * Get method for getting the all contact from the database
   *
   * @param request
   *            http request
   * @param response
   *            http response
   */

  
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException

   {

      try {
               /*FileInputStream configFile = new FileInputStream("src/main/resources/logging.properties");
               LogManager.getLogManager().readConfiguration(configFile);*/

              InputStream in = this.getClass().getClassLoader().getResourceAsStream("logging.properties");              

              LogManager.getLogManager().readConfiguration(in);

          } catch (IOException ex){
               ex.printStackTrace(); }

                   
      log.info("********************ContactSearchServlet**********************doGet---------> start");

          contactSet=new TreeSet<Contact>();

          contactSet=contactService.findAll();
     

          request.setAttribute("contactSet",contactSet);

         // forward to jsp page with request parameters
        // response.sendRedirect("Index.jsp");
         request.getRequestDispatcher("index.jsp").forward(request,response);

      log.info("********************ContactSearchServlet**********************doGet---------> End");


   }




}
