package com.lxisoft.contactApp.service.impl;

//Import required java libraries
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import com.lxisoft.contactApp.model.*;
import com.lxisoft.contactApp.service.*;
import com.lxisoft.contactApp.repository.*;

public class ContactServiceImpl implements ContactService

{
	private ContactRepository contactRepository=new ContactRepository();

	private static final Logger log=Logger.getLogger(ContactServiceImpl.class.getName());


	public Set<Contact> findAll()
	{
     
     log.info("********************ContactServiceImpl**********************findAll--------->start");

     return contactRepository.findAll();

      
	}

	public void save(Contact contact)
	
	{

	log.info("********************ContactServiceImpl**********************save---------> start");
     
    contactRepository.save(contact);
     
    log.info("********************ContactServiceImpl**********************save-----------> end");

   	}

   	public void delete(String name)
   	
   	{

    log.info("********************ContactServiceImpl**********************delete---------> start");
     
    contactRepository.delete(name);
     
    log.info("********************ContactServiceImpl**********************delete-----------> end");

   	}

   	public void update(Contact contact)
	
	{

	log.info("********************ContactServiceImpl**********************update---------> start");
     
    contactRepository.update(contact);
     
    log.info("********************ContactServiceImpl**********************update-----------> end");

   	}

   	public Contact findOne(String phnNo)

   	{
   		log.info("********************ContactServiceImpl**********************findOne----> start");
     
      return contactRepository.findOne(phnNo);
     
  	}

    
    public Set<Contact> findByName(String name)
    {
    	log.info("********************ContactServiceImpl**********************findByName----> start");
     
      return contactRepository.findByName(name);
    }


	
}