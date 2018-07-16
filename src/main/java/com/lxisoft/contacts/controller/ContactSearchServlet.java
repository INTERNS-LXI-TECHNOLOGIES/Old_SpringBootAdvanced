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

public class ContactSearchServlet extends HttpServlet {

  /**
   * Reference to Service class
   */
  private ContactService service = new ContactService();

  /**
   * Logger instance to get log messages
   */
  private static final Logger logger = Logger.getLogger(ContactSearchServlet.class.getName());

  /**
   * method for initial working
   *
   * @throws ServletException
   *             if undesired condition occures
   */

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

  public void init() throws ServletException {
    logger.fine("execution starts");
    logger.fine("execution ends");
  }

  /**
   * Search contacts
   *
   * @param request
   *            http request
   * @param response
   *            http response
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    logger.log(INFO, "execution starts with request:{0} and response{1}", new Object[] { request, response });

    Set<Contact> contacts = service.findByNameLike(request.getParameter("search_key"));
    request.setAttribute("contacts", contacts);
    logger.log(INFO, "execution ends", contacts);
    request.getRequestDispatcher("contact-list.jsp").forward(request, response);

  }
}