<!DOCTYPE html>
<html>
<head>
<link rel=”stylesheet” type=”text/css” href=”style.css”>
<script src=”verificalogin.js” type=”text/javascript”></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200&display=swap" rel="stylesheet">

<style>
#log{
position: absolute;
left: 30px;
padding-top:5px;
margin-top:0px;
background-color: MistyRose;
font-family: Montserrat, Arial, Helvetica, sans-serif;
font-size: 20px;
margin-left: auto;
margin-top: 0px;
color:#00326E;
}

body{
margin-left: 30px;
padding-left:30px;
font: Montserrat;
background-color:MistyRose;

}

button{
color:#00326E;
font: Montserrat;
}

</style>

</head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Tiw2021.Tesina00.HelloAppEngine" %>
<%@ page import ="java.util.*" %>
<%@ page import= "com.google.appengine.api.users.*" %>
<%@ page import="Tiw2021.Tesina00.*" %>
<%@ page import="Tiw2021.Tesina00.login" %>

<body id="log">
<h1>Benvenuto!<h1>
<h3>Fai il login per accedere al sito della Prefettura</h3>
<!-- QUI VOGLIO FARE IL LOGIN -->
<form method="post" id="log" action="/helloTesina00"> 
		<table>
		<tr><td><label for="username" style="width:80px"><b>Username</b></label></td>
		<td><input type="text" id="User" placeholder="Enter Username" name="username" required></td></tr>
		<tr><td><label for="psw" style="width:80px;"><b> Password </b></label></td>
		<td><input type="password" id="Password" placeholder="Enter Password" name="password" required></td></tr>
		<tr><td></td><td><button type="submit" class="btn btn-success" style="position: absolute; left: 25%; margin-top: 5px;">Login</button></td></tr>
    	</table>
</form>

</body>
</html>
