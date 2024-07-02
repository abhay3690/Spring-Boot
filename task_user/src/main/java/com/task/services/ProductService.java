package com.task.services;

import java.util.List;

import com.task.modal.Product;
import com.task.payload.ProductResponse;

public interface ProductService {

	// create

	Product createProduct(Product product, int userId, int categoryId);

	// update
	Product updateProduct(Product product, int productId);

	// delete
	void deleteProduct(int productId);

	// get single Post
	Product getProductById(int productId);

	// get all
	ProductResponse getAllProduct(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	// get All Post By Category
	List<Product> getProductsByCategory(int categoryId);

	// get All posts By User
	List<Product> getProductsByUser(int userId);

	// search posts
	List<Product> searchProducts(String keyword);
}