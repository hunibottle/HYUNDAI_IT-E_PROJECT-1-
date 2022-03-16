<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>상품목록</title>
<link rel="stylesheet" href="../header.css">
<link rel="stylesheet" href="../footer.css">
<link rel="stylesheet" href ="./css/product_detail.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript" src="http://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
$(document).ready(function(){

	$.ajax({
		url:"chart",
		dataType:"JSON",
		success:function(result){
			
			google.charts.load('current',{
				'packages' : ['corechart']
			});
				google.charts.setOnLoadCallback(function(){
				drawChart(result);
			});
			
		}
	});
	function drawChart(result){
		var data = new google.visualization.DataTable();
		data.addColumn('string','Product_name');
		data.addColumn('number','Product_hits');
		var dataArray = [];
		$.each(result, function(i, obj){
			dataArray.push([obj.product_name, obj.product_hits]);
		});
		
		data.addRows(dataArray);
		
		
		var columnchart_option = {
				title: '품목별 조회수 차트',
				width: 800,
				height: 300,
				bar: {groupWidth: "65%"},
		        legend: { position: "none" },
		};
		
		var columnchart = new google.visualization.ColumnChart(document
				.getElementById('columnchart_div'));
		columnchart.draw(data, columnchart_option);
	}
	
});


	function go_cart() {
			document.addToCartForm.action = "BoardServlet?command=cart_insert";
			document.addToCartForm.submit();
		}
		function fn_qtyAdd() {
			var price = $('input[name=productPrice]').val();
			var quantity = $('#txtqty').val();
			quantity = Number(quantity) + 1;
			quantity = quantity + '';
			$('#txtqty').val(quantity);
			$('input[name=quantity]').val(quantity);
			totalprice = Number(price) * quantity;
			
			totalprice = totalprice + '';
			$('#sumPrice').text(totalprice);
			$('input[name=total_price]').val(totalprice);
			$('input[name=product_quantity]').val(quantity);
			$('input[name=cart_quantity]').val(quantity);

		}
		function fn_qtySubtraction() {
			var price = $('input[name=productPrice]').val();
			var quantity = $('#txtqty').val();
			quantity = Number(quantity) - 1;
			if (quantity >= 0) {
				quantity = quantity + '';
				$('#txtqty').val(quantity);
				totalprice = Number(price) * quantity;
				totalprice = totalprice + '';
				$('#sumPrice').text(totalprice);
				$('input[name=total_price]').val(totalprice);
				$('input[name=product_quantity]').val(quantity);
				$('input[name=cart_quantity]').val(quantity);
			}
			

		}

