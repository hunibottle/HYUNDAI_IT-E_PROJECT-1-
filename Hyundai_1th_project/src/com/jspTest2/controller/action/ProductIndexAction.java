package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.dao.ProductDAO;
import com.jspTest2.dto.ProductVO;

public class ProductIndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "product/SneakersBoard.jsp";
		String category_code=request.getParameter("category_code");
		int index=	Integer.parseInt(request.getParameter("index"));
	    ProductDAO productDAO = ProductDAO.getInstance();
	    ArrayList<ProductVO> newProductList = productDAO.listProductByIndex(index, category_code);
	    request.setAttribute("ProductList", newProductList); 
	    if(category_code=="1") {
	    	request.setAttribute("title", "Sneaker"); 
	    }
	    else if(category_code=="2") {
	    	request.setAttribute("title", "Cloth"); 
	    }
	    else if(category_code=="3") {
	    	request.setAttribute("title", "Beauty"); 
	    }
	    else {
	    	request.setAttribute("title", "Eletronic"); 
	    }
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}
}
