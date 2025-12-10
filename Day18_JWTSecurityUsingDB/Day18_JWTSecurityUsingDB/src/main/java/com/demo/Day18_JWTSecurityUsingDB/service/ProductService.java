package com.demo.Day18_JWTSecurityUsingDB.service;

import java.util.List;

import com.demo.Day18_JWTSecurityUsingDB.beans.Product;
import com.demo.Day18_JWTSecurityUsingDB.dto.ProductDto;

public interface ProductService {

	List<ProductDto> findAllProducts();

	ProductDto getById(int pid);

	List<ProductDto> getByprice(double lprice, double hprice);

	boolean addproduct(ProductDto p);

	boolean updateproduct(ProductDto p);

	boolean deleteById(int pid);

}
