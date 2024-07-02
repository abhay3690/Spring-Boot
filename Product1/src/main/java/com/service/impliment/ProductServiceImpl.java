package com.service.impliment;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.defaultException.ResourceNotFoundException;
import com.entity.Product;
import com.load.ProductDto;

import com.repository.ProductRepo;
import com.repository.ProductResponse;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepo productRepo;

	@Override
	public ProductDto registerProduct(ProductDto productDto, Long sId) {

		Product product = this.modelMapper.map(productDto, Product.class);
		product.setPId(productDto.getPId());
		product.setSId(sId);
		product.setPName(productDto.getPName());
		product.setPPrice(productDto.getPPrice());
		product.setPImage(productDto.getPImage());
		product.setPCategory(productDto.getPCategory());
		product.setPDescription(productDto.getPDescription());
//		product.setSeller(productDto.getSeller());
		Product save = this.productRepo.save(product);
		ProductDto productDto2 = this.modelMapper.map(save, ProductDto.class);
		return productDto2;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, Long pId, Long sId) {
		Product product = this.modelMapper.map(productDto, Product.class);

		product.setPId(pId);
		product.setSId(sId);
		product.setPName(productDto.getPName());
		product.setPPrice(productDto.getPPrice());
		product.setPImage(productDto.getPImage());
		product.setPCategory(productDto.getPCategory());
		product.setPDescription(productDto.getPDescription());
//		product.setSeller(productDto.getSeller());
		Product update = this.productRepo.save(product);
		ProductDto dto = this.modelMapper.map(update, ProductDto.class);
		return dto;
	}

	@Override
	public ProductResponse getAllProduct(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

		Pageable p = PageRequest.of(pageNumber, pageSize, sort);
		Page<Product> pageProduct = this.productRepo.findAll(p);
		List<Product> allProduct = pageProduct.getContent();

		List<ProductDto> list = allProduct.stream().map(product -> this.modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(list);
		productResponse.setPageNumber(pageProduct.getNumber());
		productResponse.setPageSize(pageProduct.getSize());
		productResponse.setTotalElements(pageProduct.getTotalElements());
		productResponse.setTotalPages(pageProduct.getTotalPages());
		productResponse.setLastPage(pageProduct.isLast());
		return productResponse;
	}

	@Override
	public List<ProductDto> getAllProductBySId(Long sId) {
		List<Product> products = this.productRepo.findAllBySId(sId);
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto getProductByPId(Long pId) {
		Product product = this.productRepo.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("product ", "id", pId));
		ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
		return productDto;
	}

	@Override
	public void deleteProduct(Long pId) {
		Product product = this.productRepo.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id ", pId));
		this.productRepo.delete(product);
		;
	}

}
