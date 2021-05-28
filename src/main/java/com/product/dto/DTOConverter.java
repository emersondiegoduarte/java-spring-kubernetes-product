package com.product.dto;


import com.product.entity.Category;
import com.product.entity.Product;

public class DTOConverter {
	
	public static ProductDTO convert(Product product) {
		ProductDTO	productDTO	=	new	ProductDTO();
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		if	(product.getCategory()	!=	null)	{
				productDTO.setCategory(DTOConverter.convert(product.getCategory()));
		}
		return	productDTO;
	}
	
	public static Product convertDTO(ProductDTO productDTO) {
		Product	product	= new	Product();
		product.setNome(productDTO.getNome());
		product.setPreco(productDTO.getPreco());
		if	(productDTO.getCategory()	!=	null)	{
			product.setCategory(DTOConverter.convert(productDTO.getCategory()));
		}
		return	product;

	}
	
	
	public	static	Category	convert(CategoryDTO	categoryDTO) {
		Category	category	= new Category();
		category.setId(categoryDTO.getId());
		category.setNome(categoryDTO.getNome());
		return	category;
	}	
	
	public	static	CategoryDTO	convert(Category	category) {
		CategoryDTO	categoryDTO	= new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setNome(category.getNome());
		return	categoryDTO;
	}	

}
