<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add An Item</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

</head>
<body  style="background-color: lightgrey;">
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
		<div class="container"><a href="admin" class="btn btn-secondary">Back</a></div>
		<div class="container"  style="padding-left: 25%; padding-right: 25%; padding-top: 5%;">
		
		<center>
			<form method="POST" action="add_item">
				<h1>Add Item</h1><br>
				<div class="form-group">
					Item Name : <input type="text" placeholder="Item Name"  class="form-control" name="itemdesc" required><br>
				</div>
				<div class="form-group">
					Category :  <input type="text" placeholder="Item Category" class="form-control" name="category" required><br>
				</div>
				<div class="form-group">
					 Unit :     <input type="text" placeholder="Item Unit" class="form-control" name = "unit" required><br>
				</div>
				<div class="form-group">
					 Price :    <input type = "number" placeholder="Item Price"  class="form-control" name = "price" required><br>
				</div>
				<div class="form-group">
					 Image URL :    <input type = "text" placeholder="Image URL"  class="form-control" name = "image" required><br>
				</div>
				<button type="submit" class="btn btn-primary" value="Add item" >Add Item</button>
			</form>
		</center>
</div>
</body>
</html>