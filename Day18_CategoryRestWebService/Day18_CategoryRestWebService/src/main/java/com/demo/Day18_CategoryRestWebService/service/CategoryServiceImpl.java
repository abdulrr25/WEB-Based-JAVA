package com.demo.Day18_CategoryRestWebService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.demo.Day18_CategoryRestWebService.beans.Category;
import com.demo.Day18_CategoryRestWebService.dao.CategoryDao;
import com.demo.Day18_CategoryRestWebService.dto.CategoryDto;
import com.demo.Day18_CategoryRestWebService.dto.ProductDto;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao cdao;
	
	 
	 @Autowired
	 RestClient restClient;

	public Category getById(int cid) {
		// TODO Auto-generated method stub
		
		Optional<Category> c=cdao.findById(cid);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}



	@Override
	public CategoryDto getProductByCid(int cid) {
		// TODO Auto-generated method stub
		
		Category c=cdao.findById(cid).orElseThrow(()->new RuntimeException("Category Not Found"));
		List<ProductDto> productlist=  restClient.get()
                .uri("http://PRODUCT-SERVICE/products/category/" + cid)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductDto>>() {});
		
		return null;
	}

}
