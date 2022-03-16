package com.jspTest2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspTest2.dao.MemberDAO;
import com.jspTest2.dto.MemberVO;
@WebServlet("/user/login") //
public class LoginServlet <script> extends HttpServlet {
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
		
		System.out.println("");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd"); 
		PrintWriter out = response.getWriter();
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_id(user_id);
		memberVO.setUser_pwd(user_pwd);
		
		
		MemberDAO dao = new MemberDAO();
		boolean result = dao.isExisted(memberVO); 
		
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon",true); 
			session.setAttribute("login.id",user_id);
			session.setAttribute("login.pwd",user_pwd);
			out.print(" "+user_id);
			out.println("<script>alert('o');</script>");
			
			response.sendRedirect("http://localhost:8080/Hyundai_1th_project/BoardServlet?command=index");
		    return;
		   
		} else {
			out.println("<script>alert('.'); location.href='http://localhost:8080/Hyundai_1th_project/user/Login.jsp';</script>");
			//out.println("<script> alert(' '); </script>");
			//response.sendRedirect("login.jsp");
		}
	}
		
		
}