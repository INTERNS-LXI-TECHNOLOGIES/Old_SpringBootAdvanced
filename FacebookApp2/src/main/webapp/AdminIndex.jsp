<%@ page import="java.util.*,com.lxisoft.facebookApp2.model.*"%>
<html>
<body >
 

<style>

</style>
<form action="AdminServlet" method="post">
<center>
<br />
<center><h3><strong><font color="black">::Enter the Questions::</font></strong></h3></center>

<br />

<table border="2">
<tr>
<th>Add Questions:</th>
<td>
<div class="control-group">
     <label class="required">
	  </label>
<input type="text" name="Questions" size="80px" height="200px" placeholder="Required Field" class="form-control"><br><br></br>
</div>
</td>
</tr>



<tr>
<th>Option1:</th>
<td>
<input type="text" name="option1" maxlength="100"><br><br></br>
</td>
</tr>
<tr>

<th>Option2:</th>
<td>
<input type="text" name="option2" maxlength="100"><br><br></br>
</td>
</tr>
<tr>
<th>Option3:</th>
<td>
<input type="text" name="option3" maxlength="100"><br><br></br>
</td>
</tr>
<tr>
<th>Option4:</th>
<td>
<input type="text" name="option4"><br><br></br>
</td>
</tr>
<tr>
<th>Answer</th>
<td><input type="text" name="answer"><br><br></br></td>
</tr>
</table><br />
<br />
<input type="image" src="submit.gif" alt="Submit" height="55px" width="80px" >
</form>

<div align="center">



<form action="EditServlet" method="get">
<input type="hidden"  name="page" value="1">
<input type="submit" value="Read All">
</form>

<form action="read.jsp" method="">

<input type="submit" value="Read">

</form>






</div>
</center>

</body>
</html>