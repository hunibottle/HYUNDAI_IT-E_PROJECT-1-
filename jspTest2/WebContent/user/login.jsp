<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href ="../css/login.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	
	<h1>StockH</h1>
	<hr>
	<form action="#">
  		<div class="container">
	    	<label for="id"><b>ID</b></label>
	    	<input type="text" placeholder="Enter id" name="id" id="id" required >

	    	<label for="psw"><b>Password</b></label>
	    	<input type="password" placeholder="Enter Password" name="psw" id="psw" required maxlength="8">
		  	<hr>
		  	
			<button class = "btn" onClick="location.href='Signup.jsp'">Sign up</button>
	    	<button type = "text" class="loginbtn">Login</button>
  		</div>

	</form> 
</body>
</html>
	
<%@ include file="../footer.jsp" %>    
