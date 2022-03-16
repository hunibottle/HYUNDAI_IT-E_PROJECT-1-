package com.jspTest2.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utill.DBManager;

import com.jspTest2.dto.ProductVO;

public class ProductDAO {

	private ProductDAO() {
	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	public ArrayList<ProductVO> listAllProduct() {

		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		String sql = "select * from Product";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setProduct_number(rs.getInt("product_number"));
				product.setCategory_code(rs.getString("category_code"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_stock(rs.getInt("product_stock"));
				product.setProduct_desc(rs.getString("product_desc"));
				product.setProduct_hits(rs.getInt("product_hits"));
				product.setProduct_image(rs.getString("product_image"));
				productlist.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productlist;
	}

	public ProductVO getProduct(String product_number) {
		ProductVO product = null;
		String sql = "select * from product where product_number=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_number);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			product = new ProductVO();
			product.setProduct_number(rs.getInt("product_number"));
			product.setCategory_code(rs.getString("category_code"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_price(rs.getInt("product_price"));
			product.setProduct_desc(rs.getString("product_desc"));
			product.setProduct_stock(rs.getInt("product_stock"));
			product.setProduct_hits(rs.getInt("product_hits"));
			product.setProduct_image(rs.getString("product_image"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return product;
	}

	public ArrayList<ProductVO> listProduct() {

		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		String sql = "select product_number, product_name ,product_price, product_stock, product_hits, category_code, product_image from Product";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setProduct_number(rs.getInt("product_number"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_stock(rs.getInt("product_stock"));
				product.setProduct_hits(rs.getInt("product_hits"));
				product.setCategory_code(rs.getString("category_code"));
				product.setProduct_image(rs.getString("product_image"));
				productlist.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productlist;
	}

	public ArrayList<ProductVO> listProductByCategory(String category_code) {

		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		String sql = "select product_number, product_name, product_price, product_stock, product_hits, category_code, product_image from Product where category_code = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setProduct_number(rs.getInt("product_number"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_stock(rs.getInt("product_stock"));
				product.setProduct_hits(rs.getInt("product_hits"));
				product.setCategory_code(rs.getString("category_code"));
				product.setProduct_image(rs.getString("product_image"));
				productlist.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productlist;
	}

	public ArrayList<ProductVO> listProductByIndex(int index, String category_code) {

		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (index == 1) {
			try {
				String sql = "select product_number, product_name, product_price, product_stock, product_hits, category_code, product_date, product_image from Product where category_code = ? order by product_date desc";
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ProductVO product = new ProductVO();
					product.setProduct_number(rs.getInt("product_number"));
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_price(rs.getInt("product_price"));
					product.setProduct_stock(rs.getInt("product_stock"));
					product.setProduct_hits(rs.getInt("product_hits"));
					product.setCategory_code(rs.getString("category_code"));
					product.setProduct_image(rs.getString("product_image"));
					productlist.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} else if (index == 2) {
			try {
				String sql = "select product_number, product_name, product_price, product_stock, product_hits, category_code, product_image from Product where category_code = ? order by product_hits desc";
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ProductVO product = new ProductVO();
					product.setProduct_number(rs.getInt("product_number"));
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_price(rs.getInt("product_price"));
					product.setProduct_stock(rs.getInt("product_stock"));
					product.setProduct_hits(rs.getInt("product_hits"));
					product.setCategory_code(rs.getString("category_code"));
					product.setProduct_image(rs.getString("product_image"));
					productlist.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}

		} else if (index == 3) {
			try {
				String sql = "select product_number, product_name, product_price, product_stock, product_hits, category_code, product_image from Product where category_code = ? order by product_price";

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ProductVO product = new ProductVO();
					product.setProduct_number(rs.getInt("product_number"));
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_price(rs.getInt("product_price"));
					product.setProduct_stock(rs.getInt("product_stock"));
					product.setProduct_hits(rs.getInt("product_hits"));
					product.setCategory_code(rs.getString("category_code"));
					product.setProduct_image(rs.getString("product_image"));
					productlist.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} else {
			try {
				String sql = "select product_number, product_name, product_price, product_stock, product_hits, category_code, product_image from Product where category_code = ? order by product_price desc";
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category_code);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ProductVO product = new ProductVO();
					product.setProduct_number(rs.getInt("product_number"));
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_price(rs.getInt("product_price"));
					product.setProduct_stock(rs.getInt("product_stock"));
					product.setProduct_hits(rs.getInt("product_hits"));
					product.setCategory_code(rs.getString("category_code"));
					product.setProduct_image(rs.getString("product_image"));
					productlist.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return productlist;
	}

	public ArrayList<ProductVO> listProductByIndex(int index) {

		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (index == 1) {
			try {
				String sql = "select product_number, product_name, product_price, product_stock, product_hits, category_code, product_date, product_image from Product order by product_date desc";
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ProductVO product = new ProductVO();
					product.setProduct_number(rs.getInt("product_number"));
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_price(rs.getInt("product_price"));
					product.setProduct_stock(rs.getInt("product_stock"));
					product.setProduct_hits(rs.getInt("product_hits"));
					product.setCategory_code(rs.getString("category_code"));
					product.setProduct_image(rs.getString("product_image"));
					productlist.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} else if (index == 2) {
			try {
				String sql = "select product_number, product_name, product_price, product_stock, product_hits, category_code, product_image from Product order by product_hits desc";
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ProductVO product = new ProductVO();
					product.setProduct_number(rs.getInt("product_number"));
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_price(rs.getInt("product_price"));
					product.setProduct_stock(rs.getInt("product_stock"));
					product.setProduct_hits(rs.getInt("product_hits"));
					product.setCategory_code(rs.getString("category_code"));
					product.setProduct_image(rs.getString("product_image"));
					productlist.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}

		} else if (index == 3) {
			try {
				String sql = "select product_number, product_name, product_price, product_stock, product_hits, category_code, product_image from Product order by product_price";

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ProductVO product = new ProductVO();
					product.setProduct_number(rs.getInt("product_number"));
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_price(rs.getInt("product_price"));
					product.setProduct_stock(rs.getInt("product_stock"));
					product.setProduct_hits(rs.getInt("product_hits"));
					product.setCategory_code(rs.getString("category_code"));
					product.setProduct_image(rs.getString("product_image"));
					productlist.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} else {
			try {
				String sql = "select product_number, product_name, product_price, product_stock, product_hits, category_code, product_image from Product order by product_price desc";
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ProductVO product = new ProductVO();
					product.setProduct_number(rs.getInt("product_number"));
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_price(rs.getInt("product_price"));
					product.setProduct_stock(rs.getInt("product_stock"));
					product.setProduct_hits(rs.getInt("product_hits"));
					product.setCategory_code(rs.getString("category_code"));
					product.setProduct_image(rs.getString("product_image"));
					productlist.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return productlist;
	}

	public ArrayList<ProductVO> listBestProduct() {

		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		String sql = "WITH cte_products AS (" + "	SELECT " + "product_number," + "		product_name, "
				+ "		product_price," + "        product_stock," + "        product_hits," + "product_image,"
				+ "		RANK() OVER(ORDER BY product_hits DESC) hits_rank" + "	FROM " + "		Product" + ")"
				+ "select product_number, product_name, product_price, product_stock, product_hits, product_image from cte_products where ROWNUM <= 6";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setProduct_number(rs.getInt("product_number"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_stock(rs.getInt("product_stock"));
				product.setProduct_hits(rs.getInt("product_hits"));
				product.setProduct_image(rs.getString("product_image"));
				productlist.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productlist;
	}

}
