package com.service;



import java.util.List;
import com.payload.ProductDto;

public interface ProductService {
    // register
    ProductDto registerNewProduct(ProductDto productDto);

    // create
    ProductDto createProduct(ProductDto productDto);

    // update
    ProductDto updateProduct(ProductDto productDto, Integer productId);

    // get product by Id
    ProductDto getProductById(Integer productId);

    // All product
    List<ProductDto> allProduct();

    // Delete Product
    void deleteProduct(Integer productId);
}
