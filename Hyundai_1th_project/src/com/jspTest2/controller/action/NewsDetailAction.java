package com.jspTest2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.dao.NewsListDAO;

import com.jspTest2.dto.NewsListVO;


public class NewsDetailAction implements Action {
	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		  
	    String url="./News/newsDetail.jsp";
	    String newsnumber = request.getParameter("newsnumber").trim();  
	    
	    NewsListDAO newslistDAO = NewsListDAO.getInstance();
	    NewsListVO newslistVO= newslistDAO.getNews(newsnumber);    
	    
	    request.setAttribute("newslistVO", newslistVO);    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	  }
}//end class