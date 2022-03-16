package com.jspTest2.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.OrderDAO;
import com.jspTest2.dto.OrderVO;

public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "BoardServlet?command=order_list";
		int product_number = Integer.parseInt(request.getParameter("product_number"));
		String fail_url = "BoardServlet?command=product_detail="+product_number;
		HttpSession session = request.getSession();
		OrderDAO orderDAO = OrderDAO.getInstance();
		OrderVO orderVO = new OrderVO();
		orderVO.setAddress(request.getParameter("address"));
		orderVO.setReceiver_name(request.getParameter("receiver_name"));
		orderVO.setReceiver_phone(request.getParameter("receiver_phone"));
		orderVO.setUser_id((String) session.getAttribute("login.id"));
		orderVO.setProduct_number(Integer.parseInt(request.getParameter("product_number")));
		orderVO.setProduct_name(request.getParameter("product_name"));
		orderVO.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
		orderVO.setProduct_quantity(Integer.parseInt(request.getParameter("product_quantity")));
		int result = orderDAO.insertOrder(orderVO);
		if(result == 1) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = response.getWriter(); 
			writer.println("<script>alert('구매완료했습니다.'); location.href='"+url+"';</script>"); 
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
