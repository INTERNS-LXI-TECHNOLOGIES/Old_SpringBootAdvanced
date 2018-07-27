package com.lxisoft.fbapp.service.impl;

/**

*import required java libraries

**/

import java.util.*;
/**
* importing log4j 
*
**/
import org.apache.log4j.Logger;
/**
*importing the servic interface
**/
import com.lxisoft.fbapp.service.SecurityQuestionService;

/**importing  SecurityQuestionRepository**/

import com.lxisoft.fbapp.repository.SecurityQuestionRepository;

/**importing  SecurityQuestion**/

import com.lxisoft.fbapp.model.SecurityQuestion;

/**
*service implementation for managing Security questions
*@author Sooraj pn 
*@version 1.0
**/
public class SecurityQuestionServiceImpl implements SecurityQuestionService{

/**
* Reference to QuestionRepository
**/

private SecurityQuestionRepository securityQuestionRepository=new SecurityQuestionRepository();

/**
Reference to Lo gger class to get loggings
**/

private static final Logger log=Logger.getLogger(SecurityQuestionServiceImpl.class.getName());

/**
*implementation for addSecurityQuestion method
**/
public void addSecurityQuestion(SecurityQuestion securityQuestion){
	log.info("========Enter into questionServce/addSecurityQuestion()========");
	
	log.info("========Exiting from questionServce/addSecurityQuestion()========");
	securityQuestionRepository.addSecurityQuestion(securityQuestion);
}

/**
*implementation for deleteSecurityQuestion method
**/
public void deleteSecurityQuestion(SecurityQuestion securityQuestion){
	log.info("========Enter into questionServce/deleteSecurityQuestion()========");
	
	log.info("========Exiting from questionServce/deleteSecurityQuestion()========");
	securityQuestionRepository.deleteSecurityQuestion(securityQuestion);
}

/**
*implementation for update SecurityQuestion method
**/
public void updateSecurityQuestion(SecurityQuestion securityQuestion){
	log.info("========Enter into questionServce/updateSecurityQuestion()========");
	securityQuestionRepository.updateSecurityQuestion(securityQuestion);
	log.info("========Exiting from questionServce/updateSecurityQuestion()========");
}

public SecurityQuestion findSecurityQuestion(Long id){
	log.info("========Enter into questionServce/findSecurityQuestion()========");
	
	log.info("========Exiting from questionServce/findSecurityQuestion()========");
	return securityQuestionRepository.findSecurityQuestion(id);
}

public Set<SecurityQuestion> findAllSecurityQuestion(){

	log.info("========Enter into questionServce/findAllSecurityQuestion()========");
	
	log.info("========Exiting from questionServce/findAllSecurityQuestion()========");
	return securityQuestionRepository.findAllSecurityQuestion();

	}
}


