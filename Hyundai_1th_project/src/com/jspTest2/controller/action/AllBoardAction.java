package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.dao.ProductDAO;
import com.jspTest2.dto.ProductVO;

public class AllBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "product/AllProductBoard.jsp";
	    ProductDAO productDAO = ProductDAO.getInstance();
	    int index= Integer.parseInt(request.getParameter("index"));
	    ArrayList<ProductVO> newProductList = productDAO.listProductByIndex(index);
	    request.setAttribute("ProductList", newProductList); 
	    request.setAttribute("index", index); 
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
