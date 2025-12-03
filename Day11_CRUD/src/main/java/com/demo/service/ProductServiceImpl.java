package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	
	ProductDao pdao;
	
	

	public ProductServiceImpl() {
		super();
		pdao = new ProductDaoImpl();
	}



	@Override
	public void addNewProduct() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Pid");
		int pid = sc.nextInt();
		
		System.out.println("Enter Product Name");
		String pname=sc.next();
		
		System.out.println("Enter Quantity of the product");
		int qty = sc.nextInt();
		
		System.out.println("Enter the price for the Product");
		double price = sc.nextDouble();
		
		Product p = new Product(pid,qty,price,pname);
		
		pdao.save(p);
	}



	@Override
	public boolean ModifyById(int pid, Double price) {
		// TODO Auto-generated method stub
		return pdao.ModifyById(pid,price);
	}



	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.DisplayAll();
	}

}
