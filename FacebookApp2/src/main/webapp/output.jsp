<%@page import="com.lxisoft.facebookApp2.model.*"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
img {
  border-radius: 50%;
}
</style>
<style>

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


			
			<% Output op=(Output)session.getAttribute("Output");  %>
			<center><h1><%out.print(op.getUserName());%></h1></center>
			<center><h1><%out.print(op.getUserScore());%></h1></center>
			<%  String mark=""+(op.getUserScore());  %>
			

<div id="grad1" style="text-align:center;margin:auto;color:#888888;font-size:40px;font-weight:bold">
<br>
<br>
<center><img class="center" src="images\<%=mark%>.jpeg"  width="400" height="400"></center>
</div>



</body>
</html>