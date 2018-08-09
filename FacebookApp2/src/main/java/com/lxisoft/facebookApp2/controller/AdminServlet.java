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
public class AdminServlet extends HttpServlet 
  {
     //private DataSource source;
     protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
   {
	   String question=request.getParameter("Questions");
	  
	   
	   String option1=request.getParameter("option1");
	   String option2=request.getParameter("option2");
	   String option3=request.getParameter("option3");
	   String option4=request.getParameter("option4");
	   String answer=request.getParameter("answer");
	   try{
	   Class.forName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
	   Connection con=DriverManager.getConnection("jdbc:mySql://localhost:3306/questions","root","root");
	   String query="insert into questtables(questions,option1,option2,option3,option4,answer) values(?,?,?,?,?,?)";
=======
	   Connection con=DriverManager.getConnection("jdbc:mySql://localhost:3306/quiz","root","root");
	   String query="insert into Questtables(question,option1,option2,option3,option4,answer) values(?,?,?,?,?,?)";
>>>>>>> 5b812eaccf3aaaeaaee92c7bb59b70de70cd9538
	   PreparedStatement ps=con.prepareStatement(query);
	   ps.setString(1,question);
	  
	   ps.setString(2,option1);
	   ps.setString(3,option2);
	   ps.setString(4,option3);
	   ps.setString(5,option4);
	   ps.setString(6,answer);
	   ps.executeUpdate();
	   
	   System.out.println("IN.................");
	   con.close();
	   ps.close();
	   }
	   catch(ClassNotFoundException |SQLException ex)
	   {
		   ex.printStackTrace();
	   }
	   response.sendRedirect("sucess.jsp");
	  
System.out.print("Enter.............");
   
   }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
	   try {
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root"); 

				String id=request.getParameter("Number");
				
				
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
			   
    RequestDispatcher rd = request.getRequestDispatcher("/readLogin.jsp");
   rd.forward(request, response);
  
    
   // response.sendRedirect("readLogin.jsp");
    
			}
	
	}

 