package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Product;

public class ProductDaoImpl implements ProductDao{
	static Connection conn;
	static PreparedStatement insproduct,allprod;
	static {
		conn=DBUtil.getMyConnection();
		try {
			insproduct = conn.prepareStatement("insert into product1 values(?,?,?,?,?,?)");
			allprod=conn.prepareStatement("select * from product1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean save(Product p) {
		try {
			insproduct.setInt(1, p.getPid());
			insproduct.setString(2, p.getName());
			insproduct.setInt(3,p.getQty());
			insproduct.setDouble(4,p.getPrice());
			insproduct.setDate(5, java.sql.Date.valueOf(p.getExpdate()));
			insproduct.setInt(6, p.getCid());
			
			int n=insproduct.executeUpdate();
			
			return n>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Product> showAllproducts() {
		// TODO Auto-generated method stub
		List<Product> plist  = new ArrayList<>();
		
		try {
			ResultSet rs = allprod.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
			}
			return plist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
