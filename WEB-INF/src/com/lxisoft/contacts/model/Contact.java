package com.lxisoft.contacts.model;

//import required java libraries
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import static java.util.logging.Level.FINE;
import static java.util.logging.Level.WARNING;

/**
 * An abstraction to capture details of each user/person. It implements
 * Comparable to get a sorted list of contacts by their names.
 *
 * @author Sanil kumar
 */

public class Contact implements Comparable<Contact> {
	
	/**
	 * firstName,lastName,phoneNumber and email.
	 */
	private String firstName, lastName, phoneNumber, email;

	/**
	 * Construct a contact with some parameters
	 * 
	 * @param firstName
	 *            first name of person
	 * @param lastName
	 *            last name of person
	 * @param phoneNumber
	 *            phone number of person
	 * @param email
	 *            email of person
	 */

	private static final Logger logger = Logger.getLogger(Contact.class.getName());
	/**
	 * Configures the logger object
	 */
	static {

		try {
			LogManager.getLogManager()
					.readConfiguration(new FileInputStream("../webapps/contacts-v4/properties/logging.properties"));
		}

		catch (SecurityException e) {

			logger.log(WARNING,"Caught Exception",e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.log(WARNING,"Caught Exception",e);
			e.printStackTrace();
		}
	}

	public Contact(String firstName, String lastName, String phoneNumber, String email) {

		logger.log(FINE,"starts constructor",new Object[] {firstName,lastName,phoneNumber,email});
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.lastName = lastName;
		logger.fine("ends constructor");

	}

	/**
	 * overridden method from Comparable.
	 * 
	 * @param contact
	 *            contact information of person
	 */
	public int compareTo(Contact contact) {
		logger.log(FINE,"starts and ends execution",new Object[]{this,contact});
		return (this.firstName + this.lastName).compareToIgnoreCase(contact.firstName + contact.lastName);
	}

	/**
	 * overridden method from Object class.
	 * 
	 * @param contact
	 *            contact information of person
	 * @see Object
	 */
	public boolean equals(Object contact) {
		logger.log(FINE,"starts and ends execution",new Object[]{this,contact});
		return (this.phoneNumber == ((Contact) contact).phoneNumber);
	}

	/**
	 * setter for firstName
	 * 
	 * @param firstName
	 *            firstName of a person
	 */
	public void setFirstName(String firstName) {
		logger.log(FINE,"setter",firstName);
		this.firstName = firstName;

	}

	/**
	 * setter for lastName
	 * 
	 * @param firstName
	 *            firstName of a person
	 */
	public void setLastName(String lastName) {
		logger.log(FINE,"setter",lastName);
		this.lastName = lastName;

	}

	/**
	 * setter for phoneNumber
	 * 
	 * @param phoneNumber
	 *            phoneNumber of a person
	 */
	public void setPhoneNumber(String phoneNumber) {

		logger.log(FINE,"setter",phoneNumber);
		this.phoneNumber = phoneNumber;

	}

	/**
	 * setter for email
	 * 
	 * @param email
	 *            email of a person
	 */
	public void setEmail(String email) {

		logger.log(FINE,"setter",email);
		this.email = email;
	}

	/**
	 * getter for firstName
	 * 
	 * @return firstName firstName of a person
	 */
	public String getFirstName() {

		logger.log(FINE,"getter",this.firstName);
		return this.firstName;
	}

	/**
	 * getter for lastName
	 * 
	 * @return firstName firstName of a person
	 */
	public String getLastName() {

		logger.log(FINE,"getter",this.lastName);
		return this.lastName;

	}

	/**
	 * getter for phoneNumber
	 * 
	 * @return phoneNumber phoneNumber of a person
	 */
	public String getPhoneNumber() {

		logger.log(FINE,"getter",this.phoneNumber);
		return this.phoneNumber;

	}

	/**
	 * getter for email
	 * 
	 * @return email email of a person
	 */
	public String getEmail() {

		logger.log(FINE,"getter",this.email);
		return this.email;
	}

	/**
	 * overriddent method of Object class.
	 */
	public String toString() {

		logger.log(FINE,"toString",this.firstName + " " + this.lastName);
		return (this.firstName + " " + this.lastName);

	}
}