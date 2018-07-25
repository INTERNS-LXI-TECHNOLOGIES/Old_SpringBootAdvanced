package com.lxisoft.fbapp.model;
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
	*This is a unique id for security question
	*/
	private long questionId;

	/**
	*This is a question for security
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
	*This is a setter which sets the question id
	*
	*@param questionId - the question id to set
	*/
	public void setQuestionId(long questionId)
	{
		this.questionId = questionId;
	}

	/**
	*This is a getter which return the question id
	*
	*@return questionId - the question id to return
	*/
	public long getQuestionId()
	{
		return questionId;
	}
	
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
	* This is a setter which sets the options of set
	*
	* @param options - the option to set 
	*/
	public void setOptions(Set<String> options)
	{
		this.options = options;
	}
	
	/**
	* This is a getter which returns the options
	*
	* @return options - the options to get
	*/
	public Set<String> getOptions()
	{
		return options;
	}	
}