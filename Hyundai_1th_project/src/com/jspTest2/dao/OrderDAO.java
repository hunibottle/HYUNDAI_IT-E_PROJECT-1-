package com.jspTest2.dao;

import java.util.ArrayList;

import com.jspTest2.dto.MemberVO;
import com.jspTest2.dto.OrderVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utill.DBManager;


public class OrderDAO {
	
	private Connection conn =null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	

	private OrderDAO() {  } 
	  private static OrderDAO instance = new OrderDAO();
	  public static OrderDAO getInstance() {
	    return instance;
	  }
	 
	  public ArrayList<OrderVO> listOrder(String user_id) {
		    ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		    
		    String sql = "select * from user_order where user_id=?";
		    
		    try {
		      conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, user_id);
		      rs = pstmt.executeQuery();
		      while (rs.next()) { 
		    	OrderVO orderVO = new OrderVO();
		    	orderVO.setOrder_number(rs.getInt("order_number"));
		    	orderVO.setOrder_date(rs.getDate("order_date"));
		    	orderVO.setProduct_name(rs.getString("product_name"));
		    	orderVO.setProduct_quantity(rs.getInt("product_quantity"));
		    	orderVO.setProduct_price(rs.getInt("product_price"));
		    	orderList.add(orderVO);
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }finally {
		      DBManager.close(conn, pstmt, rs);
		    }
		    return orderList;
	  }
	  
	  public OrderVO getMemberForOrder(String user_id) {
		  	OrderVO orderVO = new OrderVO();
			String query = "select  user_name, user_phone, user_address from user_address_view where user_id = ?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, user_id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
				orderVO.setReceiver_name(rs.getString("user_name"));
				orderVO.setReceiver_phone(rs.getString("user_phone"));
				orderVO.setAddress(rs.getString("user_address"));
				}
			}catch (Exception e) {
				
				e.printStackTrace();
				
			 }finally {
				 DBManager.close(conn, pstmt, rs);
			 } 
				 
			return orderVO;
		}
	  
	  public OrderVO getProductForOrder(int cseq) {
		  	OrderVO orderVO = new OrderVO();
			String query = "select  quantity, product_number, product_price, product_name from CART_PRODUCT_VIEW where cseq = ?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, cseq);
				rs = pstmt.executeQuery();
				while(rs.next()) {
				orderVO.setProduct_quantity(rs.getInt("quantity"));
				orderVO.setProduct_number(rs.getInt("product_number"));
				orderVO.setProduct_price(rs.getInt("product_price"));
				orderVO.setProduct_name(rs.getString("product_name"));
				}
			}catch (Exception e) {
				
				e.printStackTrace();
				
			 }finally {
				 DBManager.close(conn, pstmt, rs);
			 } 
				 
			return orderVO;
		}
	  
	  public int insertOrder(OrderVO orderVO) {
		   int result = 0;
			
			try {
				conn = DBManager.getConnection();
				String insertOrder = "insert into user_order(order_number, address, receiver_name, receiver_phone, user_id, product_number, product_name, product_price, product_quantity)"
						+ " values(order_seq.nextval, ?, ?, ?, ?, ? ,?, ?, ?)";
				pstmt = conn.prepareStatement(insertOrder);
				pstmt.setString(1, orderVO.getAddress());
				pstmt.setString(2, orderVO.getReceiver_name());
				pstmt.setString(3, orderVO.getReceiver_phone());
				pstmt.setString(4, orderVO.getUser_id());
				pstmt.setInt(5, orderVO.getProduct_number());
				pstmt.setString(6, orderVO.getProduct_name());
				pstmt.setInt(7, orderVO.getProduct_price());
				pstmt.setInt(8, orderVO.getProduct_quantity());
				rs = pstmt.executeQuery();
				result = 1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return result;
		}
	  
	  
	  public int insertOrder(ArrayList<OrderVO> orderList) {		
			int insert = 0;
			try {
				conn = DBManager.getConnection();
				String insertOrder = "insert into user_order(order_number, address, receiver_name, receiver_phone, user_id, product_number, product_name, product_price, product_quantity)"
						+ " values(order_seq.nextval, ?, ?, ?, ?, ? ,?, ?, ?)";		
				for (OrderVO orderVO : orderList) {
					pstmt = conn.prepareStatement(insertOrder);
					pstmt.setString(1, orderVO.getAddress());
					pstmt.setString(2, orderVO.getReceiver_name());
					pstmt.setString(3, orderVO.getReceiver_phone());
					pstmt.setString(4, orderVO.getUser_id());
					pstmt.setInt(5, orderVO.getProduct_number());
					pstmt.setString(6, orderVO.getProduct_name());
					pstmt.setInt(7, orderVO.getProduct_price());
					pstmt.setInt(8, orderVO.getProduct_quantity());
					rs = pstmt.executeQuery();
				}		
				insert = 1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return insert;
		}

}
