<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title>home</title>
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
    <%@ page import="java.util.*,com.lxisoft.contactApp.model.*,com.lxisoft.contactApp.controller.*,com.lxisoft.contactApp.utility.*"%>

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

    <%
    Set<Contact> contactSet = (TreeSet<Contact>) request.getAttribute("contactSet");
    %>
	<div id="top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="contact_clr"><%=p.getProperty("contacts")%></h3>
	</header>
	</div>

    <div id="top">
    <form action="contactEditForm" method="GET">
    <input id="inputsearch" type="text" name="first_name" placeholder=<%=p.getProperty("searchContact")%>>

    </form>
  
    </div>

    <div id="create"> 
    <a href="Contact_Create.jsp">
    <img id="contact_createIcon" src="Images\add_contact_2.png" alt="create_contact" title=<%=p.getProperty("createNewContact")%>>
    </a>
    </div>

    <div id="language">
      <P>
        <a href="Language_selector.jsp?type=ENGLISH">ENGLISH</a> /
        <a href="Language_selector.jsp?type=MALAYALAM">മലയാളം</a>
      </P>  

    </div>

    <div id="contact_list">
       <%for(Contact contact:contactSet) {%>

 		<div id="individual_contacts"><img id="contact_icon" src="Images\contact_2.png" alt="contact_icon">
 		<a href="contactsForm?phone_No=<%=contact.getPhNo()%>"><%=contact%></a>
         
         </div>
 		
 		<!-- <a href="contactDeletForm?first_name=<%=contact.getFirstName()%>">delete</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 		<a href="ContactsForm?type=edit&first_name=<%=contact.getFirstName()%>">edit</a></p></div>
 -->    <div id="edit_delete">
				<a href="contactsForm?type=edit&first_name=<%=contact.getFirstName()%>"><span title=<%=p.getProperty("editContact")%>><img class="align" src="Images\edit13.png"></span></a>
				<a href="contactDeletForm?first_name=<%=contact.getFirstName()%>"><span title=<%=p.getProperty("removeContact")%>><img class="align" src="Images\remove1.png"></span></a>
        </div>



        
 	
 	<%}%>
 </ul>
</div></body>
</html>
