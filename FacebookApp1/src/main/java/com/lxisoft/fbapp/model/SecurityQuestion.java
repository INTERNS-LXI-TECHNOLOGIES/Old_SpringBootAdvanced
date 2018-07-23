package com.lxisoft.fbapp.model;
/**

* This class is for control security question

* @author Dheeraj das
* @version 1.0

*/
public class SecurityQuestion
{
	private String question;
	private String answer;
	private Set<String> option; //= new Hashset<>(); 
	

	/**
	* This is a setter which sets the question
	* @param question - the question to set
	*/
	public void setQuestion(String question)
	{
		this.question = question;
	}
	
	/**
	* This is a getter which returns the question
	* @return question - the question to get
	*/
	public String getQuestion()
	{
		return question;
	}
	
	/**
	* This is a setter which sets the answer
	* @param answer - the answer to set
	*/
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	/**
	* This is a getter which returns the answer
	* @return answer - the answer to get
	*/
	public String getAnswer()
	{
		return answer;
	}
	
	/**
	* This is a setter which sets the option of set
	* @param option - the option to set 
	*/
	public void setOption(Set<String> option)
	{
		this.option = option;
	}
	
	/**
	* This is a getter which returns the option
	* @return option - the option to get
	*/
	public Set<string> getOption()
	{
		return option;
	}	
}