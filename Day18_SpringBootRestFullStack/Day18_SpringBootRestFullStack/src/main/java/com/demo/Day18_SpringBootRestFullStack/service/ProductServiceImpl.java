package com.demo.Day18_SpringBootRestFullStack.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Day18_SpringBootRestFullStack.beans.Product;
import com.demo.Day18_SpringBootRestFullStack.dao.ProductDao;
import com.demo.Day18_SpringBootRestFullStack.dto.ProductDto;
import com.demo.Day18_SpringBootRestFullStack.mapper.ProductDtoMapper;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao pdao;

	@Override
	public List<ProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product>plist=pdao.findAll();
		List<ProductDto>plist1=plist.stream().map(prod->ProductDtoMapper.mapToProductDto(prod)).collect(Collectors.toList());
		return plist1;
	}

	@Override
	public ProductDto getProductById(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> p=pdao.findById(pid);
		if(p.isPresent()) {
		ProductDto prod = ProductDtoMapper.mapToProductDto(p.get());
	}
		return null;
	}

	@Override
	public List<ProductDto> getByPrice(double lprice, double hprice) {
		// TODO Auto-generated method stub
		List<Product>plist=pdao.findByPrice(lprice,hprice);
		return null;
	}

	@Override
	public boolean addProducts(ProductDto p) {
		// TODO Auto-generated method stub
		
		Product prod=ProductDtoMapper.mapToProduct(p);
		Product p1=pdao.save(prod);
		
		return p1!=null;
	}

	@Override
	public boolean updateProducts(ProductDto p) {
		// TODO Auto-generated method stub
		Product prod=ProductDtoMapper.mapToProduct(p);
		Optional<Product> op=pdao.findById(prod.getPid());
		if(op.isPresent()) {
			Product p2=op.get();
			p2.setPname(p.getPname());
			p2.setQty(p.getQty());
			p2.setPrice(p.getPrice());
			pdao.save(p2);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProducts(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> op=pdao.findById(pid);
		if(op.isPresent()) {
			pdao.delete(op.get());
			return true;
		}
		
		return false;
	}

}
