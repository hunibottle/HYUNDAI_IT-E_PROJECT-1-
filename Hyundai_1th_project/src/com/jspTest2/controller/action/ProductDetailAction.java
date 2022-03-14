package com.jspTest2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.dao.ProductDAO;
import com.jspTest2.dto.ProductVO;

public class ProductDetailAction implements Action {
	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		  
	    String url="./product/ProductDetail.jsp";
	    String product_number = request.getParameter("product_number").trim();  
	    
	    ProductDAO productDAO=ProductDAO.getInstance();
	    ProductVO productVO= productDAO.getProduct(product_number);    
	    
	    request.setAttribute("productVO", productVO);    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	  }
}//end class