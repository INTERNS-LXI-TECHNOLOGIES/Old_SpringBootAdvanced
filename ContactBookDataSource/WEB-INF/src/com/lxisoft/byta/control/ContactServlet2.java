package com.lxisoft.byta.control;
import com.lxisoft.byta.model.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.*;  
import javax.servlet.http.*; 
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException.*;
import javax.sql.DataSource;


import java.util.*;
public class ContactServlet2 extends HttpServlet
{
	
	
	 private DataSource dataSource;
     protected  void  doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException  {
				String names=request.getParameter("NAMES");
				
				try {
    
				System.out.println("names.........................."+names);
				Context initContext = new InitialContext();
				 
				 System.out.println("CONNECTION WORKS OR nOT 1");
				 Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/Contacts"); 
			
			 Connection con = dataSource.getConnection();
			 System.out.println("CONNECTION WORKS OR nOT 2");
				
				
				 String query = "select * from contactdetails2 where Name='"+names+"'";
				 System.out.println("CONNECTION WORKS OR nOT 3");
			//
			 PreparedStatement ps = con.prepareStatement(query); // generates sql query
			 System.out.println("CONNECTION WORKS OR nOT 4");
	
	 ResultSet resultSet = ps.executeQuery();
	  while(resultSet.next()) {
            String name1 = resultSet.getString("Name");
			
			System.out.println("NAME1111+................"+name1);
            String phoneno1 = resultSet.getString("PhoneNo");
           String place = resultSet.getString("Address");
		   
		   
		   ContactDto dto=new ContactDto();
		   dto.setName(name1);
		   dto.setPhoneNo(phoneno1);
		   dto.setPlace(place);
             	 request.setAttribute("contacts",dto);
				  if(names.equals(dto.getName()))
				   {
					   System.out.println("SERVLET OLD NAME.............."+names);
					    HttpSession session=request.getSession();
					session.setAttribute("names",names); 
				   }
				 
				 
				 
				 }
		ps.close();		 
	  con.close();
  		
	 } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
			   
   RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
   rd.forward(request, response);
   
   }
			
			
			
protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException  {
				try {
    //Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

   // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts", "root", "root"); 

      
      String changeName=request.getParameter("CHANGENAME");
	   HttpSession session=request.getSession();
	  String oldName=(String)session.getAttribute("name");
	  
	  System.out.println("CHANGENAME...................."+changeName);
	  System.out.println("OLDNAME........................"+oldName);
	  
	  
	           Context initContext = new InitialContext();
				 
				 System.out.println("CONNECTION WORKS OR nOT 1");
				 Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/Contacts"); 
			 System.out.println("CONNECTION WORKS OR nOT 2");
			 
      String query2="UPDATE contactdetails2 SET Name ='"+changeName+"' WHERE Name ='"+oldName+"'";
	   
	    Connection con = dataSource.getConnection();
		PreparedStatement ps2 = con.prepareStatement(query2);
       
  //  ps2.setString(2, phoneno1);
   // ps2.setString(3, place);
   

    ps2.executeUpdate(); // execute it on test database
    System.out.println("successfuly inserted");
    ps2.close();
    con.close();
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  
 }
}
	
