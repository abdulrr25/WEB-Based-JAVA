package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {


	boolean save(Product p);

	List<Product> showAllProducts();

	void closeConnection();

	Product findById(int id);

	boolean modifyById(int id, int qty, double price);

	boolean deletebyId(int id);

	List<Product> sortByPrice();

}
