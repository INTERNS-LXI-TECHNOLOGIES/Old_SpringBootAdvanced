package com.lxisoft.facebookApp2.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import com.lxisoft.facebookApp2.model.Question;

public class QuestionController extends HttpServlet
{
	
	static Logger log = Logger.getLogger(QuestionController.class.getName());
	
	Connection connection = null;
	Statement statement = null;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{ 
		HttpSession session=request.getSession();
		session.setAttribute("questions",getQuestions());
		
		RequestDispatcher view=request.getRequestDispatcher("HomePage.jsp");
		view.forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
	}
	
	public ArrayList<Question> getQuestions()
	{
		ArrayList<Question> questionList=findAll();
		Collections.shuffle(questionList);
		ArrayList<Question> questions=new ArrayList<Question>();
		for(int i=0;i<3;i++)
		{
			questions.add(questionList.get(i));	
		}
		
		return questions;
	}
	
	public ArrayList<Question> findAll()
	{
		ArrayList<Question> questionList=new ArrayList<Question>();
		try {
			
			this.dataBaseConnectionEstablish();
			String sql;
			sql="SELECT * FROM questions";
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
			Question question=new Question();
			question.setQuestionId(rs.getInt(1));
			question.setQuestionName(rs.getString(2));
			question.setOption1(rs.getString(3));
			question.setOption2(rs.getString(4));
			question.setOption3(rs.getString(5));
			question.setAnswer(rs.getString(6));
			questionList.add(question);
			}
		}
		 catch (SQLException ex) {
            System.err.println(ex);
        }
		
		return questionList;
	}
	
	public void dataBaseConnectionEstablish() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/contacts", "root", "root");
				statement = connection.createStatement();
			    connection.close();
			} catch (Exception e) {
				System.out.println("dataBaseConnectionEstablish exception");
			}
		}
	}
}