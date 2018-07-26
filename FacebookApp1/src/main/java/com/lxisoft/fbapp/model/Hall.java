package com.lxisoft.fbapp.model;
import java.util.*;
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
	*This is a list of doors
	*/
	private List<Door> doors ;
	
	/**
	*This is a unique id of hall
	*/
	private long hallId;

	/**
	* This is a setter which sets the list of doors
	*
	* @param doors - the list of doors to set
	*/
	public void setDoors(List<Door> doors)
	{
		this.doors = doors;
	}
	
	/**
	* This is a getter which returns the list of doors
	*
	* @return doors - the list of doors to get
	*/
	public List<Door> getDoors()
	{
		return doors;
	}	

	/**
	* This is a setter which sets the hallId
	*s
	* @param hallId - the hallId to set
	*/
	public void setHallId(long hallId)
	{
		this.hallId = hallId;
	}
	
	/**
	* This is a getter which returns the hallId
	*
	* @return hallId - the hallId to get
	*/
	public long getHallId()
	{
		return hallId;
	}
	
	/**
	*This is a equals method to override
	*
	*@return bool - the boolean value for equals
	*/
	public boolean equals(Object obj) 
	{
		return ((obj != null) && (obj instanceof Hall) && (this.getHallId() == ((Hall)obj).getHallId())); 
	}

}