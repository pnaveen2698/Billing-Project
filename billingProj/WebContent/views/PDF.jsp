<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="ISO-8859-1">
<title>Cart Invoice</title>
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
			<a href="User" class="btn btn-secondary">Customer Menu</a>
		<center>
<h3>Thank you for Shopping...</h3><br>

<table class="table">
        <tr>
            <th>Item_No</th>
            <th>Item_Name</th>
            <th>Unit</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
        </tr>
            <c:forEach items="${iterr}" var="iter">
            <tr>
            <th>${iter.itemdto.itemno}</th>
            <td>${iter.itemdto.itemdesc}</td>
            <td>${iter.itemdto.unit}</td>
            <td>${iter.qty}</td>
            <td>${iter.itemdto.prize}</td>
            <td>${iter.itemdto.prize * iter.qty }</td>
            </tr>

        </c:forEach>
                    <tr> 
            <td></td><td></td><td></td><td></td><th>Total Amount</th> <th><%= request.getAttribute("total") %></th>
            </tr>
    </table>


<h3><a href = "pdf" class="btn btn-info">Download Invoice</a></h3>
</center>
</body>
</html>