package net.abhay.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.abhay.blog.services.CategoryService;
import net.abhay.entities.Category;
import net.abhay.exceptions.ResourceNotFoundException;
import net.abhay.payloads.CategoryDto;
import net.abhay.repositories.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category save = this.categoryRepo.save(category);
		return this.modelMapper.map(save, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException(" Category ", "Category Id ", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updateCatogory = this.categoryRepo.save(category);
		return this.modelMapper.map(updateCatogory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));
		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getCategory(int categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> list = this.categoryRepo.findAll();
		List<CategoryDto> list2 = list.stream().map(list1 -> this.modelMapper.map(list1, CategoryDto.class))
				.collect(Collectors.toList());
		return list2;
	}

}