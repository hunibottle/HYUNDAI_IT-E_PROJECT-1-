<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./css/product.css">
<body>

	<div id="bestProduct">

		<div class="css-0" data-component="ProductRow">
			<div class="css-1a">
				<h2>
					Most Popular Sneakers
					<button class="btn"
						onClick="location.href='BoardServlet?command=product&index=1'">See More!</button>
				</h2>

			</div>

			<div class="css-2a" data-component="SmartGridRow">
				<div data-component="product-tile" class="css-0">
					<c:forEach items="${ProductList}" var="ProductVO">
						<!-- <button class = "btn2" onClick="'#'"> -->
						<div class="css-3a"
							style="width: 200px; height: 187px; padding: 20px; display: inline-block; border: 1px solid lightgrey; cursor: pointer;"
							onclick="location.href='BoardServlet?command=product_detail&product_number=${ProductVO.product_number}'">
							<div id="image">
								<img src="./images/${ProductVO.product_image}" alt=""
									; style="width: 150px; height: auto;">
							</div>
							<div id="name">
								<h3>${ProductVO.product_number}</h3>
								<h3>${ProductVO.product_name}</h3>
							</div>
							<div id="price">
								<h4>${ProductVO.product_price}</h4>
							</div>
							<div id="hits">
								<h3>${ProductVO.product_hits}</h3>
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
