package com.dom.SpringbootRestWebService.mapper;

import java.time.format.DateTimeFormatter;

import com.dom.SpringbootRestWebService.dto.ProductDto;

public class ProductDtoMapper {
	public static ProductDto mapProduct(ProductDto p) {
		if(p.getMgfdate()==null) {
			return new ProductDto(p.getPid(),p.getPname(),p.getQty(),p.getPrice(),null,p.getCid());
		}
		else {
			return new ProductDto(p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getMgfdate().formatted(DateTimeFormatter.ofPattern("dd/MM/yyyy")),p.getCid());
			
		}

	}

}
