<!-- <!DOCTYPE html> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en,ml">
   <head>
      <title>Contacts</title>
      <meta charset="utf-8">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> -->
      <link rel="stylesheet" type="text/css" href="css\bootstrap.css">
      <link rel="stylesheet" type="text/css" href="css\mystyle.css">
   </head>
   <body>
      <div class="jumbotron top">
      <img class="img-fluid contacts_icon" src="Images\contacts_2.png" alt="Contacts_icon">  
      <h2>Contacts</h2>
      </div>
      <div class="container">
         <div class="row">
            <div class="col-sm-8 search_contact_box">
            <form action="search" method="GET">
               <input type="search" placeholder="Search...." name="search_key">
            </form>
      </div>
      <div class="col-sm-4 text-center">
      <span title="Add to contact"><a href="add-contact.jsp" title="Add to contact"><img src="Images\add_contact_1.png" alt="Create new contact"  title="">
      </a></span>
      </div>
      </div> 

      <div class="contact_container">
      <%@  page import="java.util.*,java.io.*,com.lxisoft.contacts.model.Contact"%>
      <%  Set<Contact> contacts=new TreeSet<Contact>();
      contacts=(TreeSet<Contact>)request.getAttribute("contacts");

      if(contacts.size()!=0){
         for(Contact contact:contacts)
         {%>
         <div class="row individual_contact_row">
         <div class="col-sm-8 individual_contact">
         <img class="individual_contact_icon" src="Images\contact_1.png" alt="contact_picture"><p><a href="get?link=<%out.println(contact.getPhoneNumber());%>"><% out.println(contact.getFirstName()+" "+contact.getLastName()); %></a></p>
         </div>
         <div class="col-sm-4 text-center">
            <a href="get?link=<%out.println(contact.getPhoneNumber());%>&type=edit"><span title="Edit"><img class="align" src="Images\edit_1.png" title=""></span></a>
            <a href="get?link=<%out.println(contact.getPhoneNumber());%>&type=delete"><span title="Delete"><img class="align" src="Images\delete_3.png" title=""></span></a>
         </div>
         </div> 
         <%}
      }
      else{%>

         <p class="text-info error-message">Sorry...no contact found!</p>
      <%}
      %>
   </div>
   </div>
   <% //FileReader fr=new FileReader("../webapps/contacts-v4/resource/malayalam.properties");
      InputStreamReader isr=new InputStreamReader(new FileInputStream("../webapps/contacts-v4/resource/malayalam.properties"),"UTF-8");
      Properties p=new Properties();
      p.load(isr);
   String s=p.getProperty("first_name");
   %>
      <p><%=s%></p>
   </body>
</html>