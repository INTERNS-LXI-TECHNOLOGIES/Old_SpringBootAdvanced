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
 * Servlet class for working as a controller in contact search usecase All the
 * CRUD methods are overridden here.
 *
 * @author Sanil kumar
 */

public class ContactSearchServlet extends HttpServlet {

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
    * set to put all contacts retrieved from database
    */
   private static final Set<Contact> contacts = new TreeSet<Contact>();

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
      try { // block to handle exceptions
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         statement = connection.prepareStatement("SELECT FirstName,LastName,PhoneNumber,Email FROM contacts WHERE FirstName LIKE ? OR LastName LIKE ?");
         statement.setString(1, "%" + request.getParameter("search_key") + "%");
         statement.setString(2, "%" + request.getParameter("search_key") + "%");
         ResultSet resultSet = statement.executeQuery(); // executes query

         // Extract data from result set
         contacts.clear(); // clear set
         while (resultSet.next()) {
            // Retrieve by column name
            contacts.add(new Contact(resultSet.getString("FirstName"), resultSet.getString("LastName"), resultSet.getString("PhoneNumber"), resultSet.getString("Email")));
         }
      }

      catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      request.setAttribute("contacts",contacts);
      RequestDispatcher view=request.getRequestDispatcher("result.jsp");
      log.info("execution ends");
      view.forward(request,response);
      //response.sendRedirect("result.jsp");

   }

   /**
    * getter of contact set
    * 
    * @return set of contacts
    */
   public static Set<Contact> getContacts() {
      log.info("execution starts");
      log.info("execution ends");
      return ContactSearchServlet.contacts;
   }

}