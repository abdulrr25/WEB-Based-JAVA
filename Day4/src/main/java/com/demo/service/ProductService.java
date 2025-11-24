package com.demo.service;

import java.util.List;

import com.demo.bean.MyUser;
import com.demo.bean.Product;

public interface ProductService {

	boolean addNewProduct(Product p);

	List<Product> showProducts();

	Product getById(int pid);

	boolean deleteById(int pid);

	boolean updateproduct(Product p);


}
