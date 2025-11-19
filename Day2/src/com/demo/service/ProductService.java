package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {


	boolean addNewProduct();

	List<Product> showAllProduct();

	void CloseConnection();

	Product findById(int id);

	boolean modifyById(int id, int qty, double price);

	boolean deletebyId(int id);

	List<Product> sortByPrice();

}
