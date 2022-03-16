package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.dao.ProductDAO;
import com.jspTest2.dao.ResellDAO;
import com.jspTest2.dto.ProductVO;
import com.jspTest2.dto.ResellVO;


public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "./index.jsp";	    
	
	    ProductDAO productDAO = ProductDAO.getInstance();
	    ResellDAO resellDAO = ResellDAO.getInstance();
	    ArrayList<ResellVO> newResellProductList = resellDAO.listBestResellProduct();
	    ArrayList<ProductVO> newProductList = productDAO.listBestProduct();
	    request.setAttribute("ProductList", newProductList);
	    request.setAttribute("ResellProductList", newResellProductList);
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
