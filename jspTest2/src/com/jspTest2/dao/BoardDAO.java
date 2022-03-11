package com.jspTest2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utill.DBManager;
import com.jspTest2.dto.BoardVO;

public class BoardDAO {
	private BoardDAO() {  } //ΩÃ±€≈œ √≥∏Æ
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public ArrayList<BoardVO> listBoard() {
		
		ArrayList<BoardVO> boardlist = new ArrayList<BoardVO>();
	    String sql = "select * from shoes_test";       
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;   
		try {
			 conn = DBManager.getConnection();
		     pstmt = conn.prepareStatement(sql);
		     rs = pstmt.executeQuery();
		     while(rs.next()) {
		    	 BoardVO board = new BoardVO();
		    	 board.setShoesID(rs.getInt("shoesID"));
		    	 board.setShoesName(rs.getString("shoesName"));
		    	 board.setShoesValue(rs.getInt("shoesValue"));
		    	 boardlist.add(board);
		     }
		}
		catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, pstmt, rs);
	    }
		return boardlist;
	}
	  
	  
	

}
