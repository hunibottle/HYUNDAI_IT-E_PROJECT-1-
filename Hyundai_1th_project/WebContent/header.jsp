<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href ="./css/header2.css">
<link rel="stylesheet" href ="../images/logo.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="navbar">
	<img class="logo" src="http://localhost:8080/Hyundai_1th_project/images/logo.png"  style="cursor:pointer;"onClick="location.href='http://localhost:8080/Hyundai_1th_project/'">
     <div class="dropdown">
    <button class="dropbtn">COMPANY 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <div class="header">
        <h2>Mega Menu1</h2>
      </div>   
      <div class="row">
        <div class="column">
          <h3>Category 1</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 2</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 3</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
      </div>
    </div>
  </div> 
   <div class="dropdown">
    <button class="dropbtn">BRAND 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <div class="header">
        <h2>Mega Menu2</h2>
      </div>   
      <div class="row">
        <div class="column">
          <h3>Category 1</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 2</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 3</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
      </div>
    </div>
  </div> 
   <div class="dropdown">
    <button class="dropbtn">MEDIA
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <div class="header">
        <h2>Mega Menu3</h2>
      </div>   
      <div class="row">
        <div class="column">
          <h3>Category 1</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 2</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 3</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
      </div>
    </div>
  </div>
   <div class="dropdown">
    <button class="dropbtn" onclick="location.href='BoardServlet?command=newsList'">NEWS
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <div class="header">
        <h2>Mega Menu4</h2>
      </div>   
      <div class="row">
        <div class="column">
          <h3>Category 1</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 2</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 3</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
      </div>
    </div>
  </div>
    <div class="dropdown">
    <button class="dropbtn">SUSTAIBILITY
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <div class="header">
        <h2>Mega Menu5</h2>
      </div>   
      <div class="row">
        <div class="column">
          <h3>Category 1</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 2</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
        <div class="column">
          <h3>Category 3</h3>
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
        </div>
      </div>
    </div>
  </div> 
</div>
    <div class="dropdown">
          <%
            String user_id = (String)session.getAttribute("login.id");
         %>
         <%if (user_id != null) { %>
         
         
            <button class="dropbtn"  onclick="location='http://localhost:8080/Hyundai_1th_project/BoardServlet?command=logout'">LOGOUT</button>
            <i class="fa fa-caret-down"></i>
            <button class="dropbtn"  onclick="location.href='mypage.jsp'">MYPAGE</button>
            <i class="fa fa-caret-down"></i>
            <button class="dropbtn"  onclick="location.href='sell.jsp'">SEll</button>
            <i class="fa fa-caret-down"></i>
            <a> <%=user_id%>님 반갑습니다</a>
         <%}else { %> 
            <button class="dropbtn"  onclick="location.href='http://localhost:8080/Hyundai_1th_project/user/Login.jsp'">LOGIN</button>
             <i class="fa fa-caret-down"></i>
         <%}%>
         
     </div>     
</body>
</html>



<%@ include file="../footer.jsp"%>