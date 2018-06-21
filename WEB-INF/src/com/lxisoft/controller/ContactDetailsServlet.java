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
 * Servlet class for working as a controller for getting the details of each contact
 *
 * @author Sanil kumar
 */

public class ContactDetailsServlet extends HttpServlet {

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
    * Getting all the elements from the database
    *
    * @param request
    *            http request
    * @param response
    *            http response
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("execution starts");
      Set<Contact> contacts =new TreeSet<Contact>();
      try { // block to handle exceptions
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         statement = connection.prepareStatement("SELECT * FROM contacts WHERE PhoneNumber=?");
         statement.setString(1, request.getParameter("link"));
         ResultSet resultSet = statement.executeQuery(); // executes query

         // Extract data from result set
         while (resultSet.next()) {
            // Retrieve by column name
            contacts.add(new Contact(resultSet.getString("FirstName"), resultSet.getString("LastName"), resultSet.getString("PhoneNumber"), resultSet.getString("Email")));
         }
         //request.setAttribute("contacts",contacts);
      }

      catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      request.setAttribute("contacts",contacts);
      RequestDispatcher view;
      if("edit".equals(request.getParameter("type")))
        view=request.getRequestDispatcher("edit-contact.jsp");
      else if("delete".equals(request.getParameter("type")))
        view=request.getRequestDispatcher("confirmation.jsp");
      else
        view=request.getRequestDispatcher("details.jsp");
      log.info("execution ends");
      view.forward(request,response);
      //response.sendRedirect("result.jsp");

   }

}