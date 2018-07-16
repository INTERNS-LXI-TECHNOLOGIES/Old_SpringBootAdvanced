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
import java.util.logging.LogManager;
import static java.util.logging.Level.FINE;
import static java.util.logging.Level.WARNING;
import static java.util.logging.Level.INFO;

/**
 * Servlet class for working as a controller for getting all the contacts
 *
 * @author Sanil kumar
 */

public class ContactRUServlet extends HttpServlet {

  /**
   * Reference to Service class
   */
  private ContactService service = new ContactService();

  /**
   * Logger instance to get log messages
   */
  private static final Logger logger = Logger.getLogger(ContactRUServlet.class.getName());
  /**
   * Configures the logger object
   */
  {

    try {
      LogManager.getLogManager()
          .readConfiguration(new FileInputStream(getClass().getClassLoader().getResource("logging.properties").getFile()));
    }

    catch (SecurityException e) {
      logger.log(WARNING, "Exception caught", e);
      e.printStackTrace();
    } catch (IOException e) {
      logger.log(WARNING, "Exception caught", e);
      e.printStackTrace();
    }
  }

  /**
   * method for initial working
   *
   * @throws ServletException
   *             if undesired condition occures
   */
  public void init() throws ServletException {
    logger.fine("execution starts");
    logger.fine("execution ends");
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

    logger.log(INFO, "execution starts with request:{0} and response{1}", new Object[] { request, response });

    Contact contact = service.findOne(request.getParameter("link"));
    request.setAttribute("contact", contact);
    // RequestDispatcher view;
    String destinationPage;
    if ("edit".equals(request.getParameter("type")))
      destinationPage = "edit-contact.jsp";
    else if ("delete".equals(request.getParameter("type")))
      destinationPage = "confirmation.jsp";
    else
      destinationPage = "details.jsp";
    logger.info("execution ends");
    request.getRequestDispatcher(destinationPage).forward(request, response);

  }

  /**
   * Update a contact based on the parameters received
   *
   * @param request
   *            http request
   * @param response
   *            http response
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    logger.log(INFO, "execution starts with request:{0} and response{1}", new Object[] { request, response });

    Contact contact = new Contact(request.getParameter("first_name"), request.getParameter("last_name"),
        request.getParameter("phone_number"), request.getParameter("email"));
    service.update(contact);
    request.setAttribute("contact", contact);
    logger.info("execution ends");
    request.getRequestDispatcher("details.jsp").forward(request, response);
  }

}