</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="productPrice" value="${productVO.product_price}">
	<div class="all" style="height: 500px;">
		<div class="right_contents section_product_summary">
			<div class= "product_left">
				<div id = "detail_bigimg" class= product_img_basic>
					<div class="product-img">
						<img src="./images/${productVO.product_image}">
					</div>
				</div>
			
			</div>
			<div id = "product_order_info" class = "product_right product_order_info">
				<div class="explain_product_product_info_section">
					<h4 class = "title-box font-mss">
						Product Info
						<span>제품정보</span>
					</h4>
					<ul class = "product_artice">
						<li>
							<p class ="product_article_tit">
								Category_code
							</p>
							<p class ="product_article_contents">
								${productVO.product_name}
							</p>
						</li>
						<li>
							<p class="product_article_tit">
								조회수
							</p>
							<p class="product_article_contents">
								<strong id="pageview_1m">6.3만 회 이상</strong>
							</p>
						</li>
					</ul>
				</div>
				<div class="explain_product price_info_section">
					<h4 class="title-box font-mss">
						Price Info
						<span class="KorSub"></span>
					</h4>
					<ul class="product_article">
						<li class="box_info_products">
							<p class="product_article_tit">판매가</p>
							<p class="product+article_contents">
								<span class="product_artice_price" style="font-size:40px;"id="goods_price">
									${productVO.product_price}
								</span>
							</p>
						</li>
						<li class="box_info_products interest-free">
							<p class="product_article_tit">수량</p>
							<span class="qty_sel num">
									<a href="javascript:fn_qtySubtraction();" class="left">이전 버튼</a> 
									<input type="text" id="txtqty" title="수량" value="1" class="mr0" style="width:47px;"readonly="readonly">
									<a href="javascript:fn_qtyAdd();" class="right">다음버튼</a>
							</span>
						</li>
						<li class="box_info_products">
							<p class="product_article_tit">총 합계</p>
							<p class="product_article_contents">
								<span id="sumPrice" style="font-size:40px;">${productVO.product_price}</span>
							</p>
						</li>
					</ul>
				</div>
				<div id="buy_option_area" class="explan_product option_select_section opt-select-box">
					<div class="box-btn-buy wrap-btn-buy">
						<div class="btn_buy">
							<a class="btn_grey" href="javascript:OrderClick()" style="color:black;">바로 구매하기</a>
						</div>
						<div class="btn_sell">
							<a class="btn_grey" href="javascript:ResellClick()" style="color:black;">판매 하기</a>
						</div>
						<div class="btn_cart">
							<form id="addToCartForm" name="addToCartForm" method = "post" action="BoardServlet?command=cart_insert&product_number=${productVO.product_number}">
								<input type="hidden" name="cart_quantity" value="1" />
								<input type="hidden" name="product_name" value="${productVO.product_name}" />
								<a class="btn_grey" href='javascript:CartClick()'>쇼핑백</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<table class="columns" style="margin-left: 300px">
		<tr>
			<td>
				<div id="columnchart_div" style="border: 1px solid #ccc"></div>
			</td>
		</tr>
	</table>


	<div id="id01" class="modal" style="margin-left: 20%; margin-top: 5%; border-radius: 6px; border: solid 2px grey;">
		<span onclick="document.getElementById('id01').style.display='none'" class="close"
			title="Close Modal">&times;</span>
		<form class="modal-content" action="BoardServlet?command=order" method="post">
			<div class="container" style="text-align: center;">
				<p>받는사람 : <input type="text" style="width:auto; text-align:center;" name="receiver_name"
						value="${OrderVO.receiver_name}" /></p>
				<p>전화번호 : <input type="text" style="width:auto; text-align:center;" name="receiver_phone"
						value="${OrderVO.receiver_phone}" /></p>
				<p>주소 : <input type="text" style="width:600px; text-align:center;" name="address"
						value="${OrderVO.address}" /></p>
				<input type="hidden" name="product_number" value="${productVO.product_number}" />
				<p>제품 이름 : <input type="text" style="width:auto; text-align:center;" name="product_name"
						value="${productVO.product_name}" readonly="readonly" /></p>
				<p>최종 결제가격 : <input type="text" style="width:auto; text-align:center;" name="total_price"
						value="${productVO.product_price}" readonly="readonly" /></p>
				<input type="hidden" name="product_price" value="${productVO.product_price}" />
				<p>수량 : <input type="text" style="width:auto; text-align:center;" name="product_quantity" title="수량"
						value="1" class="mr0" readonly="readonly"></p>
				<p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
				<div class="clearfix" style="display: inline-flex; justify-content: center;">
					<button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn"
						style="margin-right:20px;">취소하기</button>
					<button type="submit" class="signupbtn">구매하기</button>
				</div>
			</div>
		</form>
	</div>
	
	<div id="id02" class="modal" style="margin-left: 20%; margin-top: 5%; border-radius: 6px; border: solid 2px grey;">
		<span onclick="document.getElementById('id02').style.display='none'" class="close"
			title="Close Modal">&times;</span>
		<form class="modal-content" action="BoardServlet?command=regist_resell" method="post">
			<div class="container" style="text-align: center;">
				<h2>Resell 등록 정보 확인</h2>
				<p>유저아이디 : <input type="text" style="width:auto; text-align:center;" name="user_id"
						value="${user_id}" /></p>
				<input type="hidden" name="product_number" value="${productVO.product_number}" />
				<input type="hidden" name="product_image" value="${productVO.product_image}" />
				<p>제품 이름 : <input type="text" style="width:auto; text-align:center;" name="product_name"
						value="${productVO.product_name}" readonly="readonly" /></p>
				<p>희망가 : <input type="text" style="width:auto; text-align:center;" name="product_price"
						value="${productVO.product_price}" /></p>
				
				<p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
				<div class="clearfix" style="display: inline-flex; justify-content: center;">
					<button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn"
						style="margin-right:20px; width:200px;">취소하기</button>
					<button type="submit" class="signupbtn"style="width:200px;">판매등록하기</button>
				</div>
			</div>
		</form>
	</div>
	

	
</body>
<script>
// Get the modal
var modal = document.getElementById('id01');
var modal2 = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
  else if(event.target == modal2){
	  modal2.style.display = "none";
  }
}

function OrderClick(){
	document.getElementById('id01').style.display='block';
}
function ResellClick(){
	document.getElementById('id02').style.display='block';
}
function CartClick(){
	document.getElementById('addToCartForm').submit();
}
</script>
</html>






<%@ include file="../footer.jsp"%> 