package com.jspTest2.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//confirmpwd for update & delete
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.MemberDAO;
import com.jspTest2.dto.MemberVO;

public class ConfirmPwdAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;
		System.out.println( "confirmpwd");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		session.getAttribute("login.id");
		
        String user_id = (String) session.getAttribute("login.id"); //
		String user_pwd = (String)request.getParameter("user_pwd"); //
		PrintWriter out = response.getWriter();
		
		System.out.println( "id : " + user_id +user_id.getClass().getName()+"data type"); 
		System.out.println( "pwd : " + user_pwd + user_pwd.getClass().getName()+"data type");
		
		
		MemberDAO dao = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_pwd(user_pwd);
		memberVO.setUser_id(user_id);
		
		result = dao.confiremPwd(memberVO); 
		
		System.out.println("result : "+ result);
		if(result) {
			out.println("<script>alert('성공.');location.href='http://localhost:8080/Hyundai_1th_project/user/UserUpdate.jsp';</script>");
			
			
		}
		else {
			out.println("<script>alert('실패. ');location.href='http://localhost:8080/Hyundai_1th_project/user/MyPage.jsp';</script>");
			
		}
			
	}

}
