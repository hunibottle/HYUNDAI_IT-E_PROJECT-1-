package com.jspTest2.dto;

public class ProductVO {

	private int product_number;
	private String product_name;
	private int product_price;
	private int product_stock;
	private int product_hits;
	private String product_image;
	private String product_name_2;
	private String brand;
	private String brand_image;
	
	public String getProduct_brand() {
		return brand;
	}
	public void setProduct_brand(String brand) {
		this.brand = brand;
	}
	public String getProduct_brand_image() {
		return brand_image;
	}
	public void setProduct_brand_image(String brand_image) {
		this.brand_image = brand_image;
	}
	public String getProduct_name_2() {
		return product_name_2;
	}
	public void setProduct_name_2(String product_name_2) {
		this.product_name_2 = product_name_2;
	}
	public int getProduct_number() {
		return product_number;
	}
	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}
	
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	//getter, setter 积己 规过 -> 付快胶 快努腐 source -> generate get/set
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public int getProduct_hits() {
		return product_hits;
	}
	public void setProduct_hits(int product_hits) {
		this.product_hits = product_hits;
	}
	

}
