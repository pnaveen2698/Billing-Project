<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
</head>
<body style="background-color: lightgrey;">
<nav class="navbar navbar-dark bg-dark justify-content-between">
		<div class="container">
		  <a href="/springannohiberweb" class="navbar-brand" >CODA PRESIDIO</a>
		  <div class="form-inline">
		  	<div id="userNotSignedIn">
		  		<a href="register"><button class="btn btn-primary">Register</button></a>
		  	</div>
		  </div>
		  </div>
		</nav>
<center><br><br>
<div class="container" style="padding-left: 25%; padding-right: 25%;">
	<form method="POST" action="login">
		<div class="form-group">
			Username : <input type="text" placeholder="Username" name="uname" class="form-control" required>  <br>
		</div>
		<div class="form-group">
			Password :  <input type="password" placeholder="Password" name="upass" class="form-control" required><br>
		</div>
		<div class="form-group">
			<button  type="submit" class="btn btn-success">Login</button><br>
		</div>
			<%= request.getAttribute("info") %><br>
	</form>
	</div>
	<br><a href="register">New User....Register now!!!</a>
</center>
</body>
</html>