package com.demo.Day18_ProductRestWebservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.Day18_ProductRestWebservice.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

	  @Query(value="select * from product where cid=:cid",nativeQuery=true)
	  public List<Product> findAllByCid(int cid);
}
