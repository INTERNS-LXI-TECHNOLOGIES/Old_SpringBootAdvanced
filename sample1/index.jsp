<%@ page import="java.util.*,java.io.*,javax.servlet.*"%>

<%@ page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 


<%
  
  try{
	  
	  
	  
InputStream utf8in = getClass().getClassLoader().getResourceAsStream("bundle.properties");
Reader reader = new InputStreamReader(utf8in, "UTF-8");
Properties props = new Properties();
props.load(reader);
	reader.close();

String names=props.getProperty("name");
String phonenos=props.getProperty("phoneno");
String places=props.getProperty("place");

%>
<form action="ContactServlet" method="post">
<%
out.println(names);
%>
  
<input type="text" name="name"<br><br>
<%
out.print(phonenos);
%>
<input type="text" name="phoneno" pattern="[89][0-9]{9}"><br>
<%
out.println(places);
%>
<input type="text" name="place"><br>
<input type="submit" value="save">  


<%
} catch (IOException ex) {
		ex.printStackTrace();
	  }
		

			%>
			
			
			</form>
			<form action="ContactServlet" method="get">  
			
			<%
			InputStream utf8in = getClass().getClassLoader().getResourceAsStream("bundle.properties");
Reader reader = new InputStreamReader(utf8in, "UTF-8");
Properties props = new Properties();
props.load(reader);
	reader.close();
			String searchByName=props.getProperty("searchName");
			out.println(searchByName);
			%>
<input type="text" name="searchName"><br>
<input type="submit" value="save"> 
</form>
			
			
		
			
<form action="ContactServlet2" method="get"> 
updatebyname:<input type="text" name="NAMES"<br><br>

<input type="submit" value="save"> 
</form>


<form action="ContactServlet2" method="post">

<%
 
String oldName=(String)session.getAttribute("names");
out.println("JSP OLDNAME.............................."+oldName);

if(oldName!=null)
{
	session.setAttribute("name",oldName);
}
	%>
change Name:<input type="text" name="CHANGENAME"><br>

<input type="submit" value="save"> 
</form>

<!-- RequestDispatcher rd = request.getRequestDispatcher("/index2.jsp");
   rd.forward(request, response);-->


<!--</form>--> 
<!--<input type="text" name="phonenos" pattern="[89][0-9]{9}"><br>
<input type="text" name="places"><br>
 -->


<!--<form action="ContactServlet" method="get">  
SearchByName:<input type="SEARCHBYNAME" name="SEARCHBYNAME"><br>
<input type="submit" value="save"> 
</form>-->

 
<!--<form action="ContactServlet" method="post"> 

			<input type="submit" value="save">  
</form> 
-->


		