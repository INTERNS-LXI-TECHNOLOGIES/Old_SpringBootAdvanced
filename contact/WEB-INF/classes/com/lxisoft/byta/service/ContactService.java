package com.lxisoft.byta.service;
import com.lxisoft.byta.repository.*;
import com.lxisoft.byta.model.*;

public class ContactService{
	
	public void save(ContactDto contactDto){
		
		Contact contact=new Contact(contactDto.getName(),contactDto.getPhoneNumber(),contactDto.getAddress(),contactDto.getEmail());
		
		new ContactRepository().save(contact);
		
		
	}
	
	public ContactDto findContactByName(String name){
		
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