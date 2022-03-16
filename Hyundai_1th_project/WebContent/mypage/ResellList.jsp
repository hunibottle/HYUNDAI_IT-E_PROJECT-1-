<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href ="./css/orderlist.css">
<link rel="stylesheet" href ="http://localhost:8080/Hyundai_1th_project/images/biglogo.png">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 구매번호, 이름, 가격, 날짜 -->

<%
	session = request.getSession();
%>

<div id="bodyWrap">
	<img class="logo" src="./images/biglogo.png" style="cursor:pointer;" onClick="location.href='http://localhost:8080/Hyundai_1th_project/'">	
        <h3 class="cnts_title"><!-- <span  style =" padding-right: 10px;">마이페이지</span> --></h3>
	<h3 class="cnts_title cnts_tlt1807">
		<span>Resell 희망 내역</span>
	</h3>
	<span id="shoppingbagCartView">
		<div class="sub_container">
			<div class="shopping_cart_tab1807 tab_a">
			
			</div>
			<form method="post" name="list">
			<div class="orderwrap1807">
				<div class="tbl_info_wrap">
					<p class="cart_top_text"></p>
					<div class="fourpm_pd_ck">
						<div class="input_wrap"></div>
					</div>
				</div>
				<div class="tblwrap">
					<table class="tbl_ltype">
							<colgroup>
								<col style="witdh: 80px">
								<col style="witdh: 105px;">
								<col style="witdh: 100px;">
							</colgroup>
							<thead>
								<tr>
									<th scope="col">판매 번호</th>
									<th scope="col">상품이름</th>
									<th scope="col">희망판매가</th>
								
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${ResellProductList}" var="ResellVO">
								<tr name="entryProductInfo">
									
									<td class="al_middle">
										<span class="sb_tlt">
											${ResellVO.resell_number}
										</span>
									</td>
									<td class="pt_list_wrap">
										<div class="pt_list_all">
											
											<div class="tit_wrap">
											<span class="tlt">${ResellVO.product_name}</span>
										</div>
										</div>
									</td>
									<td class="al_middle">
										<div class="price_wrap">
											<span>₩${ResellVO.product_price}</span>
											
										</div>
									</td>
									
								</tr>
								</c:forEach>
							</tbody>
					</table>
				</div>
				<!-- <div class="total_wrap">
					<div class ="total_price_wrap">
						<dl class="total">
							<dd>
								₩300,000원
							</dd>
						</dl>
					</div>
				</div> --><!-- 
				<div class="brnwrap order" id="chechout_btn_wrap" style="text-align: center; margin-top: 30px"">
					
						<a href="#" onclick="go_cart_delete()">
							<input value="선택상품삭제" class="btn wt" type="button" >
						</a>
					
					<a href="#" onclick="#">
						<input value="주문하기" class="btn gray mr0" type="button">
					</a>
				</div> -->
			</div>
			</form>
		</div>
	</span>
</div>
</body>

</body>
</html>