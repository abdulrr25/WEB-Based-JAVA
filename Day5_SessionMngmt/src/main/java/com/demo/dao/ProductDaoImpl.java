package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Product;

public class ProductDaoImpl implements ProductDao {

	static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	@Override
	public List<Integer> getCategory() {
		List<Integer> clist = new ArrayList<>();
		String sql = "SELECT DISTINCT cid FROM product1";

		try {
			Connection conn = DBUtil.getMyConnection();
			PreparedStatement getCat = conn.prepareStatement(sql);
			ResultSet rs = getCat.executeQuery();
			while (rs.next()) {
				clist.add(rs.getInt("cid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clist;
	}

	@Override
	public List<Product> getProducts(int cid) {
		List<Product> plist = new ArrayList<>();
		String sql = "SELECT * FROM product1 WHERE cid = ?";

		try  {
			Connection conn = DBUtil.getMyConnection(); PreparedStatement getPro = conn.prepareStatement(sql);
			getPro.setInt(1, cid);

			ResultSet rs = getPro.executeQuery();
			while (rs.next()) {
				plist.add(new Product(rs.getInt("pid"), rs.getString("name"), rs.getInt("qty"), rs.getDouble("price"),
						rs.getDate("dt").toLocalDate(), rs.getInt("cid")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plist;
	}

}
