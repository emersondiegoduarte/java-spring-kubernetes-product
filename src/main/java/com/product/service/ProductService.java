package com.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductDTO;
import com.product.entity.Product;
import com.product.exceptions.ProductNotFoundException;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> getAll(){
		List<Product> produtos = productRepository.findAll();
		return produtos.stream()
				.map(ProductDTO::convert)
				.collect(Collectors.toList());
	}
	
	public List<ProductDTO> getProductsByCategoryId(Long categoryId){
		Optional<Product> products = productRepository.getProductsByCategory(categoryId);
		if(products.isPresent()) {
			return products.stream()
			.map(ProductDTO::convert)
			.collect(Collectors.toList());
		}
		
		return null;
	}
	
	public	ProductDTO	findByProductIdentifier(String	productIdentifier) {
		Optional<Product>	product	=	productRepository.findByProductIdenfier(productIdentifier);
		if	(product.isPresent())	{
			return	ProductDTO.convert(product.get());
		}
		return null;
	}
	
	public	ProductDTO	save(ProductDTO	productDTO) {
		Product	product	= productRepository.save(Product.convert(productDTO));
		return	ProductDTO.convert(product);
	}	
	
	public	ProductDTO	delete(long	ProductId) throws	ProductNotFoundException	{
		Optional<Product>	product	= productRepository.findById(ProductId);
		if(product.isPresent()){
			productRepository.delete(product.get());
		}
		
		return null;
	}

}
