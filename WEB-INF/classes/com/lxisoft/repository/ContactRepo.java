package com.lxisoft.repository;
import java.sql.*;
import com.lxisoft.model.*;

public class ContactRepo
{
	static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://localhost/contactServlet";

      static final String USER = "root";
      static final String PASS = "root";

      static Connection connection;
      private PreparedStatement stmt;



	Contact contact;
public void save(Contact contact)

      {

        try {

         // Open a connection
         Class.forName("com.mysql.jdbc.Driver");
         
         connection = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         stmt = connection.prepareStatement("insert into contact values(?,?,?)");


        //sql = "insert into contacts values(?,?,?,?,?)";
         stmt.setString(1,contact.getName());
         stmt.setString(2,contact.getPhNo());
         stmt.setString(3,contact.getAddress());
         //System.out.println(contact.getPhNo());
         stmt.executeUpdate();
         
        //contact=new Contact(request.getParameter("name"),request.getParameter("Phone_No"),request.getParameter("address")));

         // Clean-up environment
         stmt.close();
         connection.close();
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

      }
      public Contact findContactByName(String name){
     
      try{
         
   
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection(DB_URL, USER, PASS);
         stmt=connection.prepareStatement("select * from contact where name=?");
         stmt.setString(1,name);
         
         ResultSet rs=stmt.executeQuery();
         
         while(rs.next()){
            
         contact=new Contact(rs.getString("name"),rs.getString("phone"),rs.getString("address"));
         
            
         }
         connection.close();
         
      }
      catch(Exception ex){
         ex.printStackTrace();

         }
         
      return contact;

   }
}
