package com.lxisoft.controller;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.lxisoft.model.Contact;

// Extend HttpServlet class
public class ContactEditServlet extends HttpServlet 
{
 
      private Contact contact;

      private String sql;

      //private PrintWriter out;
         
      // JDBC driver name and database URL   
      static final String JDBC_DRIVER= "com.mysql.jdbc.Driver"; ;  
      static final String DB_URL="jdbc:mysql://localhost/contactapp";;
      
      //  Database credentials
      static final String USER = "root";
      static final String PASS = "root";

      static Connection conn;

      private PreparedStatement stmt;

      private ResultSet rs ;

public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
   {

          
      try {

         // Open a connection
         Class.forName("com.mysql.jdbc.Driver");
         
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
          stmt = conn.prepareStatement("update contacts set lastName=?,place=?,phnNo=?,emailId=? where firstName=?");

          
         stmt.setString(1,request.getParameter("last_name"));
         stmt.setString(2,request.getParameter("Place"));
         stmt.setString(3,request.getParameter("Phone_No"));
         stmt.setString(4,request.getParameter("Email_Id"));
         stmt.setString(5,request.getParameter("key"));

         

         stmt.executeUpdate();

         request.setAttribute("contact",new Contact(request.getParameter("first_name"),request.getParameter("last_name"),request.getParameter("Email_Id"),request.getParameter("Place"),request.getParameter("Phone_No")));
         
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

      // forward to jsp page with request parameters
      request.getRequestDispatcher("Contact_Details.jsp").forward(request,response);
 
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
   {
      

       Set<Contact> contactSet=new TreeSet<Contact>();
           
         try {

         // Open a connection
         Class.forName("com.mysql.jdbc.Driver");
         
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
          stmt = conn.prepareStatement("SELECT * FROM contacts WHERE firstName=?");

          stmt.setString(1,request.getParameter("first_name"));

          
          rs = stmt.executeQuery();
            
          contactSet.clear();

         // Extract data from result set
         while(rs.next())
         {


           contactSet.add(new Contact(rs.getString("firstName"),rs.getString("lastName"),rs.getString("emailId"),rs.getString("place"),rs.getString("phnNo")));

            //Retrieve by column name
            
            /*request.setAttribute("first_name",rs.getString("firstName"));
            request.setAttribute("last_name",rs.getString("lastName"));
            request.setAttribute("Place",rs.getString("place"));
            request.setAttribute("Phone_No",rs.getString("phnNo"));
            request.setAttribute("Email_Id",rs.getString("emailId"));
*/
           /*System.out.println("*********************print********************************"+rs.getString("firstName")+","+rs.getString("lastName")+","+rs.getString("place")+","+rs.getString("phnNo")+","+rs.getString("emailId"));
           
           for(Enumeration<String> ss=request.getParameterNames(); ss.hasMoreElements();)
            System.out.println(ss.nextElement());*/
            
         } 
         
         //System.out.println(contactSet);

         request.setAttribute("contactSet",contactSet);     

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

         /*String type="edit";
         if(type.equals(request.getParameter("type")))
              request.getRequestDispatcher("Contact_Edit.jsp").forward(request,response);
         else*/
         request.getRequestDispatcher("Index.jsp").forward(request,response);     // forward to jsp page with request parameters
         


   }



}