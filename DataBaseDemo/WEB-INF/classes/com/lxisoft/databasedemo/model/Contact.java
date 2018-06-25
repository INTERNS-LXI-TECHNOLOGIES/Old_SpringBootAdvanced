package com.lxisoft.databasedemo.model;
public class Contact
{
	private int id;
	private String name;
	private String number;
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public String getNumber()
	{
		return number;
	}
}