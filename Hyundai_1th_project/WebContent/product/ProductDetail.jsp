<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- <script type="text/javascript" src="./Product/product.js" ></script>  -->
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script>
function go_cart() {
    document.addToCartForm.action = "BoardServlet?command=cart_insert";
    document.addToCartForm.submit();
}
function fn_qtyAdd(){
	var price = $('input[name=productPrice]').val();
	var quantity = $('#txtqty').val();
	quantity = Number(quantity) + 1;
	quantity = quantity + '';
	$('#txtqty').val(quantity);
	$('input[name=quantity]').val(quantity);
	totalprice = Number(price)*quantity;
	totalprice = totalprice + '';
	$('#sumPrice').text(totalprice);
	
}
function fn_qtySubtraction(){
	var price = $('input[name=productPrice]').val();
	var quantity = $('#txtqty').val();
	quantity = Number(quantity) - 1;
	if(quantity >= 0){
		quantity = quantity + '';
		$('#txtqty').val(quantity);
		$('input[name=quantity]').val(quantity);
		totalprice = Number(price)*quantity;
		totalprice = totalprice + '';
		$('#sumPrice').text(totalprice);
	}
	
}
</script>
<link rel="stylesheet" href ="./css/product_detail.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="productPrice" value="${productVO.product_price}">
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
								<img src="./images/${productVO.product_image}">
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
								<a>상품 소개</a>
							</div>
							<span class="name ko_fir_spel">
								${productVO.product_name_2}
							</span>
						</h4>
						<div class="flag"></div>
						<p class="price">
							<span>₩${productVO.product_price}</span>
						</p>
						<div class="prod-detail-con-box">
							<strong class="number-code">
								"상품품번 : "
								<span>${productVO.category_code}</span>
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
						<form id="addToCartForm" name="addToCartForm" method = "post" action="BoardServlet?command=cart_insert&product_number=${productVO.product_number}">
							<input type="hidden" name="quantity" value="1" />
							<input type="hidden" name="product_name" value="${productVO.product_name}" />
							<input type="submit" value="쇼핑백 담기" class="btn cart1803 float_left ml0"
							id="addToCartButton">
						</form>
						<button onclick="document.getElementById('id01').style.display='block'" style=" width:140px; height:50px; color:#575757; background:#fff; ">Sign Up</button>

						<div id="id01" class="modal" style= "margin-left: 20%; margin-top: 5%; border-radius: 6px; border: solid 2px grey;">
						  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
						  <form class="modal-content" action="/action_page.php">
						    <div class="container">
						      <p><input type="text" name = "receiver_name" value="${memberVO.user_name}"/></p>
						      <p><input type="text" name = "receiver_" value="${memberVO.user_email}"/></p>
						      <p><input type="text" name = "receiver_phone" value="${memberVO.user_phone}"/></p>
						      <p>배송지 : 경기도 안산시 단원구 적금로 164 105동 603</p>
						      <label for="email"><b>Email : kimbyeounghoon@naver.com</b></label>
						      <p>상품이름 : ${productVO.product_name}</p>
						      <p>상품가격 : ₩${productVO.product_price}</p>
						      <p>상품수량 : 1개</p>
						      
						      <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
						
						      <div class="clearfix">
						        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">취소하기</button>
						        <button type="submit" class="signupbtn">구매하기</button>
						      </div>
						    </div>
						  </form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
</body>
</html>
<%@ include file="../footer.jsp"%>