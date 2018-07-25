package com.lxisoft.fbapp.model;
import java.util.*;

/**
*@author Anjali
*model class for Prisoner
*
*/
public class Prisoner{
	
	/**
	*super keys the prisoner has
	*/
	private List<SuperKey> superkey;
	private Hall currentLocation;
	
	public void setSuperKey(List<SuperKey> superkey){
		
		this.superkey=superkey;
		
	}
	
	public List<SuperKey> getSuperKey(){
		
		return superkey;
	}
	
	public void setCurrentLocation(Hall currentLocation){
		
		this.currentLocation=currentLocation;
		
	}
	
	public Hall getCurrentLocation(){
		
		return currentLocation;
	}
	
	

}