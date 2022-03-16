package com.jspTest2.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.OrderDAO;
import com.jspTest2.dao.ProductDAO;
import com.jspTest2.dto.OrderVO;
import com.jspTest2.dto.ProductVO;

public class ProductDetailAction implements Action {
	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	    String url="./product/ProductDetail.jsp";
	    String product_number = request.getParameter("product_number").trim();  
	    System.out.println(product_number);
	    ProductDAO productDAO=ProductDAO.getInstance();
	    OrderDAO orderDAO = OrderDAO.getInstance();
	    ProductVO productVO= productDAO.getProduct(product_number);
	    request.setAttribute("productVO", productVO);  
	    HttpSession session = request.getSession();
	    String user_id = (String) session.getAttribute("login.id");
	    if (user_id != null) {
	    	OrderVO orderVO = orderDAO.getMemberForOrder(user_id);
	    	request.setAttribute("OrderVO", orderVO);
	    	request.setAttribute("user_id", user_id);
	    } 
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	  }
}//end class