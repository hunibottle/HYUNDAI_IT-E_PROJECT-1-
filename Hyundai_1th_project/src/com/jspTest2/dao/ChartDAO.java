package com.jspTest2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.jspTest2.dto.ChartVO;

import utill.DBManager;

public class ChartDAO {
	
	private static ChartDAO instance = new ChartDAO();
	public static ChartDAO getInstance() {
		return instance;
	}

		public List<ChartVO> listChart() {
				
			List<ChartVO> chartlist = new ArrayList<ChartVO>();
		    String sql = "select category_code, product_name, product_hits from product";       
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;   
			try {
				 conn = DBManager.getConnection();
			     pstmt = conn.prepareStatement(sql);
			     rs = pstmt.executeQuery();
			     while(rs.next()) {
			    	 ChartVO charts = new ChartVO();
			    	 charts.setCategory_code(rs.getString("category_code"));	
			    	 charts.setProduct_name(rs.getString("product_name"));
			    	 charts.setProduct_hits(rs.getInt("product_hits"));
			    	 chartlist.add(charts);
			     	}
			}catch (Exception e) {
			     e.printStackTrace();
		    }finally {
		      DBManager.close(conn, pstmt, rs);
		    }
			return chartlist;
		}
}
