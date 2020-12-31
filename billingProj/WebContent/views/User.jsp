<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Menu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

</head>
<body  style="background-color: lightgrey;">
<center>
<nav class="navbar navbar-dark bg-dark justify-content-between">
		<div class="container">
		  <a href="/springannohiberweb" class="navbar-brand" >CODA PRESIDIO</a>
		  <div class="form-inline">
		  	<div id="userNotSignedIn">
		  		<a href="logout"><button class="btn btn-danger">Logout</button></a>
		  	</div>
		  </div>
		  </div>
		</nav><br>
		<div class="container"  style="padding-top: 10%;">
			<div class="row">
			    <div class="col-sm">
			    	<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="https://media.giphy.com/media/z2D26GunfUK1W/giphy.gif" alt="Card image cap">
					  <div class="card-body">
					    <h5 class="card-title"><b>Shopping</b></h5>
					    <p class="card-text">Whoever said money can't buy happiness simply didn't know where to go shopping.</p>
					    <center><a href="shopping" class="btn btn-primary">Go Shopping</a></center>
					  </div>
					  <br>
					</div>
			    </div><br>
			    <div class="col-sm">
			    	<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="https://media.giphy.com/media/d3MM9va3BHH94eLm/giphy.gif" alt="Card image cap">
					  <div class="card-body">
					    <h5 class="card-title"><b>My Invoices</b></h5>
					    <p class="card-text">We're living in an era of unprecedented change, and I want to be a part of documenting it.</p>
					    <center><a href="user_invoices" class="btn btn-primary">Invoices</a></center>
					  </div>
					  <br>
					</div>
			    </div><br>
			  </div>
		</div>
	</center>
</body>
</html>