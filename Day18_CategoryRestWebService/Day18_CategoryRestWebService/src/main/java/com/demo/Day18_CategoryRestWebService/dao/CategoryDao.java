package com.demo.Day18_CategoryRestWebService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Day18_CategoryRestWebService.beans.Category;
@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	
	
	

}
