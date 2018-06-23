package com.lxisoft.contacts.repository;

// Import required java libraries
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import com.lxisoft.contacts.model.Contact;

/**
 * Class which defines all the parameters needed for the database
 * connection. It also includes declaration of all the crud methods to
 * save and retrieve data from the database.
 *
 * @author Sanil kumar
 */

public class ContactRepository {

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
    * make a preparedStatement to execute query
    */
   private static PreparedStatement preparedStatement;

     /**
    * make a statement to execute query
    */
   private static Statement statement;

   /**
    * Capture the result of database query.
    */
   private static ResultSet resultSet;

   /**
   * Logger instance to get log messages
   */
   private static final Logger log = Logger.getLogger(ContactRepository.class.getName());

  /**
  * save single contact to database
  * @param contact
  *            contact to be created
  * @return row number of database table 
  */
   public int save(Contact contact)
   {
   		log.info("execution starts "+contact);
      int result=0;
      	try {
	         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
	         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
	                                                         // connection
	         preparedStatement = connection.prepareStatement("insert into contacts values (?,?,?,?)");
	         preparedStatement.setString(1, contact.getFirstName());
	         preparedStatement.setString(2, contact.getLastName());
	         preparedStatement.setString(3, contact.getEmail());
	         preparedStatement.setString(4, contact.getPhoneNumber());
	         result = preparedStatement.executeUpdate();
      }

      catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return result;
   }

  /**
  * find all elements from the database
  * @return Set of contacts which has been retrieved as a result of
  * select query 
  */
   public Set<Contact> findAll()
   {
      log.info("execution starts ");

      Set<Contact> contacts=new TreeSet<Contact>();

         try { // block to handle exceptions

            Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
            connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                            // connection
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts"); // executes query
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
      log.info("execution ends");
      return contacts;
   }

  /**
  * find unique contact from the database based on phone number
  * @param phoneNumber Phone number as id
  * @return Contact which has been retrieved as a result of select 
  * query 
  */
   public Contact findOne(String phoneNumber)
   {
      
      log.info("execution starts");
      List<Contact> contacts =new ArrayList<Contact>();
      try { // block to handle exceptions
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         preparedStatement = connection.prepareStatement("SELECT * FROM contacts WHERE PhoneNumber=?");
         preparedStatement.setString(1, phoneNumber);
         ResultSet resultSet = preparedStatement.executeQuery(); // executes query

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

      log.info("execution ends");
      return contacts.get(0);

   }

  /**
  * Delete contact from the database based on phone number
  * @param phoneNumber Phone number as id
  * @return row number of database table   
  */
   public int delete(String phoneNumber)
   {
      
      log.info("execution starts");
      int result=0;
      try { // block to handle exceptions
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         preparedStatement = connection.prepareStatement("DELETE FROM contacts WHERE PhoneNumber=?");
         preparedStatement.setString(1, phoneNumber);
         result = preparedStatement.executeUpdate(); // executes query

      }

      catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }

      log.info("execution ends");
      return result;
    }

  /**
  * Updates a contact in the database
  * @param contact contact to be updated
  * @return row number of database table   
  */
   public int update(Contact contact)
   {
      
      log.info("execution starts");
      int result=0;
      try { // block to handle exceptions
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         preparedStatement = connection.prepareStatement("UPDATE contacts SET FirstName=?, LastName=?, Email=? WHERE PhoneNumber=?");
         preparedStatement.setString(1, contact.getFirstName());
         preparedStatement.setString(2, contact.getLastName());
         preparedStatement.setString(3, contact.getEmail());
         preparedStatement.setString(4, contact.getPhoneNumber());
         result = preparedStatement.executeUpdate(); // executes query

      }

      catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }

      log.info("execution ends");
      return result;
    }

  /**
  * find set of contacts from the database based on first name and last
  * name
  * @param nameLike Key to retrieve contacts
  * @return Set of retrieved contacts 
  */
   public Set<Contact> findByNameLike(String nameLike)
   {
      
      log.info("execution starts");
      Set<Contact> contacts =new TreeSet<Contact>();

      try { // block to handle exceptions
         Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
         connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting
                                                         // connection
         preparedStatement = connection.prepareStatement("SELECT * FROM contacts WHERE concat(FirstName,' ',LastName) LIKE ?");
         preparedStatement.setString(1, nameLike + "%");
         ResultSet resultSet = preparedStatement.executeQuery(); // executes query

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
      log.info("execution ends");
      return contacts;
   }
}