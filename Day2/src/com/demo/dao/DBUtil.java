package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static Connection conn = null;
	public static Connection GetConnetion() {
		if (conn == null) {

			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String URL = "jdbc:mysql://192.168.10.117:3306/dac3?useSSL=false";
				conn = DriverManager.getConnection(URL, "dac3", "welcome");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection testConn = GetConnetion();
		if (testConn != null) {
			System.out.println("Test Connection Ban gaya!!");
		} else {
			System.out.println("Test Connection nahi ban rha.");
		}
		
		
	}

}
