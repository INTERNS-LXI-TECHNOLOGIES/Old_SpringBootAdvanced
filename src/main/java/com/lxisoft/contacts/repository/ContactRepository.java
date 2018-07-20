package com.lxisoft.contacts.repository;

// Import required java libraries
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import com.lxisoft.contacts.model.Contact;
import javax.annotation.Resource;
import javax.naming.*;
import javax.sql.DataSource;
import static java.util.logging.Level.FINE;
import static java.util.logging.Level.WARNING;
import static java.util.logging.Level.INFO;

/**
 * Class which defines all the parameters needed for the database connection. It
 * also includes declaration of all the crud methods to save and retrieve data
 * from the database.
 *
 * get source codes from <a href=${git.remote.origin.url}></a>  
 *
 * @author ${git.build.user.name}
 * ${name:git_config(user.name)}, ${email:git_config(user.email)}
 * @version ${git.commit.id.abbrev}
 * @see javax.sql.DataSource
 */

public class ContactRepository {

  /**
   * make a preparedStatement to execute query
   */
  private static PreparedStatement preparedStatement;

  /**
   * Reference for the database connection
   */
  private static Connection connection;

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
  private static final Logger logger = Logger.getLogger(ContactRepository.class.getName());

  /**
   * Initializes the connection object by looking in the context.xml file
   * Configures the logger object
   */
  {

    try {
      LogManager.getLogManager()
          .readConfiguration(new FileInputStream(getClass().getClassLoader().getResource("logging.properties").getFile()));
      Context context = new InitialContext();
      DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/contacts");
      connection = ds.getConnection();

    }

    catch (NamingException e) {
      logger.log(WARNING, "Exception caught={0}", e);
      e.printStackTrace();
    } catch (SQLException e) {
      logger.log(WARNING, "Exception caught={0}", e);
      e.printStackTrace();
    } catch (SecurityException e) {
      logger.log(WARNING, "Exception caught={0}", e);
      e.printStackTrace();
    } catch (IOException e) {
      logger.log(WARNING, "Exception caught={0}", e);
      e.printStackTrace();
    }
  }

  /**
   * save single contact to database
   * 
   * @param contact
   *            contact to be created
   * @return row number of database table
   */
  public int save(Contact contact) {
    logger.log(INFO, "execution starts with {0}", contact);
    int result = 0;
    try {
      // Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
      // connection = DriverManager.getConnection(DB_URL, USER, PASS); //
      // getting
      // connection
      // connection=ds.getConnection();
      preparedStatement = connection.prepareStatement("insert into contacts values (?,?,?,?)");
      preparedStatement.setString(1, contact.getFirstName());
      preparedStatement.setString(2, contact.getLastName());
      preparedStatement.setString(3, contact.getEmail());
      preparedStatement.setString(4, contact.getPhoneNumber());
      result = preparedStatement.executeUpdate();
    }

    catch (SQLException se) {
      logger.log(WARNING, "Exception caught ={0}", se);
      se.printStackTrace();
    } catch (Exception e) {
      logger.log(WARNING, "Exception caught={0}", e);
      e.printStackTrace();
    }
    return result;
  }

  /**
   * find all elements from the database
   * 
   * @return Set of contacts which has been retrieved as a result of select
   *         query
   */
  public Set<Contact> findAll() {
    logger.info("execution starts");

    Set<Contact> contacts = new TreeSet<Contact>();

    try { // block to handle exceptions

      // Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
      // connection = DriverManager.getConnection(DB_URL, USER, PASS); //
      // getting
      // connection
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts"); // executes
      // query
      // Extract data from result set
      while (resultSet.next()) {
        // Retrieve by column name
        contacts.add(new Contact(resultSet.getString("FirstName"), resultSet.getString("LastName"),
            resultSet.getString("PhoneNumber"), resultSet.getString("Email")));
      }
    }

    catch (SQLException se) {
      logger.log(WARNING, "Exception caught={0}", se);
      se.printStackTrace();
    } catch (Exception e) {
      logger.log(WARNING, "Exception caught={0}", e);
      e.printStackTrace();
    }
    logger.info("execution ends");
    return contacts;
  }

