package com.jspTest2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jspTest2.dto.NewsListVO;

import utill.DBManager;

public class NewsListDAO {
	
	private NewsListDAO() { }
	private static NewsListDAO instance = new NewsListDAO();
	public static NewsListDAO getInstance() {
		return instance;
	}
	
	public ArrayList<NewsListVO> listNews(){
		
		ArrayList<NewsListVO> newsList = new ArrayList<NewsListVO>();
		String sql = "select newsnumber, newstitle, newscontent, newsimage from newslist";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 NewsListVO news = new NewsListVO();
				 news.setNewsnumber(rs.getString("newsnumber"));
				 news.setNewstitle(rs.getString("newstitle"));
				 news.setNewscontent(rs.getString("newscontent"));
				 news.setNewsimage(rs.getString("newsimage"));
				 newsList.add(news);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return newsList;
	}
	
}