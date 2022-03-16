<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./css/cartlist.css">
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
function check(){
	var arr = document.querySelectorAll("input[name='cartlist']");
	var str = "";
	for (var i = 0; i < arr.length; i++) {
		var c = arr[i]; if (c.checked) {
			str += c.value + "<br>"; 
			} 
		} 
	document.getElementById('result').innerHTML = "<h1>" + str + "</h1>";
}

function go_cart_delete() {
	  var count = 0;
	  for ( var i = 0; i < document.list.cseq.length; i++) {
	    if (document.list.cseq[i].checked == true) {
	      count++;
	      }
	  }
	  
	  if (count == 0) {
	    alert("삭제할 항목을 선택해 주세요.");

	  } else {		 	
		 	document.list.action = "BoardServlet?command=cart_delete";
		    document.list.submit();
	  }
}


	function go_cart_order() {
		
		var count = 0;
		var csep_t = document.list.cseq;
		for (var i = 0; i < document.list.cseq.length; i++) {
			if (document.list.cseq[i].checked == true) {
				count++;
			}
		}

		if (count == 0) {
			alert("구매할 항목을 선택해 주세요.");

		} else {
			alert('배송받는 이름은\t' + $('input[name=receiver_name]').val() + '\n' + '전화번호는\t' + $('input[name=receiver_phone]').val() + '\n' + '집주소는\t' + $('input[name=address]').val());
			document.list.action = "BoardServlet?command=cart_list_order";
			document.list.submit();
		}
	}
</script>
<title>Insert title here</title>

</head>
<body>
	<input type="hidden"name = "receiver_name" value="${OrderVO.receiver_name}"/>
	<input type="hidden"name = "receiver_phone" value="${OrderVO.receiver_phone}"/>
	<input type="hidden"name = "address" value="${OrderVO.address}"/>
						      
	<div id="bodyWrap">
		<img class="logo" src="./images/biglogo.png"
			onClick="location.href='BoardServlet?command=index'">
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
								<caption>쇼핑백</caption>
								<colgroup>
									<col style="witdh: 10px;">
									<col style="witdh: 100px;">
									<col style="witdh: 105px;">
									<col style="witdh: 140px;">
									<col style="witdh: 110px;">
								</colgroup>
								<thead>
									<tr>
										<th scope="col"><input type="checkbox" id="entryCheckAll"
											value="cartlist"></th>
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
												<form method="post" action="example" name="list">
													<input type="checkbox" name="cseq" value="${cartVO.cseq}">
											</td>
											<td class="pt_list_wrap">
												<div class="pt_list_all">
													<div class="tit_wrap">
														<span class="tlt">${cartVO.product_name}</span> <br>
														<span class="sb_tlt"> </span>
													</div>
												</div>
											</td>
											<td class="al_middle"><span class="qty_sel num">
													<input id="quantity" name="quantity" type="text"
													value="${cartVO.quantity }">
											</span></td>
											<td class="al_middle">
												<div class="price_wrap">
													<span>${cartVO.product_price}</span>

												</div>
											</td>
											<td class="al_middle">
												<div class="btn_wrap">
													<a class="btn wt_ss"
														onclick="location.href='BoardServlet?command=cart_delete&cseq=${cartVO.cseq}'">삭제</a>
												</div>

											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="total_wrap">
							<div class="total_price_wrap">
								<dl class="total">
									<dt>합계</dt>
									<dd>${totalPrice}</dd>
								</dl>
							</div>
							
						</div>
						<div class="brnwrap order" id="chechout_btn_wrap"
							style="text-align: center; margin-top: 30px"">

							<a href="#" onclick="go_cart_delete()"> <input value="선택상품삭제"
								class="btn wt" type="button">
							</a> <a href="#" onclick="go_cart_order()"> <input value="주문하기"
								class="btn gray mr0" type="button">
							</a>
						</div>
					</div>
				</form>
			</div>
		</span>
	</div>
	
</body>

</html>