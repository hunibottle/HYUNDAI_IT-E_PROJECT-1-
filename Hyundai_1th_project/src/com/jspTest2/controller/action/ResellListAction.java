package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.ResellDAO;
import com.jspTest2.dto.ResellVO;

public class ResellListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "./mypage/ResellList.jsp";
		   
	    HttpSession session = request.getSession();
	    String user_id = (String) session.getAttribute("login.id");
	    if (user_id == null) {
	      url = "./user/Login.jsp";
	    } else {
	      ResellDAO resellDAO = ResellDAO.getInstance();
	      ArrayList<ResellVO> resellList = resellDAO.listResellProduct(user_id);
	      
	      request.setAttribute("ResellProductList", resellList);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}
}
