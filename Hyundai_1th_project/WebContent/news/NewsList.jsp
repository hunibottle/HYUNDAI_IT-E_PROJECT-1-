<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>

<html>
<link rel="stylesheet" href="./css/newsList.css">
<body>
	<div id="contents" class="container" style="padding-top: 87px;">
		<div class="page-body-wrapper">
			<div class="hs-row box">
				<ol class="breadcrumb col-r">
					<li class="breadcrumb-item"><a
						href="BoardServlet?command=index">HOME</a>
					<li class="breadcrumb-item"><a href="#">MEDIA</a></li>
					<li class="breadcrumb-item"><a href="#">News</a></li>
				</ol>
			</div>
			<h2 class="hs-row tit_page tit-bg-none">
				<span>News</span>
			</h2>
			<div class="section box topBr">
				<form id="listForm" name="listForm" method="get">
					<input type="hidden" name="pageIndex" id="pageIndex" value="1">
					<input type="hidden" name="idEnc">
					<div id="brandList" class="box">

						<div class="imgBoard_length">
							전체 <span class="emp">23</span> 개
						</div>

						<div class="imgBoard_list news">
							<table>
								<tbody>
									<tr>
										<c:forEach items="${newsList}" var="newsVO">
											<td>

												<div onClick="location.href='./news/NewsDetail.jsp'">
													<img src="./images/${newsVO.newsimage}" alt=""
														style="width: 440px; height: 270px;">
													<p class="display-b news_tit">${newsVO.newstitle}</p>
													<p class="news_data">2022.03.12</p>
												</div>
											</td>
											<td>
												<div>
													<img src="./images/${newsVO.newsimage}" alt=""
														style="width: 440px; height: 270px;">
													<p class="display-b news_tit">${newsVO.newstitle}</p>
													<p class="news_data">2022.03.12</p>
												</div>
											</td>
											<td>
												<div>
													<img src="./images/${newsVO.newsimage}" alt=""
														style="width: 440px; height: 270px;">
													<p class="display-b news_tit">${newsVO.newstitle}</p>
													<p class="news_data">2022.03.12</p>
												</div>
											</td>
										</c:forEach>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>

<%@ include file="../footer.jsp"%>