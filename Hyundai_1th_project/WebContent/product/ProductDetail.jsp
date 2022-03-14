<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href ="./css/product_detail.css">
<link rel="stylesheet" href ="../header.jsp">
<link rel="stylesheet" href ="../footer.jsp">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="bodyWrap" class="item_detail">
	<div id="oneEventLayer"></div>
	<div class="adaptive_wrap">
		<div class="clearfix prd_detail1905" id="clearfix">
			<div class="clearfix image_view3">
				<div class="image_view1" id="image_view1">
					<div class="item_visual" id="imageDiv" style=
					"margin-top: 300px; margin-left:200px;">
						<ul>
							<li>
								<img src="./images/shoes1.jpg">
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="item_detail_info float_right" id="contentDiv" style="margin-top:20px; margin-right:200px; padding:0px">
				<div class="info">
					<div class="info_sect">
						<h4 class="item_name">
							<div class="brand-name">
								<a>₩${productVO.product_price}</a>
							</div>
							<span class="name ko_fir_spel">
								"Dunk Row Retro Black"
							</span>
						</h4>
						<div class="flag"></div>
						<p class="price">
							<span>₩${productVO.product_price}</span>
						</p>
						<div class="prod-detail-con-box">
							<strong class="number-code">
								"상품품번 : "
								<span>nike-01-01</span>
							</strong>
							<div class ="round-style">
								<p>
		                            "뒷면 상단에 플랩이 있으며, 플랩 밑단에 버클 스트랩을
		                             블록하여 기존의 트렌치 코트를 색다르게 재해석 하였습니다.
		                             여유로운 실루엣이 자연스러운 외관을 연출하며, 포멀하지만은 않은
		                             디자인으로 다양한 룩에 활용하기 좋습니다."
								</p>
							</div>
						</div>
					</div>
					<div class="info_sect">
						<ul class="color_size_qty">
							<li>
								<span class="title">수량</span>
								<span class="txt">
									<span class="qty_sel num">
										<a href="javascript:fn_qtySubtraction();" class="left">이전 버튼</a> 
										<input type="text" id="txtqty" title="수량" value="1" class="mr0" readonly="readonly">
										<a href="javascript:fn_qtyAdd();" class="right">다음버튼</a>
									</span>
								</span>
							</li>
						</ul>
					</div>
					<div class="total_price clearfix">
						<div class="title float_left" style="width:auto">총 합계</div>
						<div class="price float_right">
							<span id="sumPrice">${productVO.product_price}</span>
						</div>
					</div>
					<div class="btnwrap clearfix" style="position:absolute; width:473px;">
						<form id="addToCartForm" name="addToCartForm">
							<input type="button" value="쇼핑백 담기" class="btn cart1803 float_left ml0"
							id="addToCartButton" onclick="#";>
						</form>
						<input type="button" value="바로주문" class="btn order float_right mr0" id="addToCartBuyNowButton" onclick="#";>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="../footer.jsp"%> 