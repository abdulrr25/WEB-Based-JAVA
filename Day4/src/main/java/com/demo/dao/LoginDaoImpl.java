package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.bean.MyUser;

public class LoginDaoImpl implements LoginDao{
     static Connection conn=null;
     static PreparedStatement seluser,register,forgot;
     static {
    	 
    	 try {
    		 conn=DBUtil.getMyConnection();
			seluser=conn.prepareStatement("select muname,email,role from user where muname=? and pass=?");
			register=conn.prepareStatement("insert into user values(?,?,?,?,?)");
			forgot=conn.prepareStatement("UPDATE user SET pass = ? WHERE email = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }
	@Override
	public MyUser checkUser(String uname, String pass) {
		try {
			seluser.setString(1, uname);
			seluser.setString(2, pass);
			ResultSet rs=seluser.executeQuery();
			if(rs.next()) {
				MyUser user=new MyUser(rs.getString(1),rs.getString(2),rs.getString(3),pass,"user");				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	@Override
	public boolean register(MyUser user) {
		try {
			register.setString(1,user.getUid());
			register.setString(2, user.getUname());
			register.setString(3,user.getPass());
			register.setString(4,user.getEmail());
			register.setString(5, user.getRole());
			int n= register.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean forgot(String email, String pass) {
		
		try {
			forgot.setString(1, pass);
			forgot.setString(2, email);
			int n=forgot.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
     
}
