package com.jspTest2.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.dao.CartDAO;

public class CartDeleteAction implements Action {
	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		  
	    String url = "BoardServlet?command=cart_list";
	    String[] cseqArr = request.getParameterValues("cseq");  
	     
	    //String cseq = request.getParameter("cseq").trim();
	    
//	    CartDAO cartDAO = CartDAO.getInstance();
//	    cartDAO.deleteCart(Integer.parseInt(cseq));
	    for(String cseq:cseqArr){ //�Ѱ� �̻��� ������ ��ٱ��Ͽ��� ����� ����
	      System.out.println(cseq);
	      CartDAO cartDAO = CartDAO.getInstance();
	      cartDAO.deleteCart(Integer.parseInt(cseq));
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	  }
}//end class