  /**
   * find unique contact from the database based on phone number
   * 
   * @param phoneNumber
   *            Phone number as id
   * @return Contact which has been retrieved as a result of select query
   */
  public Contact findOne(String phoneNumber) {

    logger.log(INFO, "execution starts with {0}", phoneNumber);
    List<Contact> contacts = new ArrayList<Contact>();
    try { // block to handle exceptions
      /*
       * Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
       * connection = DriverManager.getConnection(DB_URL, USER, PASS); //
       * getting
       */
      // connection
      preparedStatement = connection.prepareStatement("SELECT * FROM contacts WHERE PhoneNumber=?");
      preparedStatement.setString(1, phoneNumber);
      ResultSet resultSet = preparedStatement.executeQuery(); // executes
      // query

      // Extract data from result set
      while (resultSet.next()) {
        // Retrieve by column name
        contacts.add(new Contact(resultSet.getString("FirstName"), resultSet.getString("LastName"),
            resultSet.getString("PhoneNumber"), resultSet.getString("Email")));
      }
      // request.setAttribute("contacts",contacts);
    }

    catch (SQLException se) {
      logger.log(WARNING, "Exception caught={0}", se);
      se.printStackTrace();
    } catch (Exception e) {
      logger.log(WARNING, "Exception caught={0}", e);
      e.printStackTrace();
    }

    logger.info("execution ends");
    return contacts.get(0);

  }

  /**
   * Delete contact from the database based on phone number
   * 
   * @param phoneNumber
   *            Phone number as id
   * @return row number of database table
   */
  public int delete(String phoneNumber) {

    logger.log(INFO, "execution starts with {0}", phoneNumber);
    int result = 0;
    try { // block to handle exceptions
      /*
       * Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
       * connection = DriverManager.getConnection(DB_URL, USER, PASS); //
       * getting
       */
      // connection
      preparedStatement = connection.prepareStatement("DELETE FROM contacts WHERE PhoneNumber=?");
      preparedStatement.setString(1, phoneNumber);
      result = preparedStatement.executeUpdate(); // executes query

    }

    catch (SQLException se) {
      logger.log(WARNING, "Exception caught", se);
      se.printStackTrace();
    } catch (Exception e) {
      logger.log(WARNING, "Exception caught", e);
      e.printStackTrace();
    }

    logger.log(INFO, "execution ends", result);
    return result;
  }

  /**
   * Updates a contact in the database
   * 
   * @param contact
   *            contact to be updated
   * @return row number of database table
   */
  public int update(Contact contact) {

    logger.log(INFO, "execution starts with {0}", contact);
    int result = 0;
    try { // block to handle exceptions
      /*
       * Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
       * connection = DriverManager.getConnection(DB_URL, USER, PASS); //
       * getting // connection
       */
      preparedStatement = connection
          .prepareStatement("UPDATE contacts SET FirstName=?, LastName=?, Email=? WHERE PhoneNumber=?");
      preparedStatement.setString(1, contact.getFirstName());
      preparedStatement.setString(2, contact.getLastName());
      preparedStatement.setString(3, contact.getEmail());
      preparedStatement.setString(4, contact.getPhoneNumber());
      result = preparedStatement.executeUpdate(); // executes query

    }

    catch (SQLException se) {
      logger.log(WARNING, "Exception caught", se);
      se.printStackTrace();
    } catch (Exception e) {
      logger.log(WARNING, "Exception caught", e);
      e.printStackTrace();
    }

    logger.log(INFO, "execution ends", result);
    return result;
  }

  /**
   * find set of contacts from the database based on first name and last name
   * 
   * @param nameLike
   *            Key to retrieve contacts
   * @return Set of retrieved contacts
   */
  public Set<Contact> findByNameLike(String nameLike) {

    logger.log(INFO, "execution starts with {0}", nameLike);
    Set<Contact> contacts = new TreeSet<Contact>();

    try { // block to handle exceptions
      /*
       * Class.forName("com.mysql.jdbc.Driver"); // register jdbc driver
       * connection = DriverManager.getConnection(DB_URL, USER, PASS); //
       * getting // connection
       */
      preparedStatement = connection
          .prepareStatement("SELECT * FROM contacts WHERE concat(FirstName,' ',LastName) LIKE ?");
      preparedStatement.setString(1, nameLike + "%");
      ResultSet resultSet = preparedStatement.executeQuery(); // executes
      // query

      while (resultSet.next()) {
        // Retrieve by column name
        contacts.add(new Contact(resultSet.getString("FirstName"), resultSet.getString("LastName"),
            resultSet.getString("PhoneNumber"), resultSet.getString("Email")));
      }
    }

    catch (SQLException se) {
      logger.log(WARNING, "Exception caught with {0}", se);
      se.printStackTrace();
    } catch (Exception e) {
      logger.log(WARNING, "Exception caught with {0}", e);
      e.printStackTrace();
    }
    logger.log(INFO, "execution ends with {0}", contacts);
    return contacts;
  }
}