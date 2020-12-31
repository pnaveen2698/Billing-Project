<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

</head>
<body style="background-color: lightgrey;">
	<script>
			function secretkeydisplay(role){
				if(role.value=="admin"){
					document.getElementById("secretkey").style.display = "block";
					document.getElementById("submitbutton").style.display = "none";
					document.getElementById("secretkeyerror").style.display = "block";
				}
				else{
					document.getElementById("secretkey").style.display = "none";
					document.getElementById("submitbutton").style.display = "block";
					document.getElementById("secretkeyerror").style.display = "none";
				}
			}
			function checkSKey(event){
				if(event.value==reverse(document.getElementById("uname").value)){
					document.getElementById("submitbutton").style.display = "block";
					document.getElementById("secretkeyerror").style.display = "none";
				}else{
					document.getElementById("submitbutton").style.display = "none";
					document.getElementById("secretkeyerror").style.display = "block";
				}
			}
			function reverse(str){
				  let reversed = "";    
				  for (var i = str.length - 1; i >= 0; i--){        
				    reversed += str[i];
				  }    
				return reversed;
			}
	</script>
	<nav class="navbar navbar-dark bg-dark justify-content-between">
		<div class="container">
		  <a href="/springannohiberweb" class="navbar-brand" >CODA PRESIDIO</a>
		  <div class="form-inline">
		  	<div id="userNotSignedIn">
		  		<a href="login"><button class="btn btn-success">Login</button></a>
		  	</div>
		  </div>
		  </div>
		</nav><br><center>
		<div class="container" style="padding-left: 25%; padding-right: 25%; padding-top: 10%;">
		<form action="register" method="POST" >
			 	<div class="form-group">
				    <label for="uname">Username</label>
				    <input type="text" id="uname" name="uname" class="form-control" placeholder="Enter username" required="required"  />
			 	 </div><br>
			 	 <div class="form-group">
				    <label for="upass">Password</label>
				    <input type="password" name="upass" class="form-control" placeholder="Enter Password" required="required"  />
			 	 </div><br>
			 	 <div class="form-group">
			 	 	 <label for="address">Customer City</label>
			 	 	 <input type="text" name="address" class="form-control" placeholder="Enter City" required="required"  />
			 	 </div><br>
			 	 <div class="form-group">
			 	 	 <label for="role">Role</label>
			 	 	 <select  class="form-control"  name="role" required="required" placeholder="Click to Select a Role" onclick="secretkeydisplay(this)"  > 
				 	 	 <option value="user" >customer</option>
				 	 	 <option value="admin">admin</option>
					</select>
			 	 </div><br>
			 	 <div id="secretkey" style="display: none" class="form-group">
			 	 	 <label for="secret_key">Key(for admin registration only)</label>
			 	 	 <input type="password" oninput="checkSKey(this)" class="form-control" name="secret_key" placeholder="Admin Key"  /> 
			 	 </div><br>
			 	 <p id="secretkeyerror" style="color: red;display: none">Enter correct Secret Key</p>
			 	 <br><center>
					<button id="submitbutton" type="submit" class="btn btn-primary">Register</button>
				</center>
			</form>
	</div>
	</center>
</body>
</html>