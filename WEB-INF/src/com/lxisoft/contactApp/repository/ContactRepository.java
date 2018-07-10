package com.lxisoft.contactApp.repository;

//Import required java libraries
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import com.lxisoft.contactApp.model.*;
//import javax.naming.Context;
//import javax.naming.InitialContext;
import javax.naming.*;
import javax.annotation.Resource;
import javax.sql.DataSource;


public class ContactRepository 
{
	 
      /*// JDBC driver name and database URL   
      static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://localhost/contactApp_v1";
      
      //  Database credentials
      static final String USER = "root";
      static final String PASS = "root";*/

      
      /*@Resource(name="jdbc/contactApp_v1")
      private DataSource ds;*/

      private DataSource ds;

      static Connection conn;

      private PreparedStatement stmt;

      private ResultSet rs ;

      private Contact contact;

      private Set<Contact> contactSet;

      private static final Logger log=Logger.getLogger(ContactRepository.class.getName());

      public ContactRepository()
      {
         try {
              Context context = new InitialContext();
              ds = (DataSource)context.lookup("java:comp/env/jdbc/contactApp_v1");
             } catch (NamingException e) {
               e.printStackTrace();
              }

      }

      /*@Resource(name="jdbc/contactApp_v1")
      private void setMyDB(javax.sql.DataSource dss) {
        ds = dss;
      }

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