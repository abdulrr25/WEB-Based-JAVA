package com.demo.service;

import java.util.Scanner;

import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao pdao;
	   
	   public ProductServiceImpl() {
		   pdao=new ProductDaoImpl();
	   }
	@Override
	public boolean addnewproduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product ID");
		
		return false;
	}

}
