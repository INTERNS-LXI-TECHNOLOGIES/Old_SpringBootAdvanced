<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
<link rel="stylesheet" type="text/css" href="css\mystyle.css">
<meta charset="UTF-8">
</head>
<body>

	<div class="jumbotron top">
		<img class="img-fluid contacts_icon" src="Images\contacts_2.png"
			alt="Contacts_icon">
		<h2>Contacts</h2>
	</div>
	<div class="container">

		<!--<img src="add-512.png" alt="Mountain View">-->

		<div class="contact_container">
			<%@ page import="java.util.*,com.lxisoft.model.Contact"%>

			<p class="text-info error-message">Applying changes...</p>
			<%
				String language = (String) session.getAttribute("language");
				language = ((language == null) || language.equals("ENG")) ? "MAL" : "ENG";
				session.setAttribute("language", language);
				response.setHeader("Refresh", "1;url=getAll");
			%>

		</div>
	</div>
</body>
</html>
