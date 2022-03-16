package com.jspTest2.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.OrderDAO;
import com.jspTest2.dto.OrderVO;

public class OrderInsertAction implements Action {
	// 주문하기
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "BoardServlet?command=order_list";
		int product_number = Integer.parseInt(request.getParameter("product_number"));
		String fail_url = "BoardServlet?command=product_detail&product_number="+product_number;
		HttpSession session = request.getSession();
	    String user_id = (String) session.getAttribute("login.id"); //login.id -> 세션에 저장된 유저id
		if (user_id == null) {
		      response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('로그인해주세요.'); location.href='"+fail_url+"';</script>"); 
				writer.close();
		} 
		else {
		    	OrderDAO orderDAO = OrderDAO.getInstance();
				OrderVO orderVO = new OrderVO();
				orderVO.setAddress(request.getParameter("address"));
				orderVO.setReceiver_name(request.getParameter("receiver_name"));
				orderVO.setReceiver_phone(request.getParameter("receiver_phone"));
				orderVO.setUser_id(user_id);
				orderVO.setProduct_number(Integer.parseInt(request.getParameter("product_number")));
				orderVO.setProduct_name(request.getParameter("product_name"));
				orderVO.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
				orderVO.setProduct_quantity(Integer.parseInt(request.getParameter("product_quantity")));
			
				int result = orderDAO.insertOrder(orderVO);
				
				if(result == 1) {
					response.setContentType("text/html; charset=UTF-8"); 
					PrintWriter writer = response.getWriter(); 
					writer.println("<script>alert('구매완료했습니다.');</script>"); 
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
					writer.close();
				}
				else {
					response.setContentType("text/html; charset=UTF-8"); 
					PrintWriter writer = response.getWriter(); 
					writer.println("<script>alert('구매실패했습니다.'); location.href='"+fail_url+"';</script>"); 
					writer.close();
				}
				
		  }
		 
		
		
	}

}
