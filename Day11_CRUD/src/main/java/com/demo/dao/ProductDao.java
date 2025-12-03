package com.demo.dao;

import java.util.List;

import com.demo.bean.Product;

public interface ProductDao {

	void save(Product p);

	boolean ModifyById(int pid, Double price);

	List<Product> DisplayAll();

	Product findById(int pid);

}
