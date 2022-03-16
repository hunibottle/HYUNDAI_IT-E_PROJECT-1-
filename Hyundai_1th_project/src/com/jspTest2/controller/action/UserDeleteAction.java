package com.jspTest2.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.MemberDAO;
import com.jspTest2.dto.MemberVO;

public class UserDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		System.out.println("user delete!");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		HttpSession session = request.getSession();
		session.getAttribute("login.id");
		
        String user_id = (String) session.getAttribute("login.id"); 
		String user_pwd = (String)request.getParameter("user_pwd"); 
		PrintWriter out = response.getWriter();
		
		System.out.println( "id : " + user_id +user_id.getClass().getName()+"data type"); 
		System.out.println( "pwd : " + user_pwd + user_pwd.getClass().getName()+"data type");
		
		MemberDAO memberDAO =  new MemberDAO();		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setUser_id(user_id);
		memberVO.setUser_pwd(user_pwd);
		result = memberDAO.deleteMember(memberVO);
		
		if(result == 1) {
			session.invalidate();
			out.println("<script>alert('성공.');location.href='http://localhost:8080/Hyundai_1th_project/index.jsp';</script>");
			//response.sendRedirect("index.jsp");
			
		}else {
			
			out.println("<script>alert('실패');location.href='http://localhost:8080/Hyundai_1th_project/user/UserDelete.jsp';</script>");
			
		
		}
//		
//
//	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//	    dispatcher.forward(request, response);
	}
		       
	

}
