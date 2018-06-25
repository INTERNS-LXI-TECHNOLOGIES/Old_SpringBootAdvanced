package com.lxisoft.databasedemo.controller;
import com.lxisoft.databasedemo.model.Contact; 
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class DatabaseServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarathdb", "root", "root");
			stmt = conn.createStatement();
			String sql = "INSERT INTO sarathtable(name,number) "+"VALUES ('"+name+"','"+number+"'"+")";
			stmt.executeUpdate(sql);
			conn.close();
		} catch(SQLException se) {
        se.printStackTrace();
    }catch(Exception e) {
        e.printStackTrace();
}finally {
	}
				
		RequestDispatcher view=request.getRequestDispatcher("start.jsp");
		view.forward(request,response);	
		
		
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		List<Contact> contacts = new ArrayList<Contact>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarathdb", "root", "root");
        stmt = conn.createStatement();
        String sql = "SELECT * FROM sarathtable";
		rs = stmt.executeQuery(sql);

        while (rs.next()) {
           Contact contact = new Contact();
		   contact.setId(rs.getInt("id"));
		   contact.setName(rs.getString("name"));
		   contact.setNumber(rs.getString("number"));
		   contacts.add(contact);
        }
    } catch (Exception e) {
        System.out.println(e);
    }finally{
        //Code to release your resources
    }
	for(Contact c: contacts)
	{
	System.out.println(c.getId()+" "+c.getName()+" "+c.getNumber());
	}
	request.setAttribute("contacts",contacts);
	RequestDispatcher view=request.getRequestDispatcher("viewall.jsp");
	view.forward(request,response);
	}
	
	
	
}