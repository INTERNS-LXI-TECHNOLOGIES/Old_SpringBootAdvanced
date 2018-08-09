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
public class EditServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
	  
	  
   String spage;
   int page;
   spage=request.getParameter("page");
   page=Integer.parseInt(spage);
   if(page==1)
   {
   }
   else
   {
	   page=page-1;  
            page=page*5+1;
   }
  //String value=request.getParameter("no");
  try{
   Class.forName("com.mysql.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "root"); 

   String query = "select * from questtables limit"+(page-1)+","+5;
    PreparedStatement ps = con.prepareStatement(query); // generates sql query
	
	 ResultSet resultSet = ps.executeQuery();
	 System.out.println("last log");
        ArrayList<Questions1> array=new ArrayList<Questions1>(); 
        while(resultSet.next()) {
			String id=resultSet.getString("id");
            String quest= resultSet.getString("questions");
			String option1=resultSet.getString("option1");
			String option2=resultSet.getString("option2");
			String option3=resultSet.getString("option3");
            String option4=resultSet.getString("option4");
			String answer=resultSet.getString("answer");
			
			//EditServlet edSv=new EditServlet();
			//Admin ad=new Admin();
			Questions1 qu=new Questions1();
			qu.setId(id);
			qu.setQuestionName(quest);
			qu.setOption1(option1);
			qu.setOption2(option2);
			qu.setOption3(option3);
			qu.setOption4(option4);
			qu.setAnswer(answer);
		array.add(qu);
		}
		      HttpSession session=request.getSession();  
		
		session.setAttribute("list",array);
  }catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  RequestDispatcher rd = request.getRequestDispatcher("/edit.jsp");
   rd.forward(request, response);   
			
	}
}