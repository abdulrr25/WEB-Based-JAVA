package com.demo.Day17_SpringBootRestWebService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.Day17_SpringBootRestWebService.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	@Query(value="select * from product where price between :lprice and :hprice",nativeQuery = true)

	List<Product> findByPrice(double lprice, double hprice);
	
	
}
