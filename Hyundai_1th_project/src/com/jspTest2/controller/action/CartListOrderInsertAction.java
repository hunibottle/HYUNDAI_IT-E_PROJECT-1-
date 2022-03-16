package com.jspTest2.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.OrderDAO;
import com.jspTest2.dto.OrderVO;

public class CartListOrderInsertAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result = 1;
		String url = "BoardServlet?command=order_list";
		String fail_url = "BoardServlet?command=index";
		String[] cseqArr = request.getParameterValues("cseq");
		
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("login.id");
		OrderDAO orderDAO = OrderDAO.getInstance();
		OrderVO orderVO = new OrderVO();
		for (String cseq : cseqArr) { 
			System.out.println(cseq);
			OrderVO orderpVO = new OrderVO();
			OrderVO ordermVO = new OrderVO();
			orderpVO = orderDAO.getProductForOrder(Integer.parseInt(cseq));
			ordermVO = orderDAO.getMemberForOrder(user_id);
			orderVO.setAddress(ordermVO.getAddress());
			orderVO.setUser_id(user_id);
			orderVO.setProduct_name(orderpVO.getProduct_name());
			orderVO.setProduct_number(orderpVO.getProduct_number());
			orderVO.setProduct_price(orderpVO.getProduct_price());
			orderVO.setProduct_quantity(orderpVO.getProduct_quantity());
			orderVO.setReceiver_name(ordermVO.getReceiver_name());
			orderVO.setReceiver_phone(ordermVO.getReceiver_phone());
			result = orderDAO.insertOrder(orderVO);
		}

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
