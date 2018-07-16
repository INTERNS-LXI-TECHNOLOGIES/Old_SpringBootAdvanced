package com.byta.lxisoft.byta;
import com.lxisoft.byta.model.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import junit.framework.TestCase;

public class ContactTest extends TestCase{
	
	private Contact contact;
	
	public void setUp() throws Exception{
		contact=new Contact(null,0L,null,null);
	}
	
	public void testName(){
		
		String name1="anjali";
		contact.setName(name1);
		String name2=contact.getName();
		assertEquals(name2,"anjali");
		
	}

}