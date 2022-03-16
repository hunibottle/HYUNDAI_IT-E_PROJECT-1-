package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.CartDAO;
import com.jspTest2.dao.OrderDAO;
import com.jspTest2.dto.CartVO;
import com.jspTest2.dto.MemberVO;
import com.jspTest2.dto.OrderVO;

public class CartListAction implements Action {
	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		  String url = "./cart/CartList.jsp";
	   
	    HttpSession session = request.getSession();
	    System.out.println(session+"CartlistAction");
	    String user_id = (String) session.getAttribute("login.id");
	    System.out.println(user_id+"list");
	    if (user_id == null) {
	      url = "./user/Login.jsp";
	    } else {
	      CartDAO cartDAO = CartDAO.getInstance();
	      OrderDAO orderDAO = OrderDAO.getInstance();
	      ArrayList<CartVO> cartList = cartDAO.listCart(user_id);
	      OrderVO orderVO = orderDAO.getMemberForOrder(user_id);
	      int totalPrice = 0;
	      for (CartVO cartVO : cartList) {
	    	  System.out.println(cartVO.getCseq());
	        totalPrice += cartVO.getProduct_price() * cartVO.getQuantity();
	      }
	      request.setAttribute("OrderVO", orderVO);
	      request.setAttribute("cartList", cartList);
	      request.setAttribute("totalPrice", totalPrice);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	  }
	}//end class