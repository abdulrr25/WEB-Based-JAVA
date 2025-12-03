package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.bean.Cart;
import com.demo.bean.Product;
import com.demo.dao.CartDao;
import com.demo.dao.CartDaoImpl;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class CartServiceImpl implements CartService{
	
	CartDao cdao;
	ProductDao pdao;
	
	
	public CartServiceImpl() {
		super();
		cdao = new CartDaoImpl() ;
		pdao=new ProductDaoImpl();
	}


	@Override
	public boolean addProduct() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Cart Id");
		int cid = sc.nextInt();
		System.out.println("enter Create Date(dd/MM/yyyy)");
		String dt=sc.next();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		Cart c = new Cart(cid,ldt); 

		return cdao.save(c);
	}


	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		return cdao.findAllCart();
	}


	@Override
	public void CloseMySession() {
		// TODO Auto-generated method stub
		cdao.closeMySession();
	}


	@Override
	public boolean deleteById(int cid) {
		// TODO Auto-generated method stub
		return cdao.RemoveById(cid);
	}


	@Override
	public boolean addProductToCart(int cid, int pid) {
		// TODO Auto-generated method stub
		Cart c = cdao.findById(cid);
		Product p = pdao.findById(pid);
		
		return cdao.addProductToCart(c,p);
	}



}
