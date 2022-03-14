
package com.jspTest2.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.*;
import com.jspTest2.dto.*;

@WebServlet("/user/signup") // 

public class SignupServlet<script> extends HttpServlet {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);	
	}
	// get post 
	protected void doHandle(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println(" signup !");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd"); //
		String user_name = request.getParameter("user_name");
		String user_phone = request.getParameter("user_phone");
		String user_email = request.getParameter("user_email");
		PrintWriter out = response.getWriter();
		
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();

		vo.setUser_id(user_id);
		vo.setUser_pwd(user_pwd);
		vo.setUser_name(user_name);
		vo.setUser_email(user_email);
		vo.setUser_phone(user_phone);
		int n = dao.addMember(vo);
		boolean result = false;
		if (n == 1) {
			
			result = true;
		}
		else {
			result = false;
		}
		
		if (result) {
			out.print("!! "+user_id);
			out.println("<script>alert('.'); location.href='http://localhost:8080/Hyundai_1th_project/BoardServlet?command=index';</script>");
			
			//response.sendRedirect("./header.jsp");
		    return;
		   
		} else {
			out.println("<script>alert(''); location.href='http://localhost:8080/Hyundai_1th_project/user/Signup.jsp';</script>");
			
		}
	}
		
		
}

