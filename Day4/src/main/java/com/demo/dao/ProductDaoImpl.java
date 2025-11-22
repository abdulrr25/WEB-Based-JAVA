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
	static PreparedStatement insproduct,allprod,selbyId,delById,updateById;
	static {
		conn=DBUtil.getMyConnection();
		try {
			insproduct = conn.prepareStatement("insert into product1 values(?,?,?,?,?,?)");
			allprod=conn.prepareStatement("select * from product1");
			selbyId=conn.prepareStatement("select * from product1 where pid = ?");
			delById=conn.prepareStatement("delete from product1 where pid = ?");
			updateById=conn.prepareStatement("update product1 set pname=?,qty=?,price=?,expdate=?,cid=? where pid=?");

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

	@Override
	public Product findById(int pid) {
		// TODO Auto-generated method stub
		try {
			selbyId.setInt(1, pid);
			ResultSet rs=selbyId.executeQuery();
			if(rs.next()) {
			return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		
		try {
			delById.setInt(1,pid);
			int n = delById.executeUpdate();
			return n>0;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean UpdateById(Product p) {
		try {
			updateById.setString(1, p.getName());
			updateById.setInt(2, p.getQty());
			updateById.setDouble(3, p.getPrice());
			updateById.setDate(4, java.sql.Date.valueOf(p.getExpdate()));
			updateById.setInt(5, p.getCid());
			updateById.setInt(6, p.getPid());
			int n = updateById.executeUpdate();
		return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
