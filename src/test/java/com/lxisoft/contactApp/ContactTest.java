package com.lxisoft.contactApp;

import com.lxisoft.contactApp.model.*;

import junit.framework.TestCase;

public class ContactTest extends TestCase 
{
    Contact contact=new Contact();

    public void testConactName() 
    {

    String name1="sanil";	

    contact.setFirstName(name1);

    String name= contact.getFirstName();

    assertEquals(name,name1);

    }
}





