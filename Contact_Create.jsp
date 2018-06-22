<!DOCTYPE html>
<head>
	<title>contact_create</title>
	<link rel="stylesheet" type="text/css" href="style_contacts.css">
</head>
<body>
	<div id="commom_top">
	<header>
	<img id="contact_pic" src="Images\contacts_3.png" alt="contact_icon">
	<h3 id="common_contactDetails">Contacts</h3>
	</header>
	</div>

	
	<div class="login">
	<form id="form1" action="contactsForm" method="POST">

		
        firstName :
		<input type="text" name="first_name" required=""><br><br>
		lastName :
		<input type="text" name="last_name" required=""><br><br>
		Email :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="email" name="Email_Id" checked="checked" required=""><br><br>
		Phone number:&nbsp;&nbsp;
		<input id="login-phn" type="tel" name="Phone_No" pattern="[6789][0-9]{9}" required="" placeholder="+91"><br><br>
		Place :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="Place" required=""><br><br>

		<br>
		<input id="login_submit" type="submit" value="Add Contact">
		<a id="cancel" href="contacts">Cancel</a>
		<br><br>
	</form>
	</div>
	
</body>
</html>