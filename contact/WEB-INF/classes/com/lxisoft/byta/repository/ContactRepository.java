package com.lxisoft.byta.repository;
import java.sql.*;
import com.lxisoft.byta.model.*;

public class ContactRepository{
	
	Contact contact;
	
	public void save(Contact contact){
		
		Connection con;
		PreparedStatement stmt;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactinfo?useUnicode=yes&characterEncoding=UTF-8","root","root");
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
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactinfo","root","root");
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
		
		return contact;

	}
	
	public void updateContact(Contact contact){
		 
		Connection con;
		PreparedStatement stmt;
		
		try{
			
			System.out.println(contact.getName()+"\n"+contact.getPhoneNumber());
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactinfo","root","root");
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
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactinfo","root","root");
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