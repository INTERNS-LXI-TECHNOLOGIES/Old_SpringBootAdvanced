package com.lxisoft.contactApp.utility;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * class managing propertyfiles.
 * 
 * @author Sarangi Balu
 * 
 * @version $version-stub$
 *
 */

public class PropertiesFileUtility
{
   
   /**
   * Reference to Logger class to get log messages
   */ 
    private static final Logger log=Logger.getLogger(PropertiesFileUtility.class.getName());

	/*public Properties newPropertyObject(String fileName) throws FileNotFoundException,IOException*/

  /**
   * Get properties object by fileName.
   *
   * @param fileName the name of the propertyfile.
   *
   * @return the properties object.
   */

	public Properties getPropertyObject(String fileName) throws Exception
	{
		log.info("********************PropertiesFileUtility**********************newPropertyObject---------> start");

		InputStreamReader reader=new InputStreamReader(new FileInputStream(fileName),"UTF-8");
		Properties p=new Properties();
		p.load(reader);

		//System.out.println("Property"+p.getProperty("movieName"));

		log.info("********************PropertiesFileUtility**********************newPropertyObject---------> end");
		return p;
	}
}