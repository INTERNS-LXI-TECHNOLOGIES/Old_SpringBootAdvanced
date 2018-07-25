package com.lxisoft.fbapp.model;
import java.util.*;

public class Prisoner{
	
	private ArrayList<SuperKey> superkey;
	private Hall currentLocation;
	
	public void setSuperKey(ArrayList<SuperKey> superkey){
		
		this.superkey=superkey;
		
	}
	
	public ArrayList<SuperKey> getSuperKey(){
		
		return superkey;
	}
	
	public void setCurrentLocation(Hall currentLocation){
		
		this.currentLocation=currentLocation;
		
	}
	
	public Hall getCurrentLocation(){
		
		return currentLocation;
	}
	
	

}