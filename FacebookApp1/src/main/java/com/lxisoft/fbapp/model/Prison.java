package com.lxisoft.fbapp.model;
import java.util.*;
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
	private List<Hall> halls;
	
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
	* This is a setter which sets the list of halls
	*
	*@param halls - the list of halls to set
	*/
	public void sethalls(List<Hall> halls)
	{
		this.halls = halls;
	}
	
	/**
	*This is a getter which returns the list of halls
	*
	*@return halls - the list of halls to get
	*/
	public List<Hall> getHalls()
	{
		return halls;
	}
}