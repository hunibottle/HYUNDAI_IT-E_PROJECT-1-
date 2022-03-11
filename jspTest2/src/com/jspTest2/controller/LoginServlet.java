package com.jspTest2.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.controller.action.Action;

@WebServlet("/login") // 로그인 매

public class LoginServlet extends HttpServlet {
	
	public void init() throws ServletException{
		 System.out.println("init 메서드 호출!!! ");
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			
			System.out.println("user_id : " + user_id);
			System.out.println("user_pw : " + user_pw);
			
		  }
		  
	      @Override
	      
	      public void destroy() {
	    	  
	    	  System.out.println("destroy 메서드 호출!!! ");
	      }

}
