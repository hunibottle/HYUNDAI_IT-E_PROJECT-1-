package com.jspTest2.controller.action;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LogoutAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>alert('.'); location.href='./index.jsp';</script>");
		String url = "/BoardServlet?command=index";	
		System.out.println("logout !");
		
		HttpSession session=request.getSession(false);
		    if(session!=null){
		      session.invalidate();

		    }        

		    request.getRequestDispatcher(url).forward(request, response);  
	  }
	
}