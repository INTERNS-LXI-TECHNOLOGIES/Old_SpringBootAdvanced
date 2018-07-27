package com.lxisoft.facebookApp2.model;

public class QuizResult
{

  private Question question;
  private String choice;
  
  public void setQuestion(Question question)
  {
	  this.question = question;
  }
  public Question getQuestion()
  {
	  return question;
  }
  public void setChoice(String choice)
  {
	  this.choice = choice;
  }
  public String getChoice()
  {
	  return choice;
  }
  
  
}
