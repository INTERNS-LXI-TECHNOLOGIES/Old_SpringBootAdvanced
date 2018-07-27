package com.lxisoft.fbapp.service;
/*// import required java libaries*/
import java.util.*;
/* import all nessery models**/
import com.lxisoft.fbapp.model.SecurityQuestion;
/**
* service interface for maping questions
* 
*@author Sooraj pn
*
*@version $0.1$
**/

public interface SecurityQuestionService{

/**
*Get all questions
*
*@return the Set of questions
**/ 
//public Set<Question> getAllquestions();

/**
* save a Question
*@param Question is saved
**/

public void addSecurityQuestion(SecurityQuestion question);

/**
*Update a question
*
*@param an upadated question
*
**/

public void updateSecurityQuestion(SecurityQuestion question);

/**
*Delete a Question 
*
*@param Question 
**/

public void deleteSecurityQuestion(SecurityQuestion question);

/**
* find a Question 
*
*@param Integer (id)
*@return SecurityQuestion
*
**/
public SecurityQuestion findSecurityQuestion(Long id);


/**
* get all Question 
*
*@return set of type SecurityQuestion
*
**/
public Set<SecurityQuestion> findAllSecurityQuestion();


}