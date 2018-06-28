<html>
<%@ page import="java.util.*" %>
<%@ page import="com.lxisoft.databasedemo.model.Contact"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<head>
<style>
body {
    background-color: lightblue;
}
h {
    color: white;
    text-align: center;
}
</style>
<title>
UPDATE
</title>
</head>
<body>

<% List<Contact> contacts = new ArrayList<Contact>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarathdb", "root", "root");
        stmt = conn.createStatement();
        String sql = "SELECT * FROM sarathtable";
		rs = stmt.executeQuery(sql);

        while (rs.next()) {
           Contact contact = new Contact();
		   contact.setId(rs.getInt("id"));
		   contact.setName(rs.getString("name"));
		   contact.setNumber(rs.getString("number"));
		   contacts.add(contact);
        }
    } catch (Exception e) {
        System.out.println(e);
    }finally{
        //Code to release your resources
    }
	for(Contact c: contacts)
	{
	%><h3><h><%out.println(c.getId()+" "+c.getName()+" "+c.getNumber());%></h></h3><%
	} %>
	<form action="update" method="post">
	
WHICH CONTACT (enter id):<input type="text" name="id" ></input>
ENTER NEW NUMBER<input type="text" name="number" ></input>
<input type="submit" value="UPDATE"></input>
</form>

</body>
</html>