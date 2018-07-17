package com.lxisoft.contactApp.service.impl;

//Import required java libraries
import java.io.*;
import java.util.*;
import java.util.logging.*;
import com.lxisoft.contactApp.model.*;
import com.lxisoft.contactApp.service.*;
import com.lxisoft.contactApp.repository.*;

/**
 * Service Implementation for managing contact.
 * 
 * @author Sarangi Balu
 * 
 * @version $version-stub$
 *
 */

public class ContactServiceImpl implements ContactService

{
  /**
  * Reference to ContactRepository class
  */
	private ContactRepository contactRepository=new ContactRepository();

  /**
   * Reference to Logger class to get log messages
   */

	private static final Logger log=Logger.getLogger(ContactServiceImpl.class.getName());

  /**
   * Configures the logger object
   */
      
  {
    try {
              
         InputStream in = this.getClass().getClassLoader().getResourceAsStream("logging.properties");              

         LogManager.getLogManager().readConfiguration(in);

        } catch (IOException ex){
         // log.log(WARNING, "Exception caught={0}", ex);
          ex.printStackTrace(); }
  }

  /**
   * Get all the contacts.
   * 
   * @return the set of contacts.
   *
   */
	public Set<Contact> findAll()
	{
     
     log.info("********************ContactServiceImpl**********************findAll--------->start");

     return contactRepository.findAll();

      
	}

  /**
   * Save a contact.
   *
   * @param contact the contact to be saved.
   *
   */

	public void save(Contact contact)
	
	{

	  log.info("********************ContactServiceImpl**********************save---------> start");
     
    contactRepository.save(contact);
     
    log.info("********************ContactServiceImpl**********************save-----------> end");

  }

  /**
   * Delete the contact by name.
   *
   * @param name the id of the contact.
   */

  public void delete(String name)
   	
  {

    log.info("********************ContactServiceImpl**********************delete---------> start");
     
    contactRepository.delete(name);
     
    log.info("********************ContactServiceImpl**********************delete-----------> end");

  }

  /**
   * Updates a contact in the database
   * 
   * @param contact
   *            contact to be updated
   * 
   */

  public void update(Contact contact)
	
	{

	  log.info("********************ContactServiceImpl**********************update---------> start");
     
    contactRepository.update(contact);
     
    log.info("********************ContactServiceImpl**********************update-----------> end");

  }
  
  /**
   * Get one contact by phnNo.
   *
   * @param phnNo the id of the contact.
   *
   * @return the contact
   */

  public Contact findOne(String phnNo)

  {
   		log.info("********************ContactServiceImpl**********************findOne----> start");
     
      return contactRepository.findOne(phnNo);
     
  }

  /**
   * Get one contact by name.
   *
   * @param name the id of the contact.
   *
   * @return the set of contacts.
   */

    
  public Set<Contact> findByName(String name)
    
  {
    	log.info("********************ContactServiceImpl**********************findByName----> start");
     
      return contactRepository.findByName(name);
  }


	
}