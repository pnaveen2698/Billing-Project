<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Menu</title>
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
		<div class="container">
			<div class="row">
			    <div class="col-sm">
			    	<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="https://media.giphy.com/media/husHwKYXyfk5tbGdqy/giphy.gif" alt="Card image cap">
					  <div class="card-body">
					    <h5 class="card-title"><b>Add an Item</b></h5>
					    <p class="card-text">The reality is that we are all economists. We all deal with scarcity as we make choices and calculate how to ration various items and resources that we consume, produce and utilize.</p>
					    <center><a href="add_item" class="btn btn-primary">Add Item</a></center>
					  </div>
					  <br>
					</div>
			    </div><br>
			    <div class="col-sm">
			    	<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="https://media.giphy.com/media/l1Lce5Df3DcSY0s8w/giphy.gif" alt="Card image cap">
					  <div class="card-body">
					    <h5 class="card-title"><b>Inventory</b></h5>
					    <p class="card-text">We want to turn our inventory faster than our people.</p>
					    <center><a href="all_item" class="btn btn-primary">See All Items</a></center>
					  </div>
					  <br>
					</div>
			    </div><br>
			    <div class="col-sm">
			    	<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="https://media.giphy.com/media/d3MM9va3BHH94eLm/giphy.gif" alt="Card image cap">
					  <div class="card-body">
					    <h5 class="card-title"><b>Invoices</b></h5>
					    <p class="card-text">Commercial art is traditionally delivered to a client in a brown-paper bag with an invoice stapled to the outside.</p>
					    <center><a href="all_invoice" class="btn btn-primary">See All Invoices</a></center>
					  </div>
					  <br>
					</div>
			    </div><br>
			    <div class="col-sm">
			    	<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="https://media.giphy.com/media/gfTPmNCC7PKHevwp25/giphy.gif" alt="Card image cap">
					  <div class="card-body">
					    <h5 class="card-title"><b>Invoices Between Dates</b></h5>
					    <p class="card-text">Running your own business can be the loneliest job in the world. You are the MD, answer the phone and make tea, handle the invoices and have to make payments on time.</p>
					    <center><a href="invoice_between_dates" class="btn btn-primary">See invoice(s) between Dates</a></center>
					  </div>
					  <br>
					</div>
			    </div>
			  </div>
		</div>
	</center>
</body>
</html>