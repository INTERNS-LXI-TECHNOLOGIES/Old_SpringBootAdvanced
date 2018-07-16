package com.lxisoft.byta.model;

public class Contact{

	private String name;
	private long phoneNumber;
	private String address;
	private String email;
	
	public Contact(String name,Long phoneNumber,String address,String email){
		
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.address=address;
		this.email=email;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPhoneNumber(long phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	
	public long getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getEmail(){
		return email;
	}
	
	
	
	
	
}

