package com.demo.Day18_ProductRestWebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	
	ProductService pservice;
}
