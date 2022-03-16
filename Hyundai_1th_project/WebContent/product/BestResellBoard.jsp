<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>상품목록</title>
</head>
<link rel="stylesheet" href="./css/product.css">
<body>

	<div id="bestProduct">

		<div class="css-0" data-component="ProductRow">
			<div class="css-1a">
				<h2 style="margin-botton:30px;">
					Ready-To-Stock!
					
				</h2>

			</div>

			<div class="css-2a" data-component="SmartGridRow">
				<div data-component="product-tile" class="css-0">
					<c:forEach items="${ResellProductList}" var="ResellProductVO">
						<!-- <button class = "btn2" onClick="'#'"> -->
						<div class="css-3a"
							style="width: 200px; height: 187px; padding: 20px; display: inline-block; border: 1px solid lightgrey; cursor: pointer;"
							>
							<div id="image">
								<img src="./images/${ResellProductVO.product_image}" alt=""
									; style="width: 150px; height: auto;">
							</div>
							<div id="name">
								<h3>${ResellProductVO.product_name}</h3>
							</div>
							<div id="price">
								<h4>${ResellProductVO.product_price}</h4>
							</div>
						</div>
						<!-- 		</button> -->
					</c:forEach>
				</div>


			</div>
		</div>
	</div>
</body>
</html>
