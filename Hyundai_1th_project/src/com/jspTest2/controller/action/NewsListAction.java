package com.jspTest2.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspTest2.dao.NewsListDAO;
import com.jspTest2.dto.NewsListVO;


public class NewsListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "./news/NewsList.jsp";	    
	    NewsListDAO newslistDAO = NewsListDAO.getInstance();
	    ArrayList<NewsListVO> newsList = newslistDAO.listNews();
	    request.setAttribute("newsList", newsList);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
	
}
