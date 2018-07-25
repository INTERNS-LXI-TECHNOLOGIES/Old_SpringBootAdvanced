package com.lxisoft.fbapp.model;

/**
* This class is for control prison
*
* @author Dheeraj das
*
* @version 1.0
*/
public class Prison
{
	/**
	*This is a reference to prisoner 
	*/
	private Prisoner prisoner;
	
	/**
	*This is a reference to hall
	*/
	private Hall hall;
	
	/**
	* This is a setter which sets the prisoner
	*
	*@param prisoner - the prisoner to  set
	*/
	public void setPrisoner(Prisoner prisoner)
	{
		this.prisoner = prisoner;
	}
	
	/**
	*This is a getter which returns the prisoner
	*
	*@return prisoner - the prisoner to get
	*/
	public Prisoner getPrisoner()
	{
		return prisoner;
	}
	
	/**
	* This is a setter which sets the hall
	*
	*@param hall - the hall to  set
	*/
	public void sethall(Hall hall)
	{
		this.hall = hall;
	}
	
	/**
	*This is a getter which returns the hall
	*
	*@return hall - the hall to get
	*/
	public Hall getHall()
	{
		return hall;
	}
}