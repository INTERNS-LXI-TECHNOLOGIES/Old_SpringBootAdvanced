package com.lxisoft.byta.controller;

import com.lxisoft.byta.model.Contact;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.io.*;

public class ContactServlet extends HttpServlet {
 

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phoneNumber");
		Long phoneNumber=Long.parseLong(phone);
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		
		Connection con;
		PreparedStatement stmt;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactinfo?useUnicode=yes&characterEncoding=UTF-8","root","root");
			stmt=con.prepareStatement("insert into contactdetails values(?,?,?,?)");
			stmt.setString(1,name);
			stmt.setLong(2,phoneNumber);
			stmt.setString(3,address);
			stmt.setString(4,email);
			stmt.executeUpdate();
			con.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/success.jsp");
		rd.forward(request,response);
		
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String searchName=request.getParameter("searchbyname");
		
		Connection con;
		PreparedStatement stmt;
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactinfo","root","root");
			stmt=con.prepareStatement("select * from contactdetails where name=?");
			stmt.setString(1,searchName);
			
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				
				Contact contact=new Contact(rs.getString("name"),rs.getLong("phoneNumber"),rs.getString("address"),rs.getString("email"));
			
			request.setAttribute("contact",contact);	
				
			}
			con.close();
			
		}
		catch(Exception ex){
			ex.printStackTrace();

			}
			
			RequestDispatcher rd=request.getRequestDispatcher("/viewdetails.jsp");
			rd.forward(request,response);

	}




	
}