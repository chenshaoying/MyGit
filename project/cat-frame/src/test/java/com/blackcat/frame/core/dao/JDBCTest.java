package com.blackcat.frame.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCTest {
	@Test
	public void test1() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;   
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://192.168.147.131:3306/ermas_batch?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
		String user = "root";
		String pwd = "123456";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from tm_batch where job_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "XX or 1=1");//preparedStatement 采用占位符，所有输入参数都被''包围，有效防止sql注入；
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(2));				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	@Test
	public void test2() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;   
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://192.168.147.131:3306/ermas_batch?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
		String user = "root";
		String pwd = "123456";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			Statement st = conn.createStatement();			
			String  job_name = "XX' or '1'='1"; // statemen 采用字符串拼接，无法避免sql注入
			ResultSet rs = st.executeQuery("select * from tm_batch where job_name = '" + job_name + "'");
			while(rs.next()) {
				System.out.println(rs.getString(2));				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
