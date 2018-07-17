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
 * Servlet class for working as a controller for search the contact by name and edit.
 * 
 * @author Sarangi Balu
 * 
 * @version $version-stub$
 *
 */

// Extend HttpServlet class
public class ContactEditServlet extends HttpServlet 
{
      /**
       * Reference to Contact class
      */
      private Contact contact; 

      /**
       * Reference to set full contacts
      */

      private Set<Contact> contactSet; 

      /**
       * Reference to Service class
       */

      private ContactService contactService=new ContactServiceImpl();

      /**
       * Reference to Logger class to get log messages
       */

      private static final Logger log=Logger.getLogger(ContactEditServlet.class.getName());

      //private static final Logger log=new LogFileUtility().getLoggerObject(ContactEditServlet.class.getName());

      

      /**
       * Configures the logger object
      */
 
      {
        try {
               /*FileInputStream configFile = new FileInputStream("src/main/resources/logging.properties");

               LogManager.getLogManager().readConfiguration(configFile);*/

               InputStream in = this.getClass().getClassLoader().getResourceAsStream("logging.properties");              

              LogManager.getLogManager().readConfiguration(in);

          } catch (IOException ex){
               ex.printStackTrace(); }
      }


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
   * edit contact based on the parameters update that
   * contact into the database
   *
   * @param request
   *            http request
   * @param response
   *            http response
   */    


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

   /**
   * Get method for search the indiviual contact  by name from the database
   *
   * @param request
   *            http request
   * @param response
   *            http response
   */

   public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
   {
      
         log.info("********************ContactSearchServlet**********************doGet---------> start");

          contactSet=new TreeSet<Contact>();

          contactSet=contactService.findByName(request.getParameter("first_name"));

          request.setAttribute("contactSet",contactSet);     

          // forward to jsp page with request parameters
          request.getRequestDispatcher("index.jsp").forward(request,response);  

        log.info("********************ContactSearchServlet**********************doGet------------> end");

   }



}