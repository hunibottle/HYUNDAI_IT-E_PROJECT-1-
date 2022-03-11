<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head> 
	<title>stockH</title> 
	<link rel="stylesheet" href ="./css/header.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Iconrel="stylesheet">
	<meta charset="utf-8"> <meta name="viewport" content="width=device-width, initial-scale=1"> <!-- CSS --> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> <!-- JS --> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> <!-- CDN --> 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script> 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> 
</head> 
<body> <!-- header --> 
	<div class="jumbotron" style="margin-bottom:0">
		 <h1 id="logo">StockH</h1> 
		 <p id="intro">현대백화점의 리셀 플랫폼 </p> 
		  <div id="quote">
       		<span></span>
      	    <span></span>
         </div>
		 <script src="./js/quote.js"></script>
	</div> <!-- content --> 
	
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark"> 
		<a href="index.jsp" class="navbar-brand">StockH</a> 
		
		<!-- Toggle Button  반응형으로 처리  -->  
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar"> 
			<span class="navbar-toggler-icon"></span> 
		</button> 
		<div class="collapse navbar-collapse" id="collapsibleNavbar"> 
			<ul class="navbar-nav"> 
				<li class="nav-item"><a href="#" class="nav-link">공지사항</a></li> 
				<li class="nav-item"><a href="#" class="nav-link">Sneaker</a></li> 
				<li class="nav-item"><a href="#" class="nav-link">Streetwear</a></li>
				<li class="nav-item"><a href="#" class="nav-link">For Buy</a></li>
				<li class="nav-item"><a href="#" class="nav-link">For Sale</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Q&A</a></li>
			</ul>
	    </div>
	     
	    	<button class = "btn" onClick="location.href='./user/login.jsp'">Login</button>
	    	<button class = "btn">Sign up</button>
	
	</nav>

</body> 
</html>

