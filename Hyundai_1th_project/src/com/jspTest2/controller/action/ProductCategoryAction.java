package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.dao.ProductDAO;
import com.jspTest2.dto.ProductVO;

public class ProductCategoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "product/SneakersBoard.jsp";
		String category_code=request.getParameter("category_code");
	    ProductDAO productDAO = ProductDAO.getInstance();
	    ArrayList<ProductVO> newProductList = productDAO.listProductByCategory(category_code);
	    request.setAttribute("ProductList", newProductList);
	    System.out.println(category_code.getClass().getName());
	    if(Integer.parseInt(category_code)==1) {
	    	request.setAttribute("title", "Sneaker"); 
	    }
	    else if(Integer.parseInt(category_code)==2) {
	    	request.setAttribute("title", "Cloth"); 
	    }
	    else if(Integer.parseInt(category_code)==3) {
	    	request.setAttribute("title", "Beauty"); 
	    }
	    else {
	    	request.setAttribute("title", "Eletronic"); 
	    }
	    
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}
}
