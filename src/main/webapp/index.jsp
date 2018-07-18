<!DOCTYPE html>
<html>
<head>
	<title>Contacts</title>
</head>
<body>
<%@ page import="com.lxisoft.model.*,java.util.*" %>
<%
 String name=null;
 String phNo = null;
Contact contact = new Contact();
//Set<Contact> contactSet = new TreeSet<Contact>();
 contact= (Contact)request.getAttribute("contact");
 //out.println("..........................."+contactList.size());
/*for(int i=0;i<contactSet.size();i++)
 {
 	contact = contactSet.get(i);
 	out.println("Name :"+contact.getName());
 	out.println("\n");
 	out.println("Phone :"+contact.getPhNo());
 	out.println("Address :"+contact.getAddress());
 }*/
 //out.println("in index :"+contactSet);

 out.println("new entry :"+contact);
/*for(Contact cc : contactSet)
{
	out.println("                  ");
	out.println("Name :"+cc.getName());
 	out.println("Phone :"+cc.getPhNo());
 	out.println("Address :"+cc.getAddress());
 	out.println("...........................");
}*/
 
 	%>
 
</body>
</html>