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
import java.util.*;
import javax.servlet.RequestDispatcher;
import com.lxisoft.facebookApp2.model.*;
import javax.servlet.http.HttpSession; 



public class DeleteServlet  extends HttpServlet
{


  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
 {
	
	 try{
	 Class.forName("com.mysql.jdbc.Driver");
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "root"); 
	 String number=request.getParameter("DeleteId");
	  String query = "DELETE FROM questtables WHERE ID='"+number+"'";
	  PreparedStatement ps = con.prepareStatement(query);
	  //ps.setString(1,number);
	   ps.executeUpdate();


 } catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
response.sendRedirect("EditServlet");   
	  
	
 }
   
			
			
	
 protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
 {
 
 }
}