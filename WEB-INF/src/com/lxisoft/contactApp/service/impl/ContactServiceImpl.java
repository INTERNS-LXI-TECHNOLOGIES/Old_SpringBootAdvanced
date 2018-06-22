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

   	public Contact findByName(String name)

   	{
   		log.info("********************ContactServiceImpl**********************findByName----> start");
     
        return contactRepository.findByName(name);
     
  	}




	
}