package com.lxisoft.controller;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import com.lxisoft.model.Contact;

/**
 * Servlet class for working as a controller for update and delete contact
 *
 * @author Sanil kumar
 */

public class ContactEditDeleteServlet extends HttpServlet {

   /**
    * jdbc driver for getting database connection
    */
   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

   /**
    * database url
    */
   private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebook";

   /**
    * database username
    */
   private static final String USER = "root";

   /**
    * database password
    */
   private static final String PASS = "root";

   /**
    * establish aconnection
    */
   private static Connection connection;

   /**
    * make statement to execute query
    */
   private static PreparedStatement statement;

   /**
    * Capture the result of database query.
    */
   private static ResultSet resultSet;

   /**
   * Logger instance to get log messages
   */
   private static final Logger log = Logger.getLogger(ContactServlet.class.getName());

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
    * Let a contact being deleting by calling the doDelete() method
    *
    * @param request
    *            http request
    * @param response
    *            http response
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("execution starts");
      doDelete(request,response);
      log.info("execution ends");

}

   /**
    * delete the contact form the database based on phone number
    *
    * @param request
    *            http request
    * @param response
    *            http response
    */
   public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("execution starts");
      Set<Contact> contacts =new TreeSet<Contact>();
      try { // block to handle exceptions
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         statement = connection.prepareStatement("DELETE FROM contacts WHERE PhoneNumber=?");
         statement.setString(1, request.getParameter("link"));
         int result = statement.executeUpdate(); // executes query

      }

      catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
/*      request.setAttribute("contacts",contacts);
      RequestDispatcher view=request.getRequestDispatcher("details.jsp");
      log.info("execution ends");
      view.forward(request,response);*/
      response.sendRedirect("default");
    }

    /**
    * Let a contact being updating by calling the doPut() method
    *
    * @param request
    *            http request
    * @param response
    *            http response
    */
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("execution starts");
      doPut(request,response);
      log.info("execution ends");

}

   /**
    * Update the contact in the database based on phone number
    *
    * @param request
    *            http request
    * @param response
    *            http response
    */
   public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("execution starts");
               log.info(request.getParameter("email")+" "+request.getParameter("phone_number"));
      Set<Contact> contacts =new TreeSet<Contact>();
      try { // block to handle exceptions
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         statement = connection.prepareStatement("UPDATE contacts SET FirstName=?, LastName=?, Email=? WHERE PhoneNumber=?");
         statement.setString(1, request.getParameter("first_name"));
         statement.setString(2, request.getParameter("last_name"));
         statement.setString(3, request.getParameter("email"));
         statement.setString(4, request.getParameter("phone_number"));
         int result = statement.executeUpdate(); // executes query
         log.info(result+" "+request.getParameter("email"));

      }

      catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
/*      request.setAttribute("contacts",contacts);
      RequestDispatcher view=request.getRequestDispatcher("details.jsp");
      log.info("execution ends");
      view.forward(request,response);*/
      response.sendRedirect("default");
      log.info("execution ends");
    }
}