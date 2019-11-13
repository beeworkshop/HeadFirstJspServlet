package com.beeworkshop.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/db_jsp";
	private String dbUserName = "root";
	private String dbPassword = "123456";
	private String jdbcName = "com.mysql.jdbc.Driver";

	public Connection getConn() throws Exception {
		Class.forName(jdbcName);
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return conn;
	}

	public void closeConn(Connection conn) throws Exception {
		if (conn != null) {
			conn.close();
		}
	}

	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getConn();
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
