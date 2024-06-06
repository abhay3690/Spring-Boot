package com.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.modal.Product;
import com.payload.ProductDto;
import com.repository.ProductRepo;
import com.service.ProductService;

public class ProductServiceImpl {
	    @Mock
	    private ProductService productRepo;

	    @Mock
	    private ModelMapper modelMapper;

	    @InjectMocks
	    private ProductServiceImpl productService;

	    @BeforeEach
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testRegisterNewProduct() {
	        // Arrange
	        ProductDto inputDto = TestData.getSampleProductDto();
	        Product product = TestData.getSampleProduct();
	        when(modelMapper.map(inputDto, Product.class)).thenReturn(product);
	        when(productRepo.save(product)).thenReturn(product);

	        // Act
	        ProductDto resultDto = productService.registerNewProduct(inputDto);

	        // Assert
	        assertNotNull(resultDto);
	        assertEquals(inputDto.getPid(), resultDto.getPid());
	        assertEquals(inputDto.getPtitle(), resultDto.getPtitle());
	        assertEquals(inputDto.getPrice(), resultDto.getPrice());
	        assertEquals(inputDto.getPimage(), resultDto.getPimage());
	        assertEquals(inputDto.getPdiscription(), resultDto.getPdiscription());
	    }

	    @Test
	    public void testCreateProduct() {
	        // Arrange
	        ProductDto inputDto = TestData.getSampleProductDto();
	        Product product = TestData.getSampleProduct();
	        when(modelMapper.map(inputDto, Product.class)).thenReturn(product);
	        when(productRepo.save(product)).thenReturn(product);

	        // Act
	        ProductDto resultDto = productService.createProduct(inputDto);

	        // Assert
	        assertNotNull(resultDto);
	        assertEquals(inputDto.getPid(), resultDto.getPid());
	        assertEquals(inputDto.getPtitle(), resultDto.getPtitle());
	        assertEquals(inputDto.getPrice(), resultDto.getPrice());
	        assertEquals(inputDto.getPimage(), resultDto.getPimage());
	        assertEquals(inputDto.getPdiscription(), resultDto.getPdiscription());
	    }

	    @Test
	    public void testUpdateProduct() {
	        // Arrange
	        int productId = 1;
	        ProductDto inputDto = TestData.getSampleProductDto();
	        inputDto.setPid(productId);
	        Product product = TestData.getSampleProduct();
	        when(productRepo.findById(productId)).thenReturn(TestData.getSampleOptionalProduct());
	        when(modelMapper.map(inputDto, Product.class)).thenReturn(product);
	        when(productRepo.save(product)).thenReturn(product);

	        // Act
	        ProductDto resultDto = productService.updateProduct(inputDto, productId);

	        // Assert
	        assertNotNull(resultDto);
	        assertEquals(productId, resultDto.getPid());
	        assertEquals(inputDto.getPtitle(), resultDto.getPtitle());
	        assertEquals(inputDto.getPrice(), resultDto.getPrice());
	        assertEquals(inputDto.getPimage(), resultDto.getPimage());
	        assertEquals(inputDto.getPdiscription(), resultDto.getPdiscription());
	    }

	    @Test
	    public void testGetProductById() {
	        // Arrange
	        int productId = 1;
	        Product product = TestData.getSampleProduct();
	        ProductDto productDto = TestData.getSampleProductDto();
	        when(productRepo.findById(productId)).thenReturn(TestData.getSampleOptionalProduct());
	        when(modelMapper.map(product, ProductDto.class)).thenReturn(productDto);

	        // Act
	        ProductDto resultDto = productService.getProductById(productId);

	        // Assert
	        assertNotNull(resultDto);
	        assertEquals(productId, resultDto.getPid());
	        assertEquals(productDto.getPtitle(), resultDto.getPtitle());
	        assertEquals(productDto.getPrice(), resultDto.getPrice());
	        assertEquals(productDto.getPimage(), resultDto.getPimage());
	        assertEquals(productDto.getPdiscription(), resultDto.getPdiscription());
	    }

	    @Test
	    public void testAllProduct() {
	        // Arrange
	        List<Product> productList = TestData.getSampleProductList();
	        when(productRepo.findAll()).thenReturn(productList);

	        // Act
	        List<ProductDto> result = productService.allProduct();

	        // Assert
	        assertNotNull(result);
	        assertEquals(productList.size(), result.size());
	        for (int i = 0; i < productList.size(); i++) {
	            Product product = productList.get(i);
	            ProductDto dto = result.get(i);
	            assertEquals(product.getPid(), dto.getPid());
	            assertEquals(product.getPtitle(), dto.getPtitle());
	            assertEquals(product.getPrice(), dto.getPrice());
	            assertEquals(product.getPimage(), dto.getPimage());
	            assertEquals(product.getPdiscription(), dto.getPdiscription());
	        }
	    }

	    @Test
	    public void testDeleteProduct() {
	        // Arrange
	        int productId = 1;
	        Product product = TestData.getSampleProduct();
	        when(productRepo.findById(productId)).thenReturn(TestData.getSampleOptionalProduct());

	        // Act
	        productService.deleteProduct(productId);

	        // Assert
	        verify(productRepo, times(1)).delete(product);
	    }
	}

	

}
