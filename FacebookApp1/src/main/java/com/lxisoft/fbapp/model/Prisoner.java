package com.lxisoft.fbapp.model;

/**
*@author Anjali
*model class for Prisoner
*
*/
public class Prisoner{
	
<<<<<<< HEAD
	/**
	*super keys the prisoner has
	*/
	private List<SuperKey> superkey;
	private Hall currentLocation;
	
	public void setSuperKey(List<SuperKey> superkey){
=======
	private SuperKey superkey;
	private Hall currentLocation;
	
	public void setSuperKey(SuperKey superkey){
>>>>>>> 377cea729648c767e19b6568e13734716491a6d4
		
		this.superkey=superkey;
		
	}
	
<<<<<<< HEAD
	public List<SuperKey> getSuperKey(){
=======
	public SuperKey getSuperKey(){
>>>>>>> 377cea729648c767e19b6568e13734716491a6d4
		
		return superkey;
	}
	
	public void setCurrentLocation(Hall currentLocation){
		
		this.currentLocation=currentLocation;
		
	}
	
	public Hall getCurrentLocation(){
		
		return currentLocation;
	}
	
	

}