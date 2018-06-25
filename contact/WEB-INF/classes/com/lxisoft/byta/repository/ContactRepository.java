package com.lxisoft.byta.repository;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.annotation.Resource;
import com.lxisoft.byta.model.*;

public class ContactRepository{
	
	Contact contact;
	
	
	@Resource(name="jdbc/contactinfo")
	DataSource ds;
	
	public void save(Contact contact){
		
		Connection con;
		PreparedStatement stmt;
		
		try{
			
			//Class.forName("com.mysql.jdbc.Driver");
			con=ds.getConnection();
			stmt=con.prepareStatement("insert into contactdetails values(?,?,?,?)");
			stmt.setString(1,contact.getName());
			stmt.setLong(2,contact.getPhoneNumber());
			stmt.setString(3,contact.getAddress());
			stmt.setString(4,contact.getEmail());
			stmt.executeUpdate();
			con.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}	
		
	}
	
	public Contact findContactByName(String name){
		
		Connection con;
		PreparedStatement stmt;
		
		
		try{
			
			//Class.forName("com.mysql.jdbc.Driver");
			con=ds.getConnection();
			stmt=con.prepareStatement("select * from contactdetails where name=?");
			stmt.setString(1,name);
			
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				
			contact=new Contact(rs.getString("name"),rs.getLong("phoneNumber"),rs.getString("address"),rs.getString("email"));
			
				
			}
			con.close();
			
		}
		catch(Exception ex){
			ex.printStackTrace();

			}
			
			System.out.println("***********"+contact.getName());
		
		return contact;

	}
	
	public void updateContact(Contact contact){
		 
		Connection con;
		PreparedStatement stmt;
		
		try{
			
			System.out.println(contact.getName()+"\n"+contact.getPhoneNumber());
			
			//Class.forName("com.mysql.jdbc.Driver");
			con=ds.getConnection();
			stmt=con.prepareStatement("update contactdetails set phoneNumber=? where name=?");
			stmt.setLong(1,contact.getPhoneNumber());
			stmt.setString(2,contact.getName());
			stmt.executeUpdate();
			con.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	public void deleteContact(Contact contact){
		 
		Connection con;
		PreparedStatement stmt;
		
		try{
			
			//Class.forName("com.mysql.jdbc.Driver");
			con=ds.getConnection();
			stmt=con.prepareStatement("delete from contactdetails where name=?");
			stmt.setString(1,contact.getName());
			stmt.executeUpdate();
			con.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	
	
}