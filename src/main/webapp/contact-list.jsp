<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Contacts</title>
<meta charset="utf-8">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> -->
<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
<link rel="stylesheet" type="text/css" href="css\mystyle.css">
<script type="text/javascript" src="js\my-script.js"></script>
</head>
<body>
   <%@  page
      import="java.util.*,java.io.*,com.lxisoft.contacts.model.Contact"%>
   <%
      
      String language = (String) session.getAttribute("language");
      String resourcePath = ((language == null) || language.equals("ENG"))
            ? "../webapps/"+request.getContextPath()+"/resource/english.properties"
            : "../webapps/"+request.getContextPath()+"/resource/malayalam.properties";
      language = ((language == null) || language.equals("ENG")) ? "മലയാളം" : "ENG";
      InputStreamReader reader = new InputStreamReader(new FileInputStream(resourcePath), "UTF-8");
      Properties props = new Properties();
      props.load(reader);
   %>

   <div class="jumbotron top">
      <img class="img-fluid contacts_icon" src="Images\contacts_2.png"
         alt="Contacts_icon">
      <h2><%=props.getProperty("contacts")%></h2>
      <div class="row">
         <div class="col-sm-11"></div>

         <div class="col-sm-1">
            <a href="applying-changes.jsp"><%=language%></a>
         </div>

      </div>
   </div>
   <div class="container">
      <div class="row">
         <div class="col-sm-8 search_contact_box">
            <form action="search" method="GET">
               <input type="search" placeholder=<%=props.getProperty("search")%>
                  name="search_key">
            </form>
         </div>
         <div class="col-sm-3 text-center">
            <span title=<%=props.getProperty("add_contact")%>><a
               href="add-contact.jsp" title="Add to contact"><img
                  src="Images\add_contact_1.png" alt="Create new contact" title="">
            </a></span>
         </div>
      </div>

      <div class="contact_container">
         <%
            Set<Contact> contacts = new TreeSet<Contact>();
            contacts = (TreeSet<Contact>) request.getAttribute("contacts");

            if (contacts.size() != 0) {
               for (Contact contact : contacts) {
         %>
         <div class="row individual_contact_row">
            <div class="col-sm-8 individual_contact">
               <img class="individual_contact_icon" src="Images\contact_1.png"
                  alt="contact_picture">
               <p>
                  <a href="get?link=<%out.println(contact.getPhoneNumber());%>">
                     <%
                        out.println(contact.getFirstName() + " " + contact.getLastName());
                     %>
                  </a>
               </p>
            </div>
            <div class="col-sm-4 text-center">
               <a
                  href="get?link=<%out.println(contact.getPhoneNumber());%>&type=edit"><span
                  title=<%=props.getProperty("edit")%>><img class="align"
                     src="Images\edit_1.png" title=""></span></a> <span
                  title=<%=props.getProperty("delete")%>><img
                  src="Images\delete_3.png" class="align image-link"
                  onclick="setPhoneNumber(<%=contact.getPhoneNumber()%>)" title=""></span>
            </div>
         </div>

         <div id="id01" class="outer-dialog-box text-center">
            <div class="confirmation-message text-center animate">
               <div class="dialog"><%=props.getProperty("delete_message")%></div>
               <br> <a class="dialog-yes" id="yes"
                  href="delete?link=<%=contact.getPhoneNumber()%>"><%=props.getProperty("yes")%></a>
               <button type="button" class="dialog-no"
                  onclick="document.getElementById('id01').style.display='none'"><%=props.getProperty("no")%></button>

            </div>
         </div>

         <%
            }
            } else {
         %>

         <p class="text-info error-message"><%=props.getProperty("not_found")%></p>
         <%
            }
         %>
      </div>
   </div>

</body>
</html>