package com.lxisoft.contacts.test;

// Import required java libraries
import com.lxisoft.contacts.model.Contact;
import junit.framework.TestCase;

/**
 * This is a test class to test com.lxisoft.contacts.model.Contact
 *
 * @author Sanil kumar
 */

public class ContactTest extends TestCase
{

	private Contact testContact;
	/**
	 * constructor
	 * @param testName name for test
	 */

	public ContactTest(String testName) {
		super(testName);
	}

	/**
	* overridden method 
	* @throws Exception
	*/ 
	protected void setUp() throws Exception {
		super.setUp();
		testContact=new Contact();
	}

	/**
	* overridden method 
	* @throws Exception
	*/ 
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	* method to test getters and setters of Contact 
	* 
	*/ 
	public void testMethod()
	{
		String name="test";
		testContact.setFirstName(name);
		assertEquals(name, testContact.getFirstName());
	}

}

