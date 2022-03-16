package com.jspTest2.dao; 

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import utill.DBManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspTest2.dto.MemberVO;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	//private DataSource dataFactory;
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		
		return instance;
	}
	public MemberDAO() {
	
	}
	public boolean isExisted(MemberVO memberVO) {
		boolean result = false;
		String user_id = memberVO.getUser_id();
		String user_pwd = memberVO.getUser_pwd();
		try {
			con = DBManager.getConnection();
			String query = "select decode(count(*),1,'true','false') as result from member";
			query += " where user_id=? and user_pwd=?";
			System.out.println(query);
			System.out.println(user_id +","+ user_pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pwd);
			ResultSet rs = pstmt.executeQuery();
			rs.next(); 
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result=" + result );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

	public int addMember(MemberVO memberVO) {

		
	;
	
	String query = "insert into member(user_id, user_pwd, user_name, user_phone, user_email)"
    		+ "values(?, ?, ?, ?, ?) ";
	int result = 0;
			
	try {
	con = DBManager.getConnection();
	String user_id = memberVO.getUser_id();
	String user_pwd = memberVO.getUser_pwd();
	String user_name = memberVO.getUser_name();
	String user_phone = memberVO.getUser_phone();
	String user_email = memberVO.getUser_email();	
	   
	System.out.println("  :  "+user_id);
	/*
	int user_role = 0;`matter.ofPattern("yyyyMMdd"));
	//System.out.println(user_insertdate +":"+ user_insertdate.getClass().getName());
	String query = "insert into t_member ";
	query += "values(user_id,user_pwd,user_name,user_phone,user_email)";
	*/


	System.out.println("prepareStatememt: " + query);
	pstmt = con.prepareStatement(query);
	pstmt.setString(1, user_id);
	pstmt.setString(2, user_pwd);
	pstmt.setString(3, user_name);
	pstmt.setString(4, user_phone);
	pstmt.setString(5, user_email);
	result = pstmt.executeUpdate();
	System.out.println(" "+user_id);
	System.out.println(result);
	pstmt.close();
	
	//int n = pstmt.executeUpdate();
	if(result == 1) {
		System.out.println(" 회원가입성공  ");
	}
	else {
		System.out.println("  회원가입 실패 ");
	}
	
	} catch (Exception e) {
	 e.printStackTrace();
	
   }finally {
	 DBManager.close(con, pstmt);
	 
   }
	return result;
   }
	
	
	
	
	public int deleteMember(MemberVO memberVO) {
		
		String user_id = memberVO.getUser_id();
		String user_pwd = memberVO.getUser_pwd();	
		int result = 0;
	try {
		
		con = DBManager.getConnection();
		String query = "delete from member where user_id=? and user_pwd=?";
		System.out.println(query);
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, user_id);
		pstmt.setString(2, user_pwd);
		result = pstmt.executeUpdate();
		System.out.println(result);
		pstmt.close();
		
		
		if(result == 1) {
			System.out.println(" 회원삭제 성공  ");
		}
		else {
			System.out.println(" 회원삭제 실패 ");
		}
		
	}catch (Exception e) {
		
		e.printStackTrace();
		
	 }finally {
		 DBManager.close(con, pstmt);
	 } 
		 
	return result;
	
	}
	
	
	
	public int modMember(MemberVO memberVO) {
		int result =0;
		String user_id = memberVO.getUser_id();
		String user_pwd = memberVO.getUser_pwd();
		String user_name = memberVO.getUser_name();
		String user_phone = memberVO.getUser_phone();
		String user_email = memberVO.getUser_email();
		
		try {	
			con = DBManager.getConnection();
			String query = "update member set user_pwd=?,user_name=?,user_phone=?,user_email=? where user_id=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_pwd);
			pstmt.setString(2, user_name);
			pstmt.setString(3, user_phone);
			pstmt.setString(4, user_email);
			pstmt.setString(5, user_id);		
			result = pstmt.executeUpdate();
			System.out.println(result);
			pstmt.close();
			
			
			if(result == 1) {
				System.out.println(" 회원정보 수정  성공  ");
			}
			else {
				System.out.println(" 회원정보 수정  실패 ");
			}
			
		 }catch (Exception e) {
			
			e.printStackTrace();
			
		 }finally {
			 DBManager.close(con, pstmt);
		 } 
			 
		return result;
		
	}
	public boolean confiremPwd(MemberVO memberVO) {
		boolean result = false;
		String user_pwd = memberVO.getUser_pwd(); // 사용자가 입력한 패스워드 
		String user_id = memberVO.getUser_id();
		try {

			
			con = DBManager.getConnection();
			String query = "select decode(user_pwd,"+user_pwd+",'true','false') as result from member";
			query += " where user_id=?";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			rs.next(); 
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result=" + result );
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 DBManager.close(con, pstmt);		 
		}
		return result;
		
	}
		
}


		

