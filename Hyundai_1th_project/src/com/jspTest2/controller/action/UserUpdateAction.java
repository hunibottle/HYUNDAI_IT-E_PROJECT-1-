package com.jspTest2.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.MemberDAO;
import com.jspTest2.dto.MemberVO;

public class UserUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		session.getAttribute("login.id");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("user update!");
		int result = 0;
		
		PrintWriter out = response.getWriter();
		String user_id = (String) session.getAttribute("login.id");
		String user_pwd = request.getParameter("user_pwd"); 
		String user_name = request.getParameter("user_name");
		String user_phone = request.getParameter("user_phone");
		String user_email = request.getParameter("user_email");
		
		MemberDAO memberDAO =  new MemberDAO();		
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_id(user_id);
		memberVO.setUser_pwd(user_pwd);
		memberVO.setUser_name(user_name);
		memberVO.setUser_phone(user_phone);
		memberVO.setUser_email(user_email);
		
		result = memberDAO.modMember(memberVO);
		
		
		if(result == 1) {
			session.invalidate();
			out.println("<script>alert('성공.');location.href='http://localhost:8080/Hyundai_1th_project/index.jsp';</script>");
			//response.sendRedirect("index.jsp");
			
		}else {
			
			out.println("<script>alert('실패.');location.href='http://localhost:8080/Hyundai_1th_project/user/UserUpdate.jsp';</script>");
				
		}
		
	}

}
