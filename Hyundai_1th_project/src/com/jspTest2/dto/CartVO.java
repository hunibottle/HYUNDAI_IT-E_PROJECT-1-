package com.jspTest2.dto;

import java.sql.Timestamp;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CartVO {
		private int cseq;
		private String user_id; 
		private int product_number;
		private String mname;
		private String product_name;
		private int quantity;
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
		private int product_price;
		private Timestamp indate;
		HttpSession session ;
		
		
		public HttpSession getSession() {
			return session;
		}
		public void setSession(HttpSession session) {
			this.session = session;
		}
		public int getCseq() {
			return cseq;
		}
		public void setCseq(int cseq) {
			this.cseq = cseq;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public int getProduct_number() {
			return product_number;
		}
		public void setProduct_number(int product_number) {
			this.product_number = product_number;
		}
		public String getMname() {
			return mname;
		}
		public void setMname(String mname) {
			this.mname = mname;
		}
		
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getProduct_price() {
			return product_price;
		}
		public void setProduct_price(int product_price) {
			this.product_price = product_price;
		}
		public Timestamp getIndate() {
			return indate;
		}
		public void setIndate(Timestamp indate) {
			this.indate = indate;
		}

}
