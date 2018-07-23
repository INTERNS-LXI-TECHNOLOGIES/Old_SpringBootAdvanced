package com.lxisoft.model;
import java.util.*;

/**
* This class is for control security question
*
* @author Dheeraj das
*
* @version 1.0
*
*/
public class SecurityQuestion
{
	/**
	*This is a question for securiy
	*/
	private String question;
	
	/**
	*This is a answer for security question
	*/
	private String answer;
	
	/**
	*This is a set of options for security question
	*/
	private Set<String> options;  
	

	/**
	* This is a setter which sets the question
	*
	* @param question - the question to set
	*/
	public void setQuestion(String question)
	{
		this.question = question;
	}
	
	/**
	* This is a getter which returns the question
	*
	* @return question - the question to get
	*/
	public String getQuestion()
	{
		return question;
	}
	
	/**
	* This is a setter which sets the answer
	*
	* @param answer - the answer to set
	*/
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	/**
	* This is a getter which returns the answer
	*
	* @return answer - the answer to get
	*/
	public String getAnswer()
	{
		return answer;
	}
	
	/**
	* This is a setter which sets the option of set
	*
	* @param option - the option to set 
	*/
	public void setOptions(Set<String> options)
	{
		this.options = options;
	}
	
	/**
	* This is a getter which returns the option
	*
	* @return option - the option to get
	*/
	public Set<string> getOptions()
	{
		return options;
	}	
}