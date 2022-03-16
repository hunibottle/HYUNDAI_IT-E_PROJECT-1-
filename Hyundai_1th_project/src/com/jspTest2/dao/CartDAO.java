package com.jspTest2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jspTest2.dto.CartVO;

import utill.DBManager;

public class CartDAO {
	
	  private Connection conn =null;
	  private PreparedStatement pstmt=null;
	  private ResultSet rs = null;
	
	  private CartDAO() {  } 
	  private static CartDAO instance = new CartDAO();
	  public static CartDAO getInstance() {
	    return instance;
	  }
	  
	  public ArrayList<CartVO> listCart(String user_id) {
		    ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		    
		    String sql = "select * from cart_view where user_id=? order by cseq desc";
		    
		    try {
		      conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, user_id);
		      rs = pstmt.executeQuery();
		      while (rs.next()) { 
		        CartVO cartVO = new CartVO();
		        cartVO.setCseq(rs.getInt(1));
		        cartVO.setUser_id(rs.getString(2));
		        cartVO.setProduct_name(rs.getString(4));
		        cartVO.setQuantity(rs.getInt(5));
		        cartVO.setProduct_price(rs.getInt(6));
		        cartList.add(cartVO);
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }finally {
		      DBManager.close(conn, pstmt, rs);
		    }
		    return cartList;
	  }
	  
	  
	  
	  public void insertCart(CartVO cartVO) {
		    String sql = "insert into cart(cseq, user_id, product_number, quantity)"
		    		+ "values(cart_seq.nextval, ? ,?, ?)";
		    try {
		    	  String user_id = cartVO.getUser_id();
		    	  int product_number = cartVO.getProduct_number();
		    	  int quantity = cartVO.getQuantity();
		    	  
		    	  conn = DBManager.getConnection();
			      pstmt = conn.prepareStatement(sql);
			      System.out.println(user_id);
			      pstmt.setString(1, user_id);
			      pstmt.setInt(2, product_number);
			      pstmt.setInt(3, quantity);
			      pstmt.executeUpdate();
			    } catch (Exception e) {
			      e.printStackTrace();
			    } finally {
			      DBManager.close(conn, pstmt);
			    }
			  }
	  
	  public void deleteCart(int cseq) {
		    System.out.println(cseq);
		    String sql = "delete cart where cseq=?";	    
		    Connection conn = null;
		    PreparedStatement pstmt = null;	  
		    try {
		      conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setInt(1, cseq);
		      pstmt.executeUpdate();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(conn, pstmt);
		    }
	  }

}
