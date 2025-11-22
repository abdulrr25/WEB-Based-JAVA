package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;
import com.mysql.cj.protocol.Resultset;

public class ProductDaoImpl implements ProductDao {

	static Connection conn;
	static PreparedStatement insProd,findProd;
    static {
    	
    	try {
    		conn=DBUtil.getMyConnection();
			insProd=conn.prepareStatement("insert into myproduct values(?,?,?,?,?)");
			findProd=conn.prepareStatement("select * from myproduct");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	public boolean save(Product p) {
		try {
			insProd.setInt(1,p.getPid());
			insProd.setString(2,p.getPname());
			insProd.setInt(3, p.getQty());
			insProd.setDouble(4,p.getPrice());
			insProd.setDate(5,java.sql.Date.valueOf(p.getLdt()));
			int n = insProd.executeUpdate();
			if(n>0) {
				return true;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<Product> showAllProducts() {
		List<Product> plist = new ArrayList<>();
		try {
			ResultSet rs = findProd.executeQuery();
			while(rs.next()) {
				if(rs.getDate(5)!=null) {
					   plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate()));
				}
				else
				{
					   plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null));

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(plist.size()>0) {
			return plist;
		}
		else {
			return null;
		}
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		DBUtil.closeMyConnection();
		
	}
	

}
