package com.demo.service;

import java.util.List;

import com.demo.bean.Cart;

public interface CartService {

	boolean addProduct();

	List<Cart> getAllCart();

	void CloseMySession();

	boolean deleteById(int cid);

	boolean addProductToCart(int cid, int pid);


}
