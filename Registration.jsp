<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<form action="validateUser" method ="post">
<input type ="label" id="lbl1" >User Name </input>
<input type ="text" id="uid" length="20"> </input> <br/>
<input type ="label" id="lbl2" >Password</input>
<input type ="text" id="pwd" length="20"> </input> <br/>
<input type="checkbox" id="newUser"> </input>
<input type="submit" value="Sign In">
</form>
</body>
</html>