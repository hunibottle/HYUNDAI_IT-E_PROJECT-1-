<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href ="./css/product-detail.css">

<%@ include file="../header.jsp"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>

<div id="top">
	<div id="left">
		<div id="name">
			 	<p id="name_1"> ${productVO.product_name} <p>
			 	<p id="name_2"> ${productVO.product_name_2} <p> 
		</div>
		<div id="image">
			 <div id="image_source">
			 
			 
			 	<img src="./images/${productVO.product_image}">
			</div>
		</div>
	</div>
	<div id="mid"  style="overflow:scroll">
		<div id="info_1">
			<div id="product_info">
				<section id="theme">
				<div class="select">
					<%-- <p>${productVO.product_desc}</p> --%>
					<div class="text">size</div>
					<ul class="option-list">
						<li class="option">210</li>
						<li class="option">220</li>
						<li class="option">230</li>
						<li class="option">240</li>
						<li class="option">250</li>
						<li class="option">260</li>
						<li class="option">270</li>
						<li class="option">280</li>
						<li class="option">290</li>
					</ul>
				</div>
				</section>
			</div>
			<div id="info_1">
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="Product/product_detail.js"></script>
</body>
</html>
<%@ include file="../footer.jsp"%>