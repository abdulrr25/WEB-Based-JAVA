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

	public static void main(String[] args) {
		Connection testConn = GetConnetion();
		if (testConn != null) {
			System.out.println("Test Connection Ban gaya!!");
			try {
//				Statement st = testConn.createStatement();
//				ResultSet rs = st.executeQuery("select * from STUDENTT");
//				while(rs.next()) {
//					System.out.println("Pid : "+rs.getInt(1));
//					System.out.println("Sname : "+rs.getString(2));
//					
//					System.out.println("====================");
//					
//				}
				
				PreparedStatement pst = testConn.prepareStatement("Select * from studentt");
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					System.out.println("pid:" +rs.getInt("id"));
					System.out.println("Ename: " +rs.getString("sname"));
					System.out.println("============================");
				}
				PreparedStatement pst1= conn.prepareStatement("insert into studentt values (?,?)");
				int pid=490;
				String sname="Kunal";
				pst1.setInt(2,pid);
				pst1.setInt(1, pid);
				pst1.setString(2, sname);
				
				int n=pst1.executeUpdate();
				if(n>0) {
					System.out.println("Insertion done");
				}else {
					System.out.println("Error");
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Test Connection nahi ban rha.");
		}
		
		
	}

}
