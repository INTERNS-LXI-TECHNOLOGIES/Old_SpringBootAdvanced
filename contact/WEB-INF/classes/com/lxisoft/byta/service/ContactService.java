package com.lxisoft.byta.service;
import com.lxisoft.byta.repository.*;
import com.lxisoft.byta.model.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;

public class ContactService{
	
	static Logger LOGGER=Logger.getLogger(ContactService.class.getName());
	
	static{
		
		try{
			LogManager.getLogManager().readConfiguration(new FileInputStream("E:/lxi softwares/apache-tomcat-7.0.72/webapps/contact/contact.properties"));
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	}
	
	
	
	public void save(ContactDto contactDto){
		
			LOGGER.fine("into save in service");
		
		Contact contact=new Contact(contactDto.getName(),contactDto.getPhoneNumber(),contactDto.getAddress(),contactDto.getEmail());
		
		new ContactRepository().save(contact);
		
		
	}
	
	public ContactDto findContactByName(String name){
		
		LOGGER.warning("into findContactByName in service");
		
		Contact contact=new ContactRepository().findContactByName(name);
		
		ContactDto contactDto=new ContactDto(contact.getName(),contact.getPhoneNumber(),contact.getAddress(),contact.getEmail());
		
		
		return contactDto;	
	}
	
	public void updateContact(String name,long phoneNumber){
		
		Contact contact=new ContactRepository().findContactByName(name);
		contact.setPhoneNumber(phoneNumber);
		
		new ContactRepository().updateContact(contact);
		
	}
	
	public void deleteContact(String name){
		
		Contact contact=new ContactRepository().findContactByName(name);
		
		new ContactRepository().deleteContact(contact);
		
	}
	
	

}