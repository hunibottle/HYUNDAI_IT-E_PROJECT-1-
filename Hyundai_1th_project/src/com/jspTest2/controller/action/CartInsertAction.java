package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.CartDAO;
import com.jspTest2.dto.CartVO;

public class CartInsertAction implements Action {
	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		  
	    String url = "BoardServlet?command=cart_list";    
	    HttpSession session = request.getSession();
	    System.out.println(session+"CartInsertAction");
	    
	    System.out.println(session);
	    String user_id= (String) session.getAttribute("login.id");
	    String product_number = request.getParameter("product_number").trim();
	    //int product_number = Integer.parseInt(request.getParameter("product_number"));
	    System.out.println(product_number);
	    String product_name = request.getParameter("product_name");
//	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    System.out.println("test");
	    String quantity = request.getParameter("quantity").trim();
	    System.out.println(quantity);
	    if (user_id == null) {
	      url = "/user/login"; //비회원인 경우
	    } else {
	    	 System.out.println("else 문 실행 !!" + user_id);
	    	 System.out.println(url);
	    	 
	      CartVO cartVO = new CartVO();
	     
	      cartVO.setUser_id(user_id);
	      System.out.println(cartVO.getUser_id());
	      cartVO.setProduct_number(Integer.parseInt(product_number));
	      cartVO.setProduct_name(product_name);
	      cartVO.setQuantity(Integer.parseInt(quantity));	      
	      
	      CartDAO cartDAO = CartDAO.getInstance();
	      System.out.println("insert test");
	      cartDAO.insertCart(cartVO);
	    }
	    response.sendRedirect(url);
	  }
	}//end class