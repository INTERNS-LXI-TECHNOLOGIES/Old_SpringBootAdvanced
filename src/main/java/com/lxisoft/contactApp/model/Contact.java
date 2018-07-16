package com.lxisoft.contactApp.model;

import java.util.*;

/**
 * A Contact.
 */

public class Contact implements Comparable<Contact>
{
	
	private String firstName,lastName,place,phNo,email;

	public Contact()
	{
		
	}

	public Contact(String firstName,String lastName,String email,String place,String phNo)
	{

		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.phNo=phNo;
		this.place=place;

	}

	public void setFirstName(String firstName)
	{

		this.firstName=firstName;

	}

	public void setLastName(String lastName)
	{

		this.lastName=lastName;

	}

	public void setPlace(String place)
	{

		this.place=place;

	}

	public void setPhNo(String phNo)
	{

		this.phNo=phNo;

	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getFirstName()
	{
      
      return this.firstName;
     }
     public String getLastName()
	{
      
      return this.lastName;
     }
     
    public String getPlace()
	{
      
      return this.place;

	}

	public String getPhNo()
	{
		
		return this.phNo;

	}
	public String getEmail()
	{
		return this.email;
	}

	public int compareTo(Contact contact)
	{
		return this.firstName.compareToIgnoreCase(contact.firstName);
	}
	public boolean equals(Object contact)
	{
		
		if(this.phNo==((Contact)contact).phNo)
			return true;
		else
			return false;
	}

	public String toString()
	{

		return (this.firstName+"\t"+this.lastName+"\n");
		
	}
}