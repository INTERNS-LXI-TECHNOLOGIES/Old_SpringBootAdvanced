package com.lxisoft.file;
import com.lxisoft.model.*;
import java.io.*;
import java.util.*;
import java.lang.*;

/**
* The FileHandler program implements an application that simply handles the read and write functions in a file.
@author Prasad
@version 1.0
@since 12-06-2018
*/
public class FileHandler 
{
	
	
	private static  File file = new File("E:/lxi softwares/apache-tomcat-7.0.72/webapps/ContactServlet/WEB-INF/classes/contacts.csv");

  /**
  *This method is used to read datas from a file
  *@return Set<Contact> This returns a set of contacts
  */
 public static Set<Contact> readFromFile()
 {
 	Set<Contact> contactSet  = new TreeSet<Contact>();
		try 
	     {
		  
		 FileReader fr = new FileReader(file);
		 BufferedReader br = new BufferedReader(fr);

		 String[] a;
		 String s;
		 br.readLine();

			   while((s=br.readLine())!=null)
			   {
				  a=s.split(",");
				  contactSet.add(new Contact(a[0],a[1],a[2]));
	
			   }
	
	    }
	    	catch(Exception e)
	   	 	{
              e.printStackTrace();
	    	}
	    	
	    	return contactSet;
 }  

 /**
 *This is a method used to write datas into a file
 *It first read datas from that file,then it writes 
 *new datas into it.
 *@param contact this is a parameter to write into file
 */
public static void writeToFile(Contact contact)
{
  System.out.println(contact);

  try {

      
        if(!file.exists())
        {
          file.createNewFile();
        }
      
      Set<Contact> contactSet = new TreeSet<Contact>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        Contact c;
        String readData;
        String[] data;
        while((readData = br.readLine())!=null)
        {   
          c = new Contact();
          data = readData.split(",");
          c.setName(data[0]);
          c.setPhNo(data[1]);
          c.setAddress(data[2]);
          
          
          contactSet.add(c);
          
        }
        
        br.close();
       contactSet.add(contact);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
              for (Contact cntct : contactSet) {
         // System.out.println(cntct);
               // System.out.println(cntct.getName());
          bw.write(cntct.getName());
          bw.write(",");
          bw.write(cntct.getPhNo());
          bw.write(",");
          bw.write(cntct.getAddress());
          bw.newLine();
          
        }
        bw.flush();
        bw.close();
      }
      catch (Exception e) {
      e.printStackTrace(); 
      }
    
}
}
 