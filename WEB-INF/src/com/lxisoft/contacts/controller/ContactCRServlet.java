package com.lxisoft.contacts.controller;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.lxisoft.contacts.model.Contact;
import com.lxisoft.contacts.service.ContactService;
import java.util.logging.Logger;

/**
 * Servlet class for working as a controller for getting all the contacts
 *
 * @author Sanil kumar
 */

public class ContactCRServlet extends HttpServlet {

  /**
  * Reference to Service class
  */
  private ContactService service=new ContactService();

    /**
   * Logger instance to get log messages
   */
   private static final Logger log = Logger.getLogger(ContactCRServlet.class.getName());

   /**
    * method for initial working
    *
    * @throws ServletException
    *             if undesired condition occures
    */
   public void init() throws ServletException {
      log.info("execution starts");
      log.info("execution ends");
   }

   /**
    * Get method for getting all the elements from the database
    *
    * @param request
    *            http request
    * @param response
    *            http response
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      log.info("execution starts ");
     
     Set<Contact> contacts=service.findAll();
      request.setAttribute("contacts",contacts);
      log.info("execution ends");
      request.getRequestDispatcher("contact-list.jsp").forward(request,response);
      //response.sendRedirect("contact-list.jsp");
   }

   /**
    * Create a new contact based on the parameters received and insert that contact
    * into the database
    *
    * @param request
    *            http request
    * @param response
    *            http response
    */
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("execution starts");

      Contact contact=new Contact(request.getParameter("first_name"),request.getParameter("last_name"),request.getParameter("phone_number"),request.getParameter("email"));
      service.save(contact);
      log.info("execution ends");
      doGet(request,response);
   }

}