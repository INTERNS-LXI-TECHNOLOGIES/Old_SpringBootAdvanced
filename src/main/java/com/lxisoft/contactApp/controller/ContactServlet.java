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
 * Servlet class for working as a controller for getting the indiviual contact and save operation
 * 
 * @author Sarangi Balu
 * 
 */


// Extend HttpServlet class
public class ContactServlet extends HttpServlet 
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
       * Reference to Logger class to get log messages
       */
      private static final Logger log=Logger.getLogger(ContactServlet.class.getName());

      //private static final Logger log=new LogFileUtility().getLoggerObject(ContactServlet.class.getName());

      /**
       * Configures the logger object
       */
      
      {
        try {
              // FileInputStream configFile = new FileInputStream("src/main/resources/logging.properties");
              
              //FileInputStream configFile = new FileInputStream(this.getClass().getResourceAsStream("/logging.properties"));
              
              // LogManager.getLogManager().readConfiguration(configFile);

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
   * Create a new contact based on the parameters received and insert that
   * contact into the database
   *
   * @param request
   *            http request
   * @param response
   *            http response
   */
      

   public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException

    {

      log.info("********************ContactServlet**********************doPost---------> start");

      System.out.print("+++++++++++++++++++++++++++++++++++++++++++++++++"+request.getParameter("Phone_No"));

      contact=contactService.findOne(request.getParameter("Phone_No"));

      System.out.print(contact);

      if(contact!=null)
      {
         System.out.print("-------------------------------True--------------------------------");

         request.getRequestDispatcher("Contact_Exist.jsp").forward(request,response);

     }
      else
      {
      
      System.out.print("-------------------------------false--------------------------------");

      contact=new Contact(request.getParameter("first_name"),request.getParameter("last_name"),request.getParameter("Email_Id"),request.getParameter("Place"),request.getParameter("Phone_No"));

      contactService.save(contact);
         
      request.setAttribute("contact",contact);

      // forward to jsp page with request parameters
      request.getRequestDispatcher("Contact_Details.jsp").forward(request,response);

      }  

      log.info("********************ContactServlet**********************doGet------------> end");
          
    }

   /**
   * Get method for getting the indiviual contact from the database
   *
   * @param request
   *            http request
   * @param response
   *            http response
   */

   public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException

   {
      log.info("********************ContactServlet**********************doGet---------> start");
             

         contact=contactService.findOne(request.getParameter("phone_No"));
       
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