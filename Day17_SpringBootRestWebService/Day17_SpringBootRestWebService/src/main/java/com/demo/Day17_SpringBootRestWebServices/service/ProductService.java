package com.demo.Day17_SpringBootRestWebServices.service;

import java.util.List;

import com.demo.Day17_SpringBootRestWebService.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProduct();

	ProductDto getById(int pid);

	List<ProductDto> getByprice(double lprice, double hprice);

	boolean addproduct(ProductDto p);

	boolean updateproduct(ProductDto p);

	boolean deleteById(int pid);

}
