<%@page import="com\lxisoft\facebookApp2\model.*"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
img {
  border-radius: 50%;
}

h1 {
    text-shadow: 2px 2px 8px #FF0000;
}
</style>
<style>
#grad1 {
    height: 600px;
    background: red; /* For browsers that do not support gradients */
    background: linear-gradient(to right, red, orange, yellow, green, blue, indigo, violet); /* Standard syntax (must be last) */
}
</style>
</head>
<body>


			
			<% Output op=(Output)request.getAttribute("output");  %>
			<center><h1><%out.println(dto.getUserName());%></h1></center>
			<center><h1><%out.println(dto.getUserScore());%></h1></center>
			<%  String mark=dto.getUserScore();  %>
			

<div id="grad1" style="text-align:center;margin:auto;color:#888888;font-size:40px;font-weight:bold">
Gradient Background
<center><img class="center" src="images\<%mark%>.jpg" alt="Paris" width="400" height="400"></center>
</div>



</body>
</html>