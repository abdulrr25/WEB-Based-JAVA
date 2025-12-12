package com.demo.Day18_SpringBootRestFullStack.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.Day18_SpringBootRestFullStack.beans.Product;
import com.demo.Day18_SpringBootRestFullStack.dto.ProductDto;

public class ProductDtoMapper {
	
	public static ProductDto mapToProductDto(Product prod) {
		if(prod.getMfgdate()!=null) {
			
		return new ProductDto(prod.getPid(),prod.getPname(),prod.getQty(),prod.getPrice(),prod.getMfgdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),prod.getCid());
		}
		return new ProductDto(prod.getPid(),prod.getPname(),prod.getQty(),prod.getPrice(),null,prod.getCid());

	}
	
	public static Product mapToProduct(ProductDto prod) {
		if(prod.getMfgdate()==null) {
			
		return new Product(prod.getPid(),prod.getPname(),prod.getQty(),prod.getPrice(),null,prod.getCid());
		}
		else {
			return new Product(prod.getPid(),prod.getPname(),prod.getQty(),prod.getPrice(),LocalDate.parse(prod.getMfgdate().formatted(DateTimeFormatter.ofPattern("dd/MM/yyyy"))),prod.getCid());

		}
	}

}
