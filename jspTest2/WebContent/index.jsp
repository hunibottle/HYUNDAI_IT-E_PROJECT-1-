<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  


  <div id="front">   
    <h2> New Item</h2>     
    <div id="bestProduct">         
      <c:forEach items="${BoardList}"  var="BoardVO">
        <div id="item">
        	
            <p>${BoardVO.shoesID}</p>
            <h3> ${BoardVO.shoesName} </h3>    
            <p>${BoardVO.shoesValue} </p>
        </div>
      </c:forEach>      
    </div>
   <div class="clear"></div>
  <!-- 
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>This is main page.<h1>
	
</body>
</html>
   --->
<%@ include file="../footer.jsp" %>    