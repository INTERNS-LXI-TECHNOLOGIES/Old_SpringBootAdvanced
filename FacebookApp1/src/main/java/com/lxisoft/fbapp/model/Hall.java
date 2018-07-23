package com.lxisoft.model;
/**
* This class is for control Hall
*
* @author Dheeraj das
*
* @version 1.0
*/
public class Hall
{
	/**
	*This is a reference to door
	*/
	private Door door ;
	
	/**
	*This is a unique id of hall
	*/
	private long hallId;
	
	/**
	* This is a setter which sets the hallId
	*
	* @param hallId - the hallId to set
	*/
	public void setHallId(long hallId)
	{
		this.hallId = HallId;
	}
	
	/**
	* This is a getter which returns the hallId
	*
	* @return hallId - the hallId to get
	*/
	public long getHallId()
	{
		return HallId;
	}
}