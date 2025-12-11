package com.demo.Day18_CategoryRestWebService.service;

import com.demo.Day18_CategoryRestWebService.beans.Category;
import com.demo.Day18_CategoryRestWebService.dto.CategoryDto;

public interface CategoryService {

	Category getById(int cid);

	CategoryDto getProductByCid(int cid);

}
