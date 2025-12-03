package com.demo.service;

import java.util.List;

import com.demo.bean.Product;

public interface ProductService {

	void addNewProduct();

	boolean ModifyById(int pid, Double price);

	List<Product> getAllProducts();

}
