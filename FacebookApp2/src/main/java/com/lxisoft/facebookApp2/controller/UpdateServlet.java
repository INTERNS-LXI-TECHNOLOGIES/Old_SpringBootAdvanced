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

public class UpdateServlet extends HttpServlet
{
 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
	   try {
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root"); 

				String id=request.getParameter("Editid");
	System.out.println("id+................"+id);
				
				 String query = "select * from questtables where id='"+id+"'";
			//
			 PreparedStatement ps = con.prepareStatement(query); 
			// ps.executeQuery();// generates sql query
	
	  ResultSet resultSet = ps.executeQuery();
	  while(resultSet.next()) {
            int ids = resultSet.getInt("id");
			
			System.out.println("iddd1111+................"+ids);
            //Question question = (Question)resultSet.getString("Question");
			String question=resultSet.getString("question");
           String option1 = resultSet.getString("option1");
		    String option2 = resultSet.getString("option2");
			 String option3 = resultSet.getString("option3");
			  String option4 = resultSet.getString("option4");
			   String answer= resultSet.getString("answer");
			    //String option1 = resultSet.getString("option1");
		   
		   
		   Question qu=new Question();
		   qu.setQuestionId(ids);
		   qu.setQuestionName(question);
		  qu.setOption1(option1);
		  qu.setOption2(option2);
		  qu.setOption3(option3);
		   qu.setOption4(option4);
		  qu.setAnswer(answer);
		  // ad.setOption2(option2);
             	 request.setAttribute("admin",qu);
				 
	  }  
		ps.close();		 
	  con.close();
  		
	 } catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
			   
   
    RequestDispatcher dis=request.getRequestDispatcher("/readLogin.jsp");          
          dis.include(request, response); 
   
   
   
    
			}
			
			
protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException  {
				try {
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root"); 

      
      String id=request.getParameter("ID");
	  String question=request.getParameter("questions");
	  String option1=request.getParameter("option1");
	  String option2=request.getParameter("option2");
	  String option3=request.getParameter("option3");
	  String option4=request.getParameter("option4");
	  String answer=request.getParameter("answer");
	  
	   //HttpSession session=request.getSession();
	  //String oldName=(String)session.getAttribute("name");
	  
	   System.out.println("ID......................"+id);
	  System.out.println("question........................"+question); 
     String query2="UPDATE questtables SET Question ='"+question+"',Option1='"+option1+"',Option2='"+option2+"' ,option3='"+option3+"' ,Option4='"+option4+"' ,Answer='"+answer+"' WHERE id ="+Integer.parseInt(id);
	   PreparedStatement ps = con.prepareStatement(query2);
	  
   

    ps.executeUpdate(); // execute it on test database
    System.out.println("update successfuly inserted");
	HttpSession session=request.getSession();
	Question quest=(Question)session.getAttribute("quest");
	session.setAttribute("quest",quest);
    ps.close();
    con.close();
   } catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   
    //RequestDispatcher rd = request.getRequestDispatcher("/edit.jsp");
  // rd.forward(request, response);
  response.sendRedirect("EditServlet");
   
  
 }
			}