<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href ="./css/header2.css">
<link rel="stylesheet" href ="../images/logo.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>한섬 x stockH</title>
</head>
<body>


 
<div class="navbar">
	<img class="logo" src="http://localhost:8080/Hyundai_1th_project/images/logo.png"  style="cursor:pointer;"onClick="location.href='http://localhost:8080/Hyundai_1th_project/'">
  
  
   <div class="dropdown">
    <button class="dropbtn">READY_TO_STOCK 
      <i class="fa fa-caret-down"></i>
    </button>
  </div> 
  
   <div class="dropdown">
    <button class="dropbtn" onclick="location.href='BoardServlet?command=product&index=1'">SHOPPING
      <i class="fa fa-caret-down"></i>
    </button>
  </div>
  
  
   <div class="dropdown">
    <button class="dropbtn" onclick="location.href='BoardServlet?command=newsList'">NEWS
      <i class="fa fa-caret-down"></i>
    </button>
  </div>
  
   <div class="dropdown">
          <%
            String user_id = (String)session.getAttribute("login.id");
         %>
         <%if (user_id != null) { %>
            <button class="dropbtn"  onclick="location='http://localhost:8080/Hyundai_1th_project/BoardServlet?command=logout'">LOGOUT</button>
            <i class="fa fa-caret-down"></i>
            <button class="dropbtn"  onclick="location.href='./user/MyPage.jsp'">MYPAGE</button>
            <i class="fa fa-caret-down"></i>
            <button class="dropbtn"  onclick="location.href='http://localhost:8080/Hyundai_1th_project/BoardServlet?command=resell_list'">SEll</button>
            <i class="fa fa-caret-down"></i>
            <button class="dropbtn"  onclick="location.href='http://localhost:8080/Hyundai_1th_project/BoardServlet?command=cart_list'">CART</button>
            <i class="fa fa-caret-down"></i>
            <a> <%=user_id%>님 반갑습니다</a>
         <%}else { %> 
            <button class="dropbtn"  onclick="location.href='http://localhost:8080/Hyundai_1th_project/user/Login.jsp'">LOGIN</button>
             <i class="fa fa-caret-down"></i>
         <%}%>
         
     </div>      

</div>
   
</body>
</html>