package com.lxisoft.model;

/**
*This contact program implements an application that simply handles contact details of users
*it implements  comparable interface for using set to avoid duplication of entries
@author Prasad
@version 1.0
@since 12-06-2018
*/
public class Contact implements Comparable<Contact>
{
	/**
	*instance variable name used to store name of users
	*instance variable phNo used to store phone numbers of users
	*instance variable address used to store address of users
	*/
	private String name;
	private String phNo;
	private String address;
public Contact()
{
	
}
	public Contact(String name,String phNo,String address)
	{
      this.name = name;
      this.phNo = phNo;
      this.address = address;
	}
/**
*setName method is used to set names into contacts
@param name this is a parameter used to store name value
*/
	public void setName(String name)
	{
       this.name = name;
	}

/**
*getName method is used to get the names from contacts
*@return string this returns a string value
*/
	public String getName()
	{
		return name;
	}
/**
*setPhNo method is used to set phone numbers into contacts
*@param phNo this is a parameter used to store phonenumber value 
*/
	public void setPhNo(String phNo)
	{
		this.phNo = phNo;
	}
/**
*getPhNo method is used to get the phone numbers from contacts
*@return this method returns a string value
*/
	public String getPhNo()
	{
		return phNo;
	}
/**
*setAddress method is used to set address field into contacts
*@param address is used to store address value
*/
	public void setAddress(String address)
	{
		this.address = address;
	}
/**
*getAddress method is used to get addresses from contacts
*@return String this method return a string value
*/	
	public String getAddress()
	{
		return address;
	}
/**
*toString is an object class method
*toString method is used for the string representation of an object
*@return this method returns string values
*/	
	public String toString()
	{
		return name+" "+phNo+" "+address;
	}
/**comapareTo is the sole member to Comparable interface
*comapreTo method is used to compare the current object with the specified object
*it provides single sorting sequence only
@param object this is a parameter used to compare with the current object
@return int,this returns a integer value after comparing the current and specified object
*/
	public int compareTo(Contact contact)
	{
       return this.getName().compareTo(contact.getName());
	}

}