<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href ="./css/index.css">
<%@ include file="./header.jsp"%>
<%@ include file="./slideshow/SlideShow.html"%>


<div class="page-body-wrapper">
	
	<div id="section1" class="section box-overspill with-bg main_global">
		<h2><span class="eng1">HANDSOME LEADING GLOBAL</span></h2>
		<h2><span class="eng2">FASHION AND LIFESTYLE</span></h2>
		<div class="hs-row box">
			<div class="col-md">
				<dl>
					<dt><img src="./images/handsome1.jpg" alt=""></dt>
					<dd><p class="display-s">1987</p></dd>
					<dd><p class="name">Established</dd>
				</dl>
			</div>
			<div class="col-md">
				<dl>
					<dt><img src="./images/handsome2.jpg" alt=""></dt>
					<dd><p class="display-s">1,389</p></dd>
					<dd><p class="name">Stores</dd>
				</dl>
			</div>
			<div class="col-md">
				<dl>
					<dt><img src="./images/handsome3.jpg" alt=""></dt>
					<dd><p class="display-s">29</p></dd>
					<dd><p class="name">Brands</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="section box-overspill main_noti">
		<div class="section box">
			<h2 class><span class="eng">WHAT'S NEW</span></h2>
			<h2 class><span class="eng">AT HANDSOME X StockH</span></h2>
			
			<div class="hs-row">
				<div class="col-md" onclick="location.href='BoardServlet?command=news_detail&newsnumber=1'">
					<dl>
						<dt>	
							<img src="./images/handsomeNews1.jpg" alt width="441" height="270">
						</dt>
						<dd>한섬, 더한섬하우스 매장서 지비지 작가 전시 연다.</dd>
						<dd>""2022.02.22""</dd>
					</dl>
				</div>
				<div class="col-md">
					<dl>
						<dt>
							<img src="./images/handsomeNews2.jpg" alt width="441" height="270">
						</dt>
						<dd>한섬, 더한섬하우스 매장서 지비지 작가 전시 연다.</dd>
						<dd>""2022.02.22""</dd>
					</dl>
				</div>
				<div class="col-md">
					<dl>
						<dt>
							<img src="./images/handsomeNews3.jpg" alt width="441" height="270">
						</dt>
						<dd>한섬, 더한섬하우스 매장서 지비지 작가 전시 연다.</dd>
						<dd>""2022.02.22""</dd>
					</dl>
				</div>
			</div>
			
		</div>
	</div>
</div>

<div>
<%@ include file="../product/BestResellBoard.jsp"%>
<%@ include file="../product/ProductBestBoard.jsp"%>
</div>
<%@ include file="./footer.jsp"%>
