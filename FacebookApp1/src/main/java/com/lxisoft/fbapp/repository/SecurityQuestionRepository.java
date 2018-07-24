package com.lxisoft.fbapp.repository;
import java.sql.*;
import javax.sql.*;
import com.lxisoft.fbapp.model.*;
import java.util.*;
import javax.naming.*;

/**
*@author Anjali
*Repository class to get security questions
*
*/
public class SecurityQuestionRepository{
	
	SecurityQuestion question;
	DataSource ds;
	
	Context ic; 
	
	/**
	*
	*method to retrive random questions from database
	*/
	public void findSecurityQuestion(){
		
		Connection con;
		PreparedStatement stmt;
		
		Set<String> options=new HashSet<String>();
		Set<SecurityQuestion> questions=new HashSet<SecurityQuestion>();		
		
		try{
			
			ic=new InitialContext();
			ds = (DataSource) ic.lookup("java:/comp/env/jdbc/fbrepo");
	
			con=ds.getConnection();
			
			do{
				stmt=con.prepareStatement("select * from question order by rand() limit 1");
			
				ResultSet rs=stmt.executeQuery();
				
				question=new SecurityQuestion();
				question.setQuestion(rs.getString("question"));
				question.setAnswer(rs.getString("answer"));
				
				options.add(rs.getString("option1"));
				options.add(rs.getString("option2"));
				options.add(rs.getString("option3"));
				
				question.setOptions(options);
				
				System.out.println("********************"+question.getQuestion());
				
				questions.add(question);
		
			}while(questions.contains(question)==true);
			
			con.close();
			
		}
		catch(Exception ex){
			ex.printStackTrace();

			}

	}
}