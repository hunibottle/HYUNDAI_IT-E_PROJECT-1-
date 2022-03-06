<!DOCTYPE html>
<html> 
<head> 
	<title>stockH</title> 
	<meta charset="utf-8"> <meta name="viewport" content="width=device-width, initial-scale=1"> <!-- CSS --> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> <!-- JS --> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> <!-- CDN --> 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script> 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> 
	<style>
		.btn-item {
		
			padding = 100px;
			padding-right = 0 auto;
		}
	
	</style>
</head> 
<body> <!-- header --> 
	<div class="jumbotron" style="margin-bottom:0">
		 <h1>StockH</h1> 
		 <p>현대백화점의 리셀 플랫폼 </p> 
	</div> <!-- content --> 
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark"> 
		<a href="#" class="navbar-brand">StockH</a> 
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
				<div class="btn-item">
  				<input type="submit" class="btn btn-info" value="Sign in">
  			    <input type="submit" class="btn btn-info" value="Sign np">
				</div>
			</ul>
	    </div>
	</nav>

</body> 

</html>


<!-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; char set="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>stockH</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1
				aria-expanded="false">
				<span class = "icon-bar"></span>
				<span class = "icon-bar"></span>
				<span class = "icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp"> stockH</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class ="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li><a href="bbs.jsp">게시판</a></li>
			</ul>
		</div>
	
	</nav>
	<script src ="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src ="js/bootstrap.js"></script>
</body>
</html>

---->