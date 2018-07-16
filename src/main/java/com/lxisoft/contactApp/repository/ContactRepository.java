package com.lxisoft.contactApp.repository;

//Import required java libraries
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import com.lxisoft.contactApp.model.*;
//import javax.naming.Context;
//import javax.naming.InitialContext;
import javax.naming.*;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Class defines database connection and 
 * also includes declaration of all the crud methods to save and retrieve data
 * from the database.
 *
 * @author Sarangi Balu
 */

public class ContactRepository 
{

      /**
       * Reference for the datasource
      */
	 
      private DataSource ds;

      /**
       * Reference for the database connection
      */

      private static Connection conn;

      /**
       * make a preparedStatement to execute query
      */

      private PreparedStatement stmt;

      /**
       * Capture the result of database query.
      */

      private ResultSet rs ;

      /**
       * Reference to Contact class
      */

      private Contact contact;

      /**
       * Reference to set full contacts
       */

      private Set<Contact> contactSet;

      /**
       * Logger instance to get log messages
      */

      private static final Logger log=Logger.getLogger(ContactRepository.class.getName());

       /**
       * Initializes the context object by looking in the context.xml file
       *
       * Configures the logger object
       */
      
      {
        try {
              
              InputStream in = this.getClass().getClassLoader().getResourceAsStream("logging.properties");              

              LogManager.getLogManager().readConfiguration(in);

              Context context = new InitialContext();

              ds = (DataSource)context.lookup("java:comp/env/jdbc/contactApp_v1");


            } catch (IOException e){
               //log.log(WARNING, "Exception caught={0}", e);
               e.printStackTrace(); 
            } catch (NamingException e){
              //log.log(WARNING, "Exception caught={0}", e);
              e.printStackTrace();
            } 
      }

       /**
        * Get all the contacts from database.
        * 
        * @return the set of contacts.
        *
        */       
      
      public Set<Contact> findAll()

      {
        
        log.info("********************ContactRepository**********************findAll---------> start");

         contactSet=new TreeSet<Contact>();

         try {

         // Open a connection
        // Class.forName("com.mysql.jdbc.Driver");
         
         //conn = DriverManager.getConnection(DB_URL, USER, PASS);

         conn=ds.getConnection();

         // Execute SQL query
         stmt = conn.prepareStatement("SELECT * FROM contacts");

         rs = stmt.executeQuery();

         contactSet.clear();
         
         // Extract data from result set
        while(rs.next())
        {
         contactSet.add(new Contact(rs.getString("firstName"),rs.getString("lastName"),null,null,rs.getString("phnNo")));
        }

        // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) 
         {
         //Handle errors for JDBC
         se.printStackTrace();

      } catch(Exception e) 
         {
         //Handle errors for Class.forName
         e.printStackTrace();

      } finally 
         {
         } //end try
  
      log.info("********************ContactRepository**********************findAll---------> end");

      return contactSet;

      }

    /**
     * Save a contact.
     *
     * @param contact save to database.
     *
     */

      public void save(Contact contact)

      {

        log.info("********************ContactRepository**********************save---------> start");

        try {

         // Open a connection
         //Class.forName("com.mysql.jdbc.Driver");
         
         //conn = DriverManager.getConnection(DB_URL, USER, PASS);

         conn=ds.getConnection();

         // Execute SQL query
         stmt = conn.prepareStatement("insert into contacts values(?,?,?,?,?)");


        //sql = "insert into contacts values(?,?,?,?,?)";
         stmt.setString(1,contact.getFirstName());
         stmt.setString(2,contact.getLastName());
         stmt.setString(3,contact.getPlace());
         stmt.setString(4,contact.getPhNo());
         stmt.setString(5,contact.getEmail());
         stmt.executeUpdate();
         
        //contact=new Contact(request.getParameter("first_name"),request.getParameter("last_name"),request.getParameter("Email_Id"),request.getParameter("Place"),request.getParameter("Phone_No")));

         // Clean-up environment
         stmt.close();
         conn.close();
      } catch(SQLException se) 
         {
         //Handle errors for JDBC
         se.printStackTrace();

      } catch(Exception e) 
         {
         //Handle errors for Class.forName
         e.printStackTrace();

      } finally 
         {
         } //end try
      

      log.info("********************ContactRepository**********************save---------> end");

      }

     /**
     * Delete the contact by name.
     *
     * @param name the id of the contact.
     */

      public void delete(String name)
      
      {
        
        log.info("********************ContactRepository**********************delete---------> start");
         
         try {

         // Open a connection
         //Class.forName("com.mysql.jdbc.Driver");
         
         //conn = DriverManager.getConnection(DB_URL, USER, PASS);

         conn=ds.getConnection();

         // Execute SQL query
          stmt = conn.prepareStatement("DELETE FROM contacts WHERE firstName=?");

          stmt.setString(1,name);         

          stmt.executeUpdate();
         
         // Clean-up environment
         stmt.close();
         conn.close();

            } catch(SQLException se) 

            {
              //Handle errors for JDBC
              se.printStackTrace();

            } catch(Exception e) 

            {
             //Handle errors for Class.forName
             e.printStackTrace();

            } finally 
            {
            } //end try

      log.info("********************ContactRepository**********************delete---------> end");

      }

    /**
     * Updates a contact in the database
     * 
     * @param contact
     *            contact to be updated
     * 
    */

      public void update(Contact contact)
     
      {
         log.info("********************ContactRepository**********************update---------> start");

      try {

         // Open a connection
         //Class.forName("com.mysql.jdbc.Driver");
         
         //conn = DriverManager.getConnection(DB_URL, USER, PASS);

          conn=ds.getConnection();

         // Execute SQL query
         stmt = conn.prepareStatement("update contacts set lastName=?,place=?,phnNo=?,emailId=? where firstName=?");

         stmt.setString(1,contact.getLastName());
         stmt.setString(2,contact.getPlace());
         stmt.setString(3,contact.getPhNo());
         stmt.setString(4,contact.getEmail());
         stmt.setString(5,contact.getFirstName());

         stmt.executeUpdate();

         // Clean-up environment
         stmt.close();
         conn.close();
      } catch(SQLException se) 
         {
         //Handle errors for JDBC
         se.printStackTrace();

      } catch(Exception e) 
         {
         //Handle errors for Class.forName
         e.printStackTrace();

      } finally 
         {
         } //end try

         log.info("********************ContactRepository**********************update---------> end");

      }   
      
    /**
     * Get one contact by phnNo.
     *
     * @param phnNo the id of the contact.
     *
     * @return the contact
     */
      public Contact findOne(String phnNo)
     
      {
        log.info("********************ContactRepository**********************findOne---------> start");

        try {

         // Open a connection
         //Class.forName("com.mysql.jdbc.Driver");
         
         //conn = DriverManager.getConnection(DB_URL, USER, PASS);

          conn=ds.getConnection();

          // Execute SQL query
          stmt = conn.prepareStatement("SELECT * FROM contacts WHERE phnNo=?");

          stmt.setString(1,phnNo);
         
          rs=stmt.executeQuery();

         // Extract data from result set
         while(rs.next())

             contact=new Contact(rs.getString("firstName"),rs.getString("lastName"),rs.getString("emailId"),rs.getString("place"),rs.getString("phnNo"));
      
         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) 
         {
         //Handle errors for JDBC
         se.printStackTrace();

      } catch(Exception e) 
         {
         //Handle errors for Class.forName
         e.printStackTrace();

      } finally 
         {
         } //end try
      
        log.info("********************ContactRepository**********************findOne---------> End");

        return contact;

      } 

    /**
     * Get one contact by name.
     *
     * @param name the id of the contact.
     *
     * @return the set of contacts.
     */

      public Set<Contact> findByName(String name)
     
      {
        log.info("********************ContactRepository**********************findByName---------> start");

        contactSet=new TreeSet<Contact>();
           
         try {

          // Open a connection
          //Class.forName("com.mysql.jdbc.Driver");
         
          //conn = DriverManager.getConnection(DB_URL, USER, PASS);

          conn=ds.getConnection();

           // Execute SQL query
          stmt = conn.prepareStatement("SELECT * FROM contacts WHERE CONCAT(firstName,' ',lastName) LIKE ?");

          stmt.setString(1,name+"%");

          rs = stmt.executeQuery();
            
          contactSet.clear();

         // Extract data from result set
         while(rs.next())
         {
          contactSet.add(new Contact(rs.getString("firstName"),rs.getString("lastName"),rs.getString("emailId"),rs.getString("place"),rs.getString("phnNo")));            
         } 
         
         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) 
         {
         //Handle errors for JDBC
         se.printStackTrace();

      } catch(Exception e) 
         {
         //Handle errors for Class.forName
         e.printStackTrace();

      } finally 
         {
          
         } //end try  

        log.info("********************ContactRepository**********************findByName---------> End");

        return contactSet;

    }






}