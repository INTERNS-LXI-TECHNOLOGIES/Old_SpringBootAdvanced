package com.lxisoft.contactApp.utility;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class LogFileUtility
{
	private static final Logger logg=Logger.getLogger(PropertiesFileUtility.class.getName());

    private FileHandler fh;

    String fileName="../webapps/contactApp_v2/logs/MyLoggsFile%u.log";

    public Logger getLoggerObject(String className)
    {

    	logg.info("********************LogFileUtility**********************getLoggerObject---------> start");

    	Logger log=Logger.getLogger(className);

       try {  

        // This block configure the logger with handler and formatter  
        fh = new FileHandler(fileName);  
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  

        } catch (SecurityException e) {  
          e.printStackTrace();  
        } catch (IOException e) {  
          e.printStackTrace(); 

        }  


        logg.info("********************LogFileUtility**********************getLoggerObject---------> end");

        return log;

    }

}
