package com.lxisoft.fbapp.service;
import com.lxisoft.fbapp.repository.*;

/**
*@author Anjali
*service class to retrive random questions
*
*/
public class SecurityQuestionService{

	/**
	*
	*method to get call method from repository class for getting random questions
	*/
	public void findSecurityQuestion(){
		
		SecurityQuestionRepository repository=new SecurityQuestionRepository();
		repository.findSecurityQuestion();
		
	}
}