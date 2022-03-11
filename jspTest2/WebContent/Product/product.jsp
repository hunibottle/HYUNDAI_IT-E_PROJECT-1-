<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href ="./css/product.css">

<!DOCTYPE html>
<html>
<body>
	
<div id="bestProduct">

<div class="css-0" data-component="ProductRow">
	<div class="css-1a">
		<h2>
		Most Popular Sneakers	
		<button class = "btn" onClick="location.href='./Product/product_see_more.jsp'">See More!</button>
		</h2>
		
	</div>
	
	<div class="css-2a" data-component="SmartGridRow">
		<div data-component="product-tile" class="css-0">
		<c:forEach items="${ProductList}" var="ProductVO">
		
			<div class="css-3a" style="width: 200px; padding: 20px; display: inline-block; border: 1px solid lightgrey; 
			cursor:pointer," onclick="location.href='BoardServlet?command=product_detail&product_number=${ProductVO.product_number}'">
			
					<div id="image">
					<img src="./images/${ProductVO.product_image}" alt=""; style="width: 150px; height: 100px;">
					</div>
					<br>
					<div id="name" style="font-size: 10px">
					<h3>${ProductVO.product_name}</h3>
					
					</div>
					<div id="price">
					<h4>${ProductVO.product_price}</h4>
					</div>
					<div id="hits">
					<h3>${ProductVO.product_hits}</h3>
					</div>
			</div>
			</c:forEach>
		</div>
		
		</div>
		<br>
		<div class="css-4a">
		<h2>
		Popular Brands	
		</h2>
	</div>
		
</div>
</body>
</html>
</div>