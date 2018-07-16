package com.lxisoft.contactApp.service;

/*// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;*/

import java.util.*;
//import java.util.logging.Logger;
import com.lxisoft.contactApp.model.*;

/**
 * Service Interface for managing contact.
 *
 * @author Sarangi Balu
 */

public interface ContactService
{
  /**
   * Get all the contacts.
   * 
   * @return the set of contacts.
   *
   */
	Set<Contact> findAll();

  /**
   * Save a contact.
   *
   * @param contact the contact to be saved.
   *
   */

	void save(Contact contact);

  /**
   * Get one contact by phnNo.
   *
   * @param phnNo the id of the contact.
   *
   * @return the contact.
   */

	Contact findOne(String phnNo);

  /**
   * Delete the contact by name.
   *
   * @param name the id of the contact.
   */

	void delete(String name);

   /**
   * Updates a contact in the database.
   * 
   * @param contact
   *            contact to be updated.
   * 
   */

	void update(Contact contact);

  /**
   * Get one contact by name.
   *
   * @param name the id of the contact.
   *
   * @return the set of contacts.
   */


	Set<Contact> findByName(String name);
}