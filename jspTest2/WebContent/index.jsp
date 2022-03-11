<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header2.jsp"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href ="./css/index.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<%@ include file="./slideShow/slideshow.html"%>
<div id="section1" class="section box-overspill with-bg main_global">
<h2 class>
	<span class ="eng1">HANDSOME LEADING GLOBAL</span>
</h2>
<br>
<br>
<h2 class>
	<span class ="eng2">FASHION AND LIFESTYLEL</span>
</h2>
<br>
<h2 class>
	<span class ="eng3" style='letter-spacing:5px'>LAUNCHING NEW RESELL PLATFORM</span>
</h2>
<div class="hs-row box">
	<div class="col-md">
		<dl>
			<dt>
				<img src="./images/handsome1.jpg" alt="">
			</dt>
			<br>
			<dd><p class="display-s">1987</dd>
			<dd><p class="name">Established</dd>
		</dl>
	</div>
	<div class="col-md">
	<dl>
		<dt>
			<img src="./images/handsome2.jpg" alt="">
		</dt>
		<br>
		<dd><p class="display-s">1,389</p>
		<dd><p class="name">Stores</p></dd>
	</dl>
	</div>
	<div class="col-md">
	<dl>
		<dt>
			<img src="./images/handsome3.jpg" alt="">
		</dt>
		<br>
		<dd><p class="display-s">29</p>
		<dd><p class="name">Brands</dd>
	</dl>
	</div>
  </div>
</div>

<div class="section box-overspill main_noti">
	
	<div class="section box">
		
		<h2 class>
			<span class="eng">WHAT'S NEW</span>
		</h2>
		<h2 class>
			<span class="eng">AT HANDSOME X StockH</span>
		</h2>
		<div class="hs-row">
			
			<div class="col-md">
				<dl>
					<dt>
						<img src = "./images/handsomeNews1.jpg" alt="" width="441" height="270">
					</dt>
					<dd>한섬, 더한섬하우스 매장서 지비지 작가 전시 연다.</dd>
					<dd>"2022.02.22"</dd>
				</dl>
			</div>
			<div class="col-md">
				<dl>
					<dt>
						<img src = "./images/handsomeNews2.jpg" alt="" width="441" height="270">
					</dt>
					<dd>비비안웨이스트우드 하이탑 스니커즈 10,000원(98% 할인가) 2월 24일 응모 시작</dd>
					<dd>"2022.02.22"</dd>
				</dl>
			</div>
			<div class="col-md">
				<dl>
					<dt>
						<img src = "./images/handsomeNews3.jpg" alt="" width="441" height="270">
					</dt>
					<dd>더현대 서울 1주년 Half Price Raffle(이지부스트))</dd>
					<dd>"2022.02.22"</dd>
				</dl>
			</div>
		</div>
	</div>
</div>

<div>
<%@ include file="../Product/brand.jsp"%>
</div>
<div>
<%@ include file="../Product/product.jsp"%>
</div>
<div class="clear"></div>


<%@ include file="../footer.jsp"%>
	
    
</body>
</html>