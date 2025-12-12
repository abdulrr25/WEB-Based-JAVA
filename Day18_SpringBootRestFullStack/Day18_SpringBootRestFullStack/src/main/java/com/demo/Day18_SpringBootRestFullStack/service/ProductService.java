package com.demo.Day18_SpringBootRestFullStack.service;

import java.util.List;

import com.demo.Day18_SpringBootRestFullStack.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProducts();


	ProductDto getProductById(int pid);




	List<ProductDto> getByPrice(double lprice, double hprice);


	boolean addProducts(ProductDto p);



	boolean updateProducts(ProductDto p);


	boolean deleteProducts(int pid);

}
