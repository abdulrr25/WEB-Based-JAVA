package com.demo.dao;

import java.util.List;

import com.demo.bean.MyUser;
import com.demo.bean.Product;

public interface ProductDao {

	boolean save(Product p);

	List<Product> showAllproducts();

	Product findById(int pid);

	boolean deleteById(int pid);

	boolean UpdateById(Product p);


}
