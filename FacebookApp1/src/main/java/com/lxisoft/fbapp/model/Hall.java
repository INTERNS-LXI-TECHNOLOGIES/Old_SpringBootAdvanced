package com.lxisoft.fbapp.model;
/**
* This class is for control Hall

* @author Dheeraj das
* @version 1.0

*/
public class Hall
{
	/**
	*This is a door object
	*/
	Door door ;
	private long id;
	
	/**
	* This is a setter which sets the id
	* @param id - the id to set
	*/
	public void setId(long id)
	{
		this.id = id;
	}
	
	/**
	* This is a getter which returns the id
	* @return id - the id to get
	*/
	public long getId()
	{
		return id;
	}
}