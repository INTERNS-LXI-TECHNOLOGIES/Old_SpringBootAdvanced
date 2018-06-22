package com.lxisoft.contactApp.repository;

//Import required java libraries
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import com.lxisoft.contactApp.model.*;


public class ContactRepository 
{
	 
      // JDBC driver name and database URL   
      static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://localhost/contactApp_v1";
      
      //  Database credentials
      static final String USER = "root";
      static final String PASS = "root";

      static Connection conn;

      private PreparedStatement stmt;

      private ResultSet rs ;

      private Contact contact;

      private Set<Contact> contactSet;

      private static final Logger log=Logger.getLogger(ContactRepository.class.getName());


      public Set<Contact> findAll()

      {
        
        log.info("********************ContactRepository**********************findAll---------> start");

         contactSet=new TreeSet<Contact>();

         try {

         // Open a connection
         Class.forName("com.mysql.jdbc.Driver");
         
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         stmt = conn.prepareStatement("SELECT * FROM contacts");

         rs = stmt.executeQuery();

         contactSet.clear();
         
         // Extract data from result set
        while(rs.next())
        {
         contactSet.add(new Contact(rs.getString("firstName"),rs.getString("lastName"),null,null,null));
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



      public void save(Contact contact)

      {

        log.info("********************ContactRepository**********************save---------> start");

        try {

         // Open a connection
         Class.forName("com.mysql.jdbc.Driver");
         
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

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

      public void delete(String name)
      
      {
        
        log.info("********************ContactRepository**********************delete---------> start");
         
         try {

         // Open a connection
         Class.forName("com.mysql.jdbc.Driver");
         
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

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

      public Contact findByName(String name)
     
      {
        log.info("********************ContactRepository**********************findByName---------> start");

        try {

         // Open a connection
         Class.forName("com.mysql.jdbc.Driver");
         
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

          // Execute SQL query
          stmt = conn.prepareStatement("SELECT * FROM contacts WHERE firstName=?");

          stmt.setString(1,name);
         
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
      
        log.info("********************ContactRepository**********************findByName---------> End");

        return contact;

      } 

}