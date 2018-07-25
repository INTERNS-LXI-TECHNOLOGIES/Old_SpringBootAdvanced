
<%@ page import="org.apache.commons.logging.Log" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>

<%@ page import="java.util.*,com.lxisoft.fbapp.model.*"%>


<%-- Get a reference to the logger for this class --%>

<% Log logger = LogFactory.getLog( this.getClass(  ) ); %>

<% logger.debug( "This is a debug message from a jsp" ); %>

<html>
<head>
  <title>Game page</title>
</head>

<body>
  <% logger.info( "This is another log message in the jsp" ); %>
  
  <%
   Prisoner prisoner= (Prisoner) session.getAttribute("prisoner");

    try
    {
    if(prisoner==null)
        throw new Exception();
    }
    catch (Exception e)
    {
    logger.log(WARNING, "Exception caught={0}", e);
    e.printStackTrace();         
    }
 %>
</body>
</html>
