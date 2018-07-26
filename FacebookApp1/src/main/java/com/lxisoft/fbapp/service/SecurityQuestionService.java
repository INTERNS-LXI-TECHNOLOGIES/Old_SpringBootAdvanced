package com.lxisoft.fbapp.service;
import com.lxisoft.fbapp.repository.*;
import java.util.*;
import com.lxisoft.fbapp.model.*;

/**
*@author Anjali
*service class to retrive random questions
*
*/
public class SecurityQuestionService{

	/**
	*@return questions
	*method to get call method from repository class for getting random questions
	*/
	public Set<SecurityQuestion> findSecurityQuestion(){
		
		SecurityQuestionRepository repository=new SecurityQuestionRepository();
		Set<SecurityQuestion> questions=repository.findSecurityQuestion();
		
		return questions;
	}
}