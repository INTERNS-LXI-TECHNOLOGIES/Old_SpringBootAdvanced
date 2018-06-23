<!DOCTYPE html>
<html>
<head>
	<title>Create contact</title>
	<link rel="stylesheet" type="text/css" href="css\bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css\mystyle.css">
	<meta charset="UTF-8">
</head>
<body>
	<div class="jumbotron top">
	<img class="img-fluid contacts_icon" src="Images\contacts_2.png" alt="Contacts_icon">	
	<h2>Contacts</h2>
	</div>
	<div class="container text-center">
	<div class="row">
	<div class="col-sm-2">
	</div>
	<form id="form1" class="form-horizontal form_style col-sm-8" action="getAll" method="POST">
		<label class="col-sm-3">First Name</label>
		<input class="col-sm-5" type="text" name="first_name"  pattern="[^,]+" required=""><br>
		<label class="col-sm-3">Last Name</label>
		<input class="col-sm-5" type="text" name="last_name" pattern="[^,]+" required=""><br>
		<label class="col-sm-3">Phone number</label>
		<input class="col-sm-5" type="tel" name="phone_number" pattern="[6789][0-9]{9}" required="" placeholder="+91"><br>
		<label class="col-sm-3">Email&nbsp;</label>
		<input class="col-sm-5" type="email" name="email" checked="checked" pattern="[^,]+" required="" value="              @lxisoft.com"><br><br>
		<input type="submit" value="Add contact">
	</form>
	</div>
	</div>	
</body>
</html>							 