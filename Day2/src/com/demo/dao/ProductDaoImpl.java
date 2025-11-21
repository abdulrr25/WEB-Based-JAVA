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
	static PreparedStatement insProd,findProd,findId,updateById,deleteId,sortByPrice;
    static {
    	
    	try {
    		conn=DBUtil.GetConnetion();
			insProd=conn.prepareStatement("insert into myproduct values(?,?,?,?,?)");
			findProd=conn.prepareStatement("select * from myproduct");
			findId = conn.prepareStatement("select * from myproduct where pid = ?");
			updateById=conn.prepareStatement("update myproduct set qty=?,price=? where pid=?");
			deleteId=conn.prepareStatement("Delete from myproduct where pid=?");
			sortByPrice=conn.prepareStatement("select * from myproduct order by price");
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
		DBUtil.closeConnection();
		
	}

	@Override
	public Product findById(int id) {
		Product p = null;
		try {
			findId.setInt(1,id);
			ResultSet rs = findId.executeQuery();
			if(rs.next()) {
				if(rs.getDate(5)!=null) {
					   p =new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate());
				}
				else
				{
					   p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null);

				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;

	}

	@Override
	public boolean modifyById(int id, int qty, double price) {
		int n = 0;
		try {
			updateById.setInt(1,qty);
			updateById.setDouble(2,price);
			updateById.setInt(3,id);
			n = updateById.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (n>0);
	}

	@Override
	public boolean deletebyId(int id) {
		// TODO Auto-generated method stub
		int n=0;
		try {
			deleteId.setInt(1, id);
			n =deleteId.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}

	@Override
	public List<Product> sortByPrice() {
		// TODO Auto-generated method stub
		List <Product> plist = new ArrayList<>();
		try {
			ResultSet rs = sortByPrice.executeQuery();
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
	

}
