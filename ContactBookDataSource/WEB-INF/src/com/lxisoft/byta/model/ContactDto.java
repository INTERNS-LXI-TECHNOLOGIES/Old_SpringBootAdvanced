package com.lxisoft.byta.model;
import com.lxisoft.byta.control.*;
//import com.lxisoft.byta.repository.*;

public class ContactDto
{    
     private String name;
	private String phoneNo;
	private String place;
	
   
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo=phoneNo;
	}
	public String getNo()
	{
		return phoneNo;
	}
	public void setPlace(String place)
	{
		this.place=place;
	}
	public String getPlace()
	{
		return place;
	}
}