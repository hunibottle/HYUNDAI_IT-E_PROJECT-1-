<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href ="./css/cartlist.css">
<link rel="stylesheet" href ="../images/shoes1.jpg">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session = request.getSession();
%>
<div id="bodyWrap">
	<img class="logo" src="./images/biglogo.png"  onClick="location.href='BoardServlet?command=index'">	
	<h3 class="cnts_title cnts_tlt1807">
		<span>쇼핑백</span>
	</h3>
	<span id="shoppingbagCartView">
		<div class="sub_container">
			<div class="shopping_cart_tab1807 tab_a">
				<!-- <li>
					<span class="delt_ico"></span>"택배"
				</li> -->
			</div>
			<div class="orderwrap1807">
				<div class="tbl_info_wrap">
					<p class="cart_top_text"></p>
					<div class="fourpm_pd_ck">
						<div class="input_wrap"></div>
					</div>
				</div>
				<div class="tblwrap">
					<table class="tbl_ltype">
						<caption>쇼핑백</caption>
							<colgroup>
								<col style="witdh: 10px;">
								<col>
								<col style="witdh: 120px;">
								<col style="witdh: 105px;">
								<col style="witdh: 140px;">
								<col style="witdh: 110px;">
							</colgroup>
							<thead>
								<tr>
									<th scope="col">
										<input type="checkbox" id="entryCheckAll" value="cartlist">
									</th>
									<th scope="col">상품정보</th>
									<th scope="col">수량</th>
									<th scope="col">판매가</th>
									<th scope="col">선택</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${cartList}" var="cartVO">
								<tr name="entryProductInfo">
									<td class="frt">
										<input type="checkbox" name="cartlist">
									</td>
									<td class="pt_list_wrap">
										<div class="pt_list_all">
											<img src="./images/shoes1.jpg" alt="">
											<div class="tit_wrap">
											<span class="tlt">${cartVO.product_name}</span>
											<br>
											<span class="sb_tlt">
										
											</span>
										</div>
										</div>
									</td>
									<td class="al_middle">
										<span class="qty_sel num">
											<input id="quantity" name="quantity" type="text" value="1">
										</span>
									</td>
									<td class="al_middle">
										<div class="price_wrap">
											<span>${cartVO.product_price}</span>
										</div>
									</td>
									<td class= "al_middle">
										<div class="btn_wrap">
											<a class="btn wt_ss" onclick="location.href='BoardServlet?command=cart_delete&cseq=${cartVO.cseq}'">삭제</a>
										</div>
									</td>
								</tr>
								</c:forEach>
							</tbody>
					</table>
				</div>
				<div class="total_wrap">
					<div class ="total_price_wrap">
						<dl>
							<dt>상품 합계</dt>
							<dd>
								<span id="cartDataSubtotal">₩0</span>
							</dd>
						</dl>
						<dl class="total">
							<dt>합계</dt>
							<dd>
								<span id="cartDataTotalPrice">₩0</span>
							</dd>
						</dl>
					</div>
					<div class="total_count1807">
						<p>
							"총 "
							<span id="selectProductCount">1</span>
							"개 상품"
						</p>
					</div>
				</div>
				<div class="brnwrap order" id="chechout_btn_wrap" style="text-align: center; margin-top: 30px"">
					<a href="#" onclick="selectRemove();">
						<input value="선택상품삭제" class="btn wt" type="button">
					</a>
					<a href="#" onclick="checkoutPage();">
						<input value="주문하기" class="btn gray mr0" type="button">
					</a>
				</div>
			</div>
		</div>
	</span>
</div>

<script type="text/javascript">
function checkoutPage(){
	
	
}

</script>
</body>
</html>