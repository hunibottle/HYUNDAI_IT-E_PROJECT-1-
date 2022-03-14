<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/board.css">
<body>
	<c:set value="${title}" var="title" />
	<div class="page-body-wrapper">
		<div class="hs-row box" style="height: 100px;">
			<ol class="breadcrumb col-r">
				<li class="breadcrumb-item"><a
					href="BoardServlet?command=index">Home</a></li>
				<li class="breadcrumb-item"><a class="breadcrumb-item-a"
					href="BoardServlet?command=product">${title}</a></li>
			</ol>
		</div>
		<h2 class="hs-row tit_page tit-bg-none">
			<span><em class="f_jost">${title}</em></span>
		</h2>
		<div class="section box topBr">
			<div class="dropdown imgBoard_sort2">
				<div class="dropdown-menu">
					<ul class="dropdown-menu-ul">
						<li><a href="BoardServlet?command=product"
							class="dropdown-item" id="brand_All"> <span>ALL</span>
						</a></li>
						<li><a class="dropdown-item" id="brand_TH"
							href="BoardServlet?command=productbycatagory&category_code=1">
								<span>SNEAKERS</span>
						</a></li>
						<li><a class="dropdown-item"
							href="BoardServlet?command=productbycatagory&category_code=2">
								<span>CLOTHES</span>
						</a></li>
						<li><a class="dropdown-item"
							href="BoardServlet?command=productbycatagory&category_code=3">
								<span>BEAUTY</span>
						</a></li>
						<li><a class="dropdown-item"
							href="BoardServlet?command=productbycatagory&category_code=4">
								<span>ELECTRONICS</span>
						</a></li>
					</ul>
				</div>
			</div>
			<nav id="sub_menu">
				<ul class="sub_menu">
						<li><a href="BoardServlet?command=productbycatagory&category_code=1">SNEAKERS</a></li>
						<li><a href="BoardServlet?command=productbycatagory&category_code=2">CLOTHES</a></li>
						<li><a href="BoardServlet?command=productbycatagory&category_code=3">BEAUTY</a></li>
						<li><a href="BoardServlet?command=productbycatagory&category_code=4">ELECTRONICS</a></li>
				</ul>

			</nav>
			<div class="contents" id="pl_main">
				<div class="list-sort-area">
					<div class="sortOption">
						<a href="#none" class="active">최근등록순</a> <a href="#none">많이팔린순</a>
						<a href="#none">낮은가격순</a> <a href="#none">높은가격순</a>
					</div>
				</div>
				<div class="pdlist-wrap">
					<ul>
						<c:forEach items="${ProductList}" var="ProductVO">
							<c:forEach var="cnt" begin="1" end="4">
								<li class="pdthumb"><a href="#none"
									style="color: #333; display: block; vertical-align: middle; cursor: pointer;">
										<div class="thumb">
											<img src="images/shoes${cnt}.jpg">
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