package com.lxisoft.facebookApp2.controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.io.*;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpSession;
import com.lxisoft.facebookApp2.model.*;
import javax.servlet.RequestDispatcher;
import java.util.*;
public class SelectUserServlet extends HttpServlet 
{
     protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
	   try {
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "root"); 
	
   String query2="select * from userroles";
	  
	    PreparedStatement ps = con.prepareStatement(query2);
		
		ArrayList<User>users=new ArrayList<User>();
		 ResultSet resultSet = ps.executeQuery();
	  	  while(resultSet.next()) {
           
           
			String userName=resultSet.getString("userName");
			String roleName=resultSet.getString("roleName");
          
	     User user=new User();
	  
	 
	   user.setUserName(userName);
	   user.setRoleName(roleName);
	   
	   users.add(user);
	  }
	    HttpSession session=request.getSession(); 
	  session.setAttribute("list",users);
      }catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
      e.printStackTrace();
     }
	 
	 response.sendRedirect("displayuserroles.jsp"); 
	   
	    }
		
			protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
	   try {
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "root"); 

    String username=request.getParameter("username");
   String rolename=request.getParameter("rolename");
	
	     String query="update userroles set username='"+username+"',rolename='"+rolename+"'where username='"+username+"'";
		 PreparedStatement ps=con.prepareStatement(query);
		ps.executeUpdate();
	   }
	   catch(ClassNotFoundException|SQLException ex)
	   {
		   ex.printStackTrace();
	   }
	   response.sendRedirect("displayuserroles.jsp");
	}
}