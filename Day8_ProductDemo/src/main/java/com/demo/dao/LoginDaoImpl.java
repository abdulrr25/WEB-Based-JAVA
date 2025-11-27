package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.bean.MyUser;

public class LoginDaoImpl implements LoginDao{

	static Connection conn;
	static {
		conn=DBUtil.getMyConnection();
		
	}
	
	@Override
	public MyUser validateuser(String uname, String pass) {
	    String sql = "SELECT muname, email, role FROM user WHERE muname=? AND pass=?";
	    MyUser user = null;

	    try {
	    	Connection conn = DBUtil.getMyConnection();
	    	 PreparedStatement vuser = conn.prepareStatement(sql);
	        vuser.setString(1, uname);
	        vuser.setString(2, pass);  

	        try (ResultSet rs = vuser.executeQuery()) {
	            if (rs.next()) {
	                user = new MyUser(
	                    rs.getString("muname"),
	                    rs.getString("email"),
	                    rs.getString("role")
	                );
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}


}
