<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title>contact_create</title>
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
<%@ page import="java.util.*,com.lxisoft.contactApp.model.*,com.lxisoft.contactApp.controller.*,com.lxisoft.contactApp.utility.*"%>


 <%
 Contact contact = (Contact) session.getAttribute("contact");
 %>

    <%
     Properties p=null;
     try
     {

     if(((String)session.getAttribute("language")==null || ((String)session.getAttribute("language")).equals("ENGLISH")))

            p=(new PropertiesFileUtility()).getPropertyObject("../webapps/contactApp_v2/resource files/english_resource.properties");    
     else  
            p=(new PropertiesFileUtility()).getPropertyObject("../webapps/contactApp_v2/resource files/malayalam_resource.properties");

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

	
	<div class="login">
	<form id="form1" action="contactsForm" method="POST">

		
        <%=p.getProperty("firstname")%> :
		<input type="text" name="first_name" required="" onfocus="this.value=''" value="<%=contact.getFirstName()%>"><br><br>
		<%=p.getProperty("lastname")%> :
		<input type="text" name="last_name" required="" onfocus="this.value=''" value="<%=contact.getLastName()%>"><br><br>
		<%=p.getProperty("email")%> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="email" name="Email_Id" onfocus="this.value=''" value="<%=contact.getEmail()%>" checked="checked" required=""><br><br>
		<%=p.getProperty("phonenumber")%>:&nbsp;&nbsp;
		<input id="login-phn" type="tel" name="Phone_No" onfocus="this.value=''" value="<%=contact.getPhNo()%>" pattern="[6789][0-9]{9}" required="" placeholder="+91"><br><br>
		<%=p.getProperty("place")%> :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="Place" onfocus="this.value=''" value="<%=contact.getPlace()%>" required=""><br><br>

		<br>
		<input id="login_submit" type="submit" value=<%=p.getProperty("save")%>>
		<a id="cancel" href="contacts"><%=p.getProperty("cancel")%></a>
		<br><br>
	</form>
	</div>
	
</body>
</html>