package net.abhay.blog.services;

import java.util.List;

import org.aspectj.weaver.patterns.AnnotationPatternList;

import net.abhay.payloads.CategoryDto;

public interface CategoryService {
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);

	// delete
	public void deleteCategory(Integer CategoryId);

	// update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// get
	public CategoryDto getCategory(Integer categoryId);

	// getAll
	List<CategoryDto> getCategories();
}
