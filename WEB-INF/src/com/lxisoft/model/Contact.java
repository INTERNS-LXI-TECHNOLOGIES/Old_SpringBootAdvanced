package com.lxisoft.model;

//import required java libraries
import java.util.*;

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
	public Contact(String firstName, String lastName, String phoneNumber, String email) {

		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.lastName = lastName;
	}

	/**
	 * overridden method from Comparable.
	 * 
	 * @param contact
	 *            contact information of person
	 */
	public int compareTo(Contact contact) {
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

		return (this.phoneNumber == ((Contact) contact).phoneNumber);
	}

	/**
	 * setter for firstName
	 * 
	 * @param firstName
	 *            firstName of a person
	 */
	public void setFirstName(String firstName) {

		this.firstName = firstName;

	}

	/**
	 * setter for lastName
	 * 
	 * @param firstName
	 *            firstName of a person
	 */
	public void setLastName(String lastName) {

		this.lastName = lastName;

	}

	/**
	 * setter for phoneNumber
	 * 
	 * @param phoneNumber
	 *            phoneNumber of a person
	 */
	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;

	}

	/**
	 * setter for email
	 * 
	 * @param email
	 *            email of a person
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getter for firstName
	 * 
	 * @return firstName firstName of a person
	 */
	public String getFirstName() {

		return this.firstName;
	}

	/**
	 * getter for lastName
	 * 
	 * @return firstName firstName of a person
	 */
	public String getLastName() {

		return this.lastName;

	}

	/**
	 * getter for phoneNumber
	 * 
	 * @return phoneNumber phoneNumber of a person
	 */
	public String getPhoneNumber() {

		return this.phoneNumber;

	}

	/**
	 * getter for email
	 * 
	 * @return email email of a person
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * overriddent method of Object class.
	 */
	public String toString() {

		return (this.firstName +" "+ this.lastName);

	}
}