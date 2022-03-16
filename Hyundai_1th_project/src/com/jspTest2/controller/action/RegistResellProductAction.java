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
import com.jspTest2.dao.ResellDAO;
import com.jspTest2.dto.OrderVO;
import com.jspTest2.dto.ResellVO;

public class RegistResellProductAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "BoardServlet?command=resell_list";
		   
	    HttpSession session = request.getSession();
	    String user_id = (String) session.getAttribute("login.id");
	    String product_number = request.getParameter("product_number");
	    String fail_url = "BoardServlet?command=product_detail&product_number="+product_number;
	    
	    if (user_id == null) {
	      url = "/user/login";
	    } else 
	    {
	      ResellDAO resellDAO = ResellDAO.getInstance();
	      ResellVO resellVO = new ResellVO();
	      resellVO.setProduct_number(Integer.parseInt(request.getParameter("product_number")));
	      resellVO.setProduct_name(request.getParameter("product_name"));
	      resellVO.setUser_id(user_id);
	      resellVO.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
	      resellVO.setProduct_image(request.getParameter("product_image"));
	      int result = resellDAO.ResellProduct(resellVO);
	      if(result == 1) {
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('판매등록했습니다.');</script>"); 
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				writer.close();
			}
			else {
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('판매등록실패했습니다.'); location.href='"+fail_url+"';</script>"); 
				writer.close();
			}
	      
	    }

	}

}
