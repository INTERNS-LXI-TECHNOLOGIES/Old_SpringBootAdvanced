package com.controller;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import com.model.Contact;
/*import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
public class ContactServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		request.setAttribute("name",name);
		request.setAttribute("number",number);
		RequestDispatcher view=request.getRequestDispatcher("save.jsp");
		view.forward(request,response);
		File file = new File("contacts.csv");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		if(file.length() == 0)
		{
		bw.write("NAME");
		bw.write(",");
		bw.write("NUMBER");
		bw.write("\n");
		bw.write(name);
		bw.write(",");
		bw.write(number);
		bw.flush();
		bw.close();
		}
		else
		{
		bw.write("\n");
		bw.append(name);
		bw.append(",");
		bw.append(number);
		bw.flush();
		bw.close();	
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
	{
		response.setContentType("text/html");
		
		List<Contact> list = new ArrayList<Contact>();
		File file = new File("contacts.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line=null;
		String [] details=null;
		
		while((line = br.readLine()) != null)
		{
			Contact c = new Contact();	
			details = line.split(",");
			c.setName(details[0]);
			c.setNumber(details[1]);
			list.add(c);
			
		} 
		System.out.println(list.size());
		br.close();
		for(int i=0; i<list.size();i++)
		{
			System.out.println(list.get(i).getName()+" "+list.get(i).getNumber());
		}
		
		request.setAttribute("data",list);	
		RequestDispatcher view=request.getRequestDispatcher("view.jsp");
		view.forward(request,response);		
		
	}
}