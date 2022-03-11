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
	<form name="frmLogin" method ="post" action="login">
  		<div class="container">
	    	<label for="id"><b>ID</b></label>
	    	<input type="text" placeholder="Enter id" name="user_id" id="id" required >

	    	<label for="psw"><b>Password</b></label>
	    	<input type="password" placeholder="Enter Password" name="user_pw" id="psw" required maxlength="8">
		  	<hr>
		  	
		  	<input type = "submit" value ="login">
			<!-- <button class = "btn" onClick="location.href='Signup.jsp'">Sign up</button> -->
	    	<!--  <button type = "text" class="loginbtn">Login</button> -->
  		</div>
	</form> 
</body>
</html>
	
<%@ include file="../footer.jsp" %>    
