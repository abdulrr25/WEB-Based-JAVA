package com.demo.Day18_SpringBootRestFullStack.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.Day18_SpringBootRestFullStack.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	
	@Query(value="select * from Product where price between :lprice and :hprice",nativeQuery=true)
	List<Product> findByPrice(double lprice, double hprice);
	

}
