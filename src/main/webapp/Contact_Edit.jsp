<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title>contact_edit</title>
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
<%@ page import="java.util.*,com.lxisoft.contactApp.model.*,com.lxisoft.contactApp.controller.*,com.lxisoft.contactApp.utility.*"%>
 <%
 Contact contact = (Contact) request.getAttribute("contact");
 %>

 <%
     Properties p=null;
     try
     {

     if(((String)session.getAttribute("language")==null || ((String)session.getAttribute("language")).equals("ENGLISH")))

            p=(new PropertiesFileUtility()).getPropertyObject("../webapps/contactApp_v3/resource files/english_resource.properties");    
     else  
            p=(new PropertiesFileUtility()).getPropertyObject("../webapps/contactApp_v3/resource files/malayalam_resource.properties");

     }catch(Exception fe)
      {
       fe.printStackTrace();
      }

    %>

	<div id="commom_top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="common_contactDetails"><%=p.getProperty("contacts")%></h3>
	</header>
	</div>
    <form action = "contactEditForm" method = "POST">
    <input type="hidden" name="key" value="<%=contact.getFirstName()%>"><br><br> 
	    <%=p.getProperty("firstname")%> :&nbsp;
		<input type="text" name="first_name" required="" value="<%=contact.getFirstName()%>"><br><br>
		<%=p.getProperty("lastname")%> :&nbsp;
		<input type="text" name="last_name" required="" value="<%=contact.getLastName()%>"><br><br>
        <%=p.getProperty("email")%> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="email" name="Email_Id" checked="checked" required="" value="<%=contact.getEmail()%>"><br><br>
		<%=p.getProperty("phonenumber")%>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="login-phn" type="tel" name="Phone_No" pattern="[6789][0-9]{9}" required="" placeholder="+91" value="<%=contact.getPhNo()%>"><br><br>
		<%=p.getProperty("place")%> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="Place" required="" value="<%=contact.getPlace()%>"><br><br>


		<br>
		<input id="login_submit" type="submit"  value=<%=p.getProperty("save")%>>
		<a id="cancel" href="contacts"><%=p.getProperty("cancel")%></a>
		<br><br>

	</form>
	</div>
	
</body>
</html>

