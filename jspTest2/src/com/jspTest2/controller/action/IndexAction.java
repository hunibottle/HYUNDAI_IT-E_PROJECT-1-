package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.dao.BoardDAO;
import com.jspTest2.dao.ProductDAO;
import com.jspTest2.dto.BoardVO;
import com.jspTest2.dto.ProductVO;


public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/index.jsp";	    
	    BoardDAO boardDAO = BoardDAO.getInstance();
	    ArrayList<BoardVO> newBoardList = boardDAO.listBoard();
	    
	    request.setAttribute("BoardList", newBoardList);
	    
	    ProductDAO productDAO = ProductDAO.getInstance();
	    ArrayList<ProductVO> newProductList = productDAO.listProduct();
	    
	    request.setAttribute("ProductList", newProductList);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
