package com.demo.service;

import java.util.List;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	private ProductDao pdao;
	
	public ProductServiceImpl() {
		pdao=new ProductDaoImpl();
}

	
	@Override
	public boolean addNewProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.save(p);
	}


	@Override
	public List<Product> showProducts() {
		// TODO Auto-generated method stub
		return pdao.showAllproducts();
	}

}
