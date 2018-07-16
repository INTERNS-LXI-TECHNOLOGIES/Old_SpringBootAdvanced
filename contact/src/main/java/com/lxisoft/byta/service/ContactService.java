/**
*@author=Anjali
*service class handles saving data through repository
*
*/

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
			LogManager.getLogManager().readConfiguration(new FileInputStream("E:/mavensample/contact/src/main/resources/contact.properties"));
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	}
	
	/**
	*this method save the contact through repository
	*
	*/
	public void save(ContactDto contactDto){
		
			LOGGER.fine("into save in service");
		
		Contact contact=new Contact(contactDto.getName(),contactDto.getPhoneNumber(),contactDto.getAddress(),contactDto.getEmail());
		
		new ContactRepository().save(contact);
		
		
	}
	
	
	/**
	*this method search the contact from repository using search name
	*
	*/
	public ContactDto findContactByName(ContactDto con){
		
		LOGGER.warning("into findContactByName in service");
		
		Contact contact=new ContactRepository().findContactByName(con.getName());
		
		
		
		ContactDto contactDto=new ContactDto(contact.getName(),contact.getPhoneNumber(),contact.getAddress(),contact.getEmail());
		
		
		return contactDto;	
	}
	
	
	/**
	*this method update the contact through repository
	*
	*/
	public void updateContact(ContactDto contactDto){
		
		Contact contact=new ContactRepository().findContactByName(contactDto.getName());
		contact.setPhoneNumber(contactDto.getPhoneNumber());
		/* Contact contact=new Contact(contactDto.getName(),contactDto.getPhoneNumber(),contactDto.getAddress(),contactDto.getEmail()); */
		
		new ContactRepository().updateContact(contact);
		
	}
	
	
	/**
	*this method delete the contact from repository
	*
	*/
	public void deleteContact(ContactDto contactDto){
		
		Contact contact=new ContactRepository().findContactByName(contactDto.getName());
		
		new ContactRepository().deleteContact(contact);
		
	}
	
	

}