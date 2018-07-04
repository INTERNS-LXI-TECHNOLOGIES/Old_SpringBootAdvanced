package com.lxisoft.byta.control;
import com.lxisoft.byta.model.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException.*;
import javax.sql.DataSource;
import java.util.logging.Logger;
import org.apache.log4j.*;

import java.util.*;



public class ContactServlet extends HttpServlet
{
	
	//Logger log = Logger.getLogger("com.lxisoft.byta.control.*");
	 private static Logger log = Logger.getLogger(ContactServlet.class.getName());
			 
    private DataSource dataSource;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 

			
      //  response.setContentType("text/html");  
        //PrintWriter out=response.getWriter();
		
           
		
		 String names=request.getParameter("name");  
         String phonenos=request.getParameter("phoneno");
         String places=request.getParameter("place");
		 
		    log.info("Show DEBUG message");
		//names+"  "+phonenos+"   "+places
			 try {
				 Context initContext = new InitialContext();
				 
				 System.out.println("sysout CONNECTION WORKS OR nOT 1");
				 log.info("log CONNECTION WORKS OR nOT 1");
				 Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/Contacts"); 
			 System.out.println("CONNECTION WORKS OR nOT 2");
			   Connection conn = dataSource.getConnection();
			
			 System.out.println("CONNECTION WORKS OR nOT 3");
			 
			 
			 
			 
			 
			 
   // Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts", "root", "root"); 

    String query = "insert into contactdetails2 values(?,?,?)";
System.out.println("CONNECTION WORKS OR nOT 4");
    PreparedStatement ps = conn.prepareStatement(query); // generates sql query
System.out.println("CONNECTION WORKS OR nOT 5");
    ps.setString(1, names);
    ps.setString(2, phonenos);
    ps.setString(3, places);
   
System.out.println("CONNECTION WORKS OR nOT 6");
    ps.executeUpdate(); // execute it on test database
    System.out.println("successfuly inserted");
    ps.close();
    conn.close();
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  /*  RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
   rd.forward(request, response); */
  }
		 	
protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 	
			
			String SearchName=request.getParameter("searchName"); 
	
                 try {
					 // envContext = (Context) initContext.lookup("java:comp/env");
            //dataSource = (DataSource) envContext.lookup("jdbc/contacts"); 
			Context initContext = new InitialContext();
				 
				 System.out.println("CONNECTION WORKS OR nOT 1");
				 Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/Contacts"); 
			 System.out.println("CONNECTION WORKS OR nOT 2");
			 
			   Connection conn = dataSource.getConnection();
					  
					  
			// Statement stmt = conn.createStatement();
			 
          
 
    String query = "select * from contactdetails2 where Name='"+SearchName+"'";

    PreparedStatement ps = conn.prepareStatement(query); // generates sql query
	
	 ResultSet resultSet = ps.executeQuery();
	 System.out.println("last log");
         
        while(resultSet.next()) {
            String name1 = resultSet.getString("Name");
			
			System.out.println("NAME1111+................"+name1);
            String phoneno1 = resultSet.getString("PhoneNo");
           String place = resultSet.getString("Address");
		   
		   
		   ContactDto dto=new ContactDto();
		   dto.setName(name1);
		   dto.setPhoneNo(phoneno1);
		   dto.setPlace(place);
             

  

     // execute it on test database
    System.out.println("successfuly inserted");
	 //resultSet.close();
    //ps.close();
   
	
	 request.setAttribute("contacts",dto);
				 }
	  conn.close();
  		
	

   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
   rd.forward(request, response);
  
	}
	
}

       
