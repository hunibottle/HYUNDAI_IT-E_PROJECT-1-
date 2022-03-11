<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href ="./css/product.css">

<!DOCTYPE html>
<html>
<body>
	
<div id="bestProduct">

<div class="css-0" data-component="ProductRow">
	
	<div class="css-2a" data-component="SmartGridRow">
		<div data-component="product-tile" class="css-0">
			<c:forEach items="${ProductList}" var="ProductVO">
				<div class="css-3a" style="width: 200px; padding: 20px; display: inline-block; border: 1px solid lightgrey;">
						<div id="image">
						<img src="./images/${ProductVO.brand_image}" alt=""; style="width: 150px; height: 100px;">
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
</div> --%>