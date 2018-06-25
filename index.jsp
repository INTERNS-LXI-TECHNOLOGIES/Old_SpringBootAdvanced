<!DOCTYPE html>
<html>
<head>
	<title>Contacts</title>
</head>
<body>
<%@ page import="com.lxisoft.model.*,java.util.*" %>
<%
 Contact contact ;
 String name=null;
TreeSet<Contact> contactSet = new TreeSet<Contact>();
 contactSet = (TreeSet<Contact>)request.getAttribute("ContactSet");
 //out.println("..........................."+contactList.size());
/* for(int i=0;i<contactSet.size();i++)
 {
 	contact = contactSet.get(i);
 	out.println("Name :"+contact.getName());
 	out.println("\n");
 	out.println("Phone :"+contact.getPhNo());
 	out.println("Address :"+contact.getAddress());
 }
*/
 for(Contact cc : contactSet)
 {
 	%>
 	<ul>
 		<li>
 	<a href="details.jsp"><%name = cc.getName();out.println(name+" ");%></a>

 	   </li>
 	</ul>
 
 <%	//out.println("Address :"+cc.getAddress());
 }
%>
<%request.setAttribute("UserName",name);
 		getServletConfig().getServletContext().getRequestDispatcher("/details.jsp").forward(request,response);%>

</body>
</html>