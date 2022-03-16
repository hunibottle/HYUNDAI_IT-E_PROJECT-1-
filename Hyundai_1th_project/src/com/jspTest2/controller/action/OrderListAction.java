package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.OrderDAO;
import com.jspTest2.dto.OrderVO;

public class OrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "./mypage/OrderList.jsp";
		   
	    HttpSession session = request.getSession();
	    System.out.println(session+"OrderListAction");
	    String user_id = (String) session.getAttribute("login.id");
	    System.out.println(user_id+"list");
	    if (user_id == null) {
	      url = "/user/login";
	    } else {
	    	OrderDAO orderDAO = OrderDAO.getInstance();
	      ArrayList<OrderVO> orderList = orderDAO.listOrder(user_id);
	      request.setAttribute("orderList", orderList);
	    }
	    request.getRequestDispatcher(url).forward(request, response);

	}

}
