package com.demo.Day18_SpringBootRestFullStack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Day18_SpringBootRestFullStack.dto.ProductDto;
import com.demo.Day18_SpringBootRestFullStack.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List <ProductDto> plist=pservice.getAllProducts();
		return ResponseEntity.ok(plist);
	}
	@GetMapping("/findproduct/{pid}")
	public ResponseEntity<ProductDto>getProdById(@PathVariable int pid){
		ProductDto p=pservice.getProductById(pid);		
		return null;
		
	}
	@GetMapping("/findproduct/{lprice}/{hprice}")
	public ResponseEntity<List<ProductDto>>getProdById(@PathVariable double lprice,@PathVariable double hprice){
		List<ProductDto> plist=pservice.getByPrice(lprice,hprice);
		return ResponseEntity.ok(plist);
		
	}
	@GetMapping("/products/{pid}")
	public ResponseEntity<String>addProduct(@RequestBody ProductDto p){
		boolean status=pservice.addProducts(p);
		if(status) {
			return ResponseEntity.ok("Data Added Successfully");
		}
		else {
			return ResponseEntity.ok("Not Added");
		}
		
		
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<String>updateProduct(@RequestBody ProductDto p){
		boolean status=pservice.updateProducts(p);
		if(status) {
			return ResponseEntity.ok("Data update Successfully");
		}
		else {
			return ResponseEntity.ok("Error occurr");
		}
		
		
	}
	
	public ResponseEntity<String>deleteProduct(@PathVariable int pid){
		boolean status=pservice.deleteProducts(pid);
		if(status) {
			return ResponseEntity.ok("Data deleted Successfully");
		}
		else {
			return ResponseEntity.ok("Error");
		}
		
	}
	
	

}
