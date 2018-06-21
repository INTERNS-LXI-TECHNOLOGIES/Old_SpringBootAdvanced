package com.lxisoft.controller;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.lxisoft.model.Contact;
import java.util.logging.Logger;

/**
 * Servlet class for working as a controller in most of the use cases. All the
 * CRUD methods are overridden here.
 *
 * @author Sanil kumar
 */

public class ContactServlet extends HttpServlet {

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

      log.info("execution starts "+request.getMethod()+" "+request.getParameter("method"));
      for(Enumeration<String> e=request.getParameterNames();e.hasMoreElements();)
         System.out.println(e.nextElement());
      if("delete".equals(request.getParameter("method"))) 
            doDelete(request,response);
      else {

         try { // block to handle exceptions

            Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
            connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                            // connection
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM contacts";
            ResultSet resultSet = statement.executeQuery(sql); // executes query

            contacts.clear(); // clear all the elements in the set
            // Extract data from result set
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
      RequestDispatcher view=request.getRequestDispatcher("contact-list.jsp");
      log.info("execution ends");
      view.forward(request,response);
      //response.sendRedirect("contact-list.jsp");
   }

   }

   /**
    * Insert into the details of a new contact database
    *
    * @param request
    *            http request
    * @param response
    *            http response
    */
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("execution starts");
      try {
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         statement = connection.prepareStatement("insert into contacts values (?,?,?,?)");
         statement.setString(1, request.getParameter("first_name"));
         statement.setString(2, request.getParameter("last_name"));
         statement.setString(3, request.getParameter("email"));
         statement.setString(4, request.getParameter("phone_number"));
         int result = statement.executeUpdate();
      }

      catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }

      /*
       * if(result) response.sendRedirect("query-success.html"); else
       * response.sendRedirect("query-fail.html");
       */
      log.info("execution ends");
      doGet(request,response);
   }


   /**
    * Delete the details of a new contact database
    *
    * @param request
    *            http request
    * @param response
    *            http response
    */
   public void doDelete(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      try {

         log.info("execution starts");
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         statement = connection.prepareStatement("delete from contacts where FirstName=?");
         statement.setString(1, request.getParameter("delete_key"));

         int result = statement.executeUpdate();
      }

      catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      log.info("execution ends");

   }

   /**
    * getter of contact set
    * 
    * @return set of contacts
    */
   public static Set<Contact> getContacts() {
      log.info("execution starts");
      log.info("execution ends");
      return ContactServlet.contacts;
   }

   /**
    * destroys a servlet thread
    */
   public void destroy() {
      // do nothing.
      log.info("execution starts");
      log.info("execution ends");
   }

}