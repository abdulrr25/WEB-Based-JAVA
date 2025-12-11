package com.demo.Day18_ProductRestWebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Day18_ProductRestWebservice.dto.ProductDto;
import com.demo.Day18_ProductRestWebservice.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	
	ProductService pservice;
	
	@GetMapping("/products/category/{cid}")
	public ResponseEntity<List<ProductDto>> getByCategoryId(@PathVariable int cid){
		List<ProductDto> plist = pservice.getProductByCid(cid);
		return ResponseEntity.ok(plist);
	}
}
