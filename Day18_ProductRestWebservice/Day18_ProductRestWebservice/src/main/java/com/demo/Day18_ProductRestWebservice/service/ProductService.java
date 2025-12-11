package com.demo.Day18_ProductRestWebservice.service;

import java.util.List;

import com.demo.Day18_ProductRestWebservice.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getProductByCid(int cid);

}
