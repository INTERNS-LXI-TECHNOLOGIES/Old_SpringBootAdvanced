package com.lxisoft.databasedemo.controller;
import com.lxisoft.databasedemo.model.Contact; 
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class DatabaseServlet2 extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		String a= request.getParameter("id"); 
		int id = Integer.parseInt(a);
		String number = request.getParameter("number");
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarathdb", "root", "root");
			stmt = conn.createStatement();
			String sql = "UPDATE sarathtable SET number='"+number+"' where id='"+id+"'";
			stmt.executeUpdate(sql);
			conn.close();
			RequestDispatcher view=request.getRequestDispatcher("intex.jsp");
		view.forward(request,response);	
		} catch(SQLException se) {
        se.printStackTrace();
    }catch(Exception e) {
        e.printStackTrace();
}finally {
	}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		String a= request.getParameter("id"); 
		int id = Integer.parseInt(a);
			Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarathdb", "root", "root");
			stmt = conn.createStatement();
			String sql = "delete from sarathtable"+" WHERE id ='"+id+"'";
			stmt.executeUpdate(sql);
			conn.close();
			RequestDispatcher view=request.getRequestDispatcher("intex.jsp");
		view.forward(request,response);	
		} catch(SQLException se) {
        se.printStackTrace();
    }catch(Exception e) {
        e.printStackTrace();
}finally {
	}
	}
	
}