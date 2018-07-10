package com.lxisoft.contacts.service;

// Import required java libraries
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import com.lxisoft.contacts.model.Contact;
import com.lxisoft.contacts.repository.ContactRepository;
import static java.util.logging.Level.FINE;
import static java.util.logging.Level.WARNING;
import static java.util.logging.Level.INFO;

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
  private ContactRepository repo = new ContactRepository();

  /**
   * Logger instance to get log messages
   */
  private static final Logger logger = Logger.getLogger(ContactRepository.class.getName());

  /**
   * Configures the logger object
   */
  static {

    try {
      LogManager.getLogManager()
          .readConfiguration(new FileInputStream("../webapps/contacts-v4/properties/logging.properties"));
    }

    catch (SecurityException e) {
      logger.log(WARNING, "Exception caught with {0}", e);
      e.printStackTrace();
    } catch (IOException e) {
      logger.log(WARNING, "Exception caught with {0}", e);
      e.printStackTrace();
    }
  }

  /**
   * save single contact
   * 
   * @param contact
   *            contact to be created
   * @return row number of database table getting from repository layer
   */
  public int save(Contact contact) {
    logger.log(INFO, "execution starts with {0}", contact);

    int result = repo.save(contact);
    logger.log(INFO, "execution stops with {0}", result);
    return result;
  }

  /**
   * find all elements from the repository
   * 
   * @return Set of contacts which has been retrieved as a result of select
   *         query in the save method of repository
   */
  public Set<Contact> findAll() {
    logger.info("execution starts ");

    Set<Contact> contacts = repo.findAll();

    logger.info("execution ends");
    return contacts;
  }

  /**
   * find unique contact
   * 
   * @param phoneNumber
   *            Phone number as id
   * @return Contact which has been retrieved as a result of select query in
   *         the repo layer
   */
  public Contact findOne(String phoneNumber) {

    logger.log(INFO, "execution starts with {0}", phoneNumber);

    Contact contact = repo.findOne(phoneNumber);

    logger.log(INFO, "execution ends with {0}", contact);
    return contact;

  }

  /**
   * Delete contact from the database by calling delete method in repository
   * 
   * @param phoneNumber
   *            Phone number as id
   * @return row number of database table
   */
  public int delete(String phoneNumber) {

    logger.log(INFO, "execution starts with {0}", phoneNumber);
    int result = repo.delete(phoneNumber);

    logger.log(INFO, "execution ends with {0}", result);
    return result;
  }

  /**
   * Updates a contact in the database
   * 
   * @param contact
   *            contact to be updated
   * @return row number of database table
   */
  public int update(Contact contact) {

    logger.log(INFO, "execution starts with {0}", contact);
    int result = repo.update(contact);
    logger.log(INFO, "execution ends with {0}", result);
    return result;
  }

  /**
   * find set of contacts from the database based on first name and last name
   * 
   * @param nameLike
   *            Key to retrieve contacts
   * @return Set of retrieved contacts
   */
  public Set<Contact> findByNameLike(String nameLike) {

    logger.log(INFO, "execution starts with {0}", nameLike);
    Set<Contact> contacts = repo.findByNameLike(nameLike);

    logger.log(INFO, "execution ends with {0}", contacts);
    return contacts;
  }
}