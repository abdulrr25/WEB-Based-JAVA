package com.demo.Day18_ProductRestWebservice.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Day18_ProductRestWebservice.beans.Product;
import com.demo.Day18_ProductRestWebservice.dao.ProductDao;
import com.demo.Day18_ProductRestWebservice.dto.ProductDto;
import com.demo.Day18_ProductRestWebservice.mapper.ProductDtoMapper;


@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao pdao;

	@Override
	public List<ProductDto> getProductByCid(int cid) {
		// TODO Auto-generated method stub
		List<Product> plist = pdao.findAllByCid(cid);
		List<ProductDto> plist1 = plist.stream().map(prod->ProductDtoMapper.mapToProductDto(prod)).collect(Collectors.toList());
		
		return plist1;
	}



}
