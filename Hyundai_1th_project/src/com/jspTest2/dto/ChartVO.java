package com.jspTest2.dto;

import java.sql.Date;

public class ChartVO {

	
	private String category_code;
	private Integer product_hits;
	private String product_name;
	
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Integer getProduct_hits() {
		return product_hits;
	}
	public void setProduct_hits(Integer product_hits) {
		this.product_hits = product_hits;
	}
	public ChartVO(String category_code, Integer product_hits, String product_name) {
		super();
		this.category_code = category_code;
		this.product_hits = product_hits;
		this.product_name = product_name;
	}
	public ChartVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
