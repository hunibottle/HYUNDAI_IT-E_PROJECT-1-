package com.jspTest2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utill.DBManager;
import com.jspTest2.dto.BoardVO;
import com.jspTest2.dto.ProductVO;

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
	  
public ArrayList<ProductVO> listProduct(){
		
		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		String sql = "select * from Product where product_number=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 ProductVO product = new ProductVO();
		    	 product.setProduct_name(rs.getString("product_name"));
		    	 product.setProduct_price(rs.getInt("product_price"));
		    	 product.setProduct_stock(rs.getInt("product_stock"));
		    	 product.setProduct_hits(rs.getInt("product_hits"));
		    	 product.setProduct_name(rs.getString("product_image"));
		    	 productlist.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productlist;
	}


	  
	

}
