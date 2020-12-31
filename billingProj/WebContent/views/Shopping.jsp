<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="ISO-8859-1">
<title>Shopping</title>
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
		  		<a href="logout"><button class="btn btn-danger">Logout</button></a>
		  	</div>
		  </div>
		  </div>
		</nav><br>
		<div class="container">
		<a href="User" class="btn btn-secondary">Back</a>
		<center>

<form method="POST" action="add_invoice" method = "get">
	<h4>Enter Quantity and <%= request.getAttribute("info") %></h4>
		<table class="table">
			<tr>
				<th>Item Number</th>
				<th>Name</th>
				<th>Category</th>
				<th>Unit</th>
				<th>Price</th>
				<th>Image</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${shopping}" var="iter">
				<tr>
				 	<td>${iter.itemno}</td>
				 	<td>${iter.itemdesc}</td>
				 	<td>${iter.categories}</td>
				 	<td>${iter.unit}</td>
				 	<td>${iter.prize}</td>
				 	<td><img src="${iter.image}"  width="100" height="150" /></td>
					<td><input type = "number" min ="0" name = "${iter.itemno}" value = "0"  placeholder = 0 required/></td>
				</tr>    
	        </c:forEach>
		</table>
		<input type="submit" class="btn btn-primary" value="Buy"><br>
	</form>
	
</center>

</div>

</body>
</html>