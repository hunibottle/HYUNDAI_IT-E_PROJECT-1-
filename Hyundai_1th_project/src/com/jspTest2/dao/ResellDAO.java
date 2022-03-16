package com.jspTest2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jspTest2.dto.ProductVO;
import com.jspTest2.dto.ResellVO;

import utill.DBManager;

public class ResellDAO {
	
	private ResellDAO() {
	}

	private static ResellDAO instance = new ResellDAO();

	public static ResellDAO getInstance() {
		return instance;
	}
	
	
	public ArrayList<ResellVO> listResellProduct(String user_id) {

		ArrayList<ResellVO> resellproductlist = new ArrayList<ResellVO>();
		String sql = "select resell_number, product_number, product_name, product_price, product_image from p_resell where user_id = ?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ResellVO resellproduct = new ResellVO();
				resellproduct.setResell_number(rs.getInt("resell_number"));
				resellproduct.setProduct_number(rs.getInt("product_number"));
				resellproduct.setProduct_name(rs.getString("product_name"));
				resellproduct.setProduct_price(rs.getInt("product_price"));
				resellproduct.setProduct_image(rs.getString("product_image"));
				resellproductlist.add(resellproduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return resellproductlist;
	}
	
	
	public ArrayList<ResellVO> listBestResellProduct() {

		ArrayList<ResellVO> resellproductlist = new ArrayList<ResellVO>();
		String sql = "select product_number, product_name, product_price, product_image from p_resell where ROWNUM <= 6 order by resell_date desc";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ResellVO resellproduct = new ResellVO();
				resellproduct.setProduct_number(rs.getInt("product_number"));
				resellproduct.setProduct_name(rs.getString("product_name"));
				resellproduct.setProduct_price(rs.getInt("product_price"));
				resellproduct.setProduct_image(rs.getString("product_image"));
				resellproductlist.add(resellproduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return resellproductlist;
	}
	
	public int ResellProduct(ResellVO resellVO) {
		int result = 0;
		String sql = "insert into p_resell(resell_number, product_number, user_id, product_name, product_price, product_image) "
				+ "values(resell_seq.nextval, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, resellVO.getProduct_number());
				pstmt.setString(2, resellVO.getUser_id());
				pstmt.setString(3, resellVO.getProduct_name());
				pstmt.setInt(4, resellVO.getProduct_price());
				pstmt.setString(5, resellVO.getProduct_image());
				rs = pstmt.executeQuery();
				result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	

}
