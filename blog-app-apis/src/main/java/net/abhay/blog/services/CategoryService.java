package net.abhay.blog.services;

import java.util.List;

import net.abhay.payloads.CategoryDto;



public interface CategoryService {

	// create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	CategoryDto updateCategory(CategoryDto categoryDto,int categoryId);
	
	// delete
	void deleteCategory(int categoryId);
	
	// get
	CategoryDto getCategory(int categoryId);
	
	// get All
	List<CategoryDto> getCategories();
}