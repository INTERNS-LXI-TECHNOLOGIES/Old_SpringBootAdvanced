package com.lxisoft.contacts.service;

// Import required java libraries
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import com.lxisoft.contacts.model.Contact;
import com.lxisoft.contacts.repository.ContactRepository;

/**
 * Service class which acts as an intermediate layer for putting all the
 * business logics in place.
 *
 * @author Sanil kumar
 */

public class ContactService {

  /**
  * Reference to the repository layer
  */
  private ContactRepository repo=new ContactRepository();

  /**
   * Logger instance to get log messages
   */
   private static final Logger log = Logger.getLogger(ContactRepository.class.getName());


  /**
  * save single contact
  * @param contact
  *            contact to be created
  * @return row number of database table getting from repository layer
  */
   public int save(Contact contact)
   {
   		log.info("execution starts "+contact);

      int result=repo.save(contact);
      log.info("execution stops "+result);
      return result;
   }

  /**
  * find all elements from the repository
  * @return Set of contacts which has been retrieved as a result of
  * select query in the save method of repository
  */
   public Set<Contact> findAll()
   {
      log.info("execution starts ");

      Set<Contact> contacts=repo.findAll();

      log.info("execution ends");
      return contacts;
   }

  /**
  * find unique contact
  * @param phoneNumber Phone number as id
  * @return Contact which has been retrieved as a result of select 
  * query in the repo layer
  */
   public Contact findOne(String phoneNumber)
   {
      
      log.info("execution starts "+phoneNumber);
      
      Contact contact=repo.findOne(phoneNumber);

      log.info("execution ends "+contact);
      return contact;

   }

  /**
  * Delete contact from the database by calling delete method
  * in repository
  * @param phoneNumber Phone number as id
  * @return row number of database table   
  */
   public int delete(String phoneNumber)
   {
      
      log.info("execution starts");
      int result=repo.delete(phoneNumber);
 
      log.info("execution ends");
      return result;
    }

  /**
  * Updates a contact in the database
  * @param contact contact to be updated
  * @return row number of database table   
  */
   public int update(Contact contact)
   {
      
      log.info("execution starts");
      int result=repo.update(contact);
      log.info("execution ends");
      return result;
    }

  /**
  * find set of contacts from the database based on first name and last
  * name
  * @param nameLike Key to retrieve contacts
  * @return Set of retrieved contacts 
  */
   public Set<Contact> findByNameLike(String nameLike)
   {
      
      log.info("execution starts");
      Set<Contact> contacts =repo.findByNameLike(nameLike);

      log.info("execution ends");
      return contacts;
   }
}