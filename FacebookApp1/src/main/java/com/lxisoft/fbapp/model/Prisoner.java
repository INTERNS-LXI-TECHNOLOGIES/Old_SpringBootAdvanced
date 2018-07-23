package com.lxisoft.fbapp.model;

public class Prisoner{
	
	private SuperKey superkey;
	private Hall currentLocation;
	
	public void setSuperKey(SuperKey superkey){
		
		this.superkey=superkey;
		
	}
	
	public SuperKey getSuperKey(){
		
		return superkey;
	}
	
	public void setCurrentLocation(Hall currentLocation){
		
		this.currentLocation=currentLocation;
		
	}
	
	public Hall getCurrentLocation(){
		
		return currentLocation;
	}
	
	

}