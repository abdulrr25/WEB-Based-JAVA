package com.demo.dao;

import java.util.List;

import com.demo.bean.Cart;
import com.demo.bean.Product;

public interface CartDao {

	boolean save(Cart c);

	List<Cart> findAllCart();

	void closeMySession();

	boolean RemoveById(int cid);


	Cart findById(int cid);

	boolean addProductToCart(Cart c, Product p);

}
