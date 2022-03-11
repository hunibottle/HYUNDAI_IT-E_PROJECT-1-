package com.jspTest2.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utill.DBManager;

import com.jspTest2.dto.BoardVO;
import com.jspTest2.dto.ProductVO;

public class ProductDAO {
	
	private ProductDAO() { }
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public ArrayList<ProductVO> listProduct(){
		
		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		String sql = "select product_number, product_name, product_price, product_stock, product_hits,"
				+ "product_image, product_name_2, brand, brand_image from Product";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 ProductVO product = new ProductVO();
				 product.setProduct_number(rs.getInt("product_number"));
		    	 product.setProduct_name(rs.getString("product_name"));
		    	 product.setProduct_price(rs.getInt("product_price"));
		    	 product.setProduct_stock(rs.getInt("product_stock"));
		    	 product.setProduct_hits(rs.getInt("product_hits"));
		    	 product.setProduct_image(rs.getString("product_image"));
		    	 product.setProduct_name_2(rs.getString("product_name_2"));
		    	 product.setProduct_brand(rs.getString("brand"));
		    	 product.setProduct_brand_image(rs.getString("brand_image"));
		    	 productlist.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productlist;
	}
	
	public ProductVO getProduct(String product_number) {
	    ProductVO product = null;
	    String sql = "select * from product where product_number=?";	    
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;    	    
	    try {
	      con = DBManager.getConnection();
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, product_number);
	      rs = pstmt.executeQuery();
	      if (rs.next()) { 
	        product = new ProductVO();
	        product.setProduct_number(rs.getInt("product_number"));
	    	 product.setProduct_name(rs.getString("product_name"));
	    	 product.setProduct_price(rs.getInt("product_price"));
	    	 product.setProduct_stock(rs.getInt("product_stock"));
	    	 product.setProduct_hits(rs.getInt("product_hits"));
	    	 product.setProduct_image(rs.getString("product_image"));
	    	 product.setProduct_name_2(rs.getString("product_name_2"));
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(con, pstmt, rs);
	    }
	    return product;
	  }
	
}
