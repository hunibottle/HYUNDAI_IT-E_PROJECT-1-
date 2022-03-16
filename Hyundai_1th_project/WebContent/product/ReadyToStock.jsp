<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>
<head>
	<title>상품목록</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/board.css">
<body>
	<div class="page-body-wrapper">
		<div class="hs-row box" style="height: 100px;">
			<ol class="breadcrumb col-r">
				<li class="breadcrumb-item"><a
					href="BoardServlet?command=index">Home</a></li>
				<li class="breadcrumb-item"><a class="breadcrumb-item-a"
					href="BoardServlet?command=product&index=1">Ready_To_Stock</a></li>
			</ol>
		</div>
		<h2 class="hs-row tit_page tit-bg-none">
			<span><em class="f_jost">Ready_To_Stock</em></span>
		</h2>
		<div class="section box topBr">
			<nav id="sub_menu">
				<ul class="sub_menu">
						<li><a href="BoardServlet?command=sneakers&index=1">SNEAKERS</a></li>
						<li><a href="BoardServlet?command=clothes&index=1">CLOTHES</a></li>
						<li><a href="#none">READY_TO_STOCK</a></li>
				</ul>
			</nav>
			<div class="contents" id="pl_main">
				<div class="pdlist-wrap">
					<ul>
						<c:forEach items="${ProductList}" var="ProductVO">
								<li class="pdthumb">
								<a href="BoardServlet?command=product_detail&product_number=${ProductVO.product_number}" style="color: #333; display: block; vertical-align: middle; cursor: pointer;">
										<div class="thumb">
											<img src="images/${ProductVO.product_image}">
										</div>
										<div class="figcaption">
											<div class="pdname">${ProductVO.product_name}</div>
											<div class="pdprice">
												<span class="rateprice">
													<p class="price">
														<em>${ProductVO.product_price}</em>원
													</p>
												</span>
											</div>
											<div class="pdinfo">
												<div class="hitrates" style="line-height: 20px">
													<span>${ProductVO.product_hits}</span>
												</div>
												<!-- end hitrates -->
											</div>
											<!-- end pdinfo -->
										</div> <!-- end figcaption -->

								</a></li>
						</c:forEach>
					</ul>
				</div>
				<!-- end pdlist-wrap -->
			</div>
			<!-- end contents -->
		</div>
	</div>
	<script>
	</script>
</body>
</html>


<%@ include file="../footer.jsp"%>