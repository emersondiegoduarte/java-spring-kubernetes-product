package com.product.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.product.entity.Category;
import com.product.entity.Product;


public class ProductDTO {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private BigDecimal preco;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String productIdenfier;
	
	@NotNull
	private CategoryDTO category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getProductIdenfier() {
		return productIdenfier;
	}

	public void setProductIdenfier(String productIdenfier) {
		this.productIdenfier = productIdenfier;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
	public static ProductDTO convert(Product product) {
		ProductDTO	productDTO	=	new	ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());			
		productDTO.setDescricao(product.getDescricao());								
		productDTO.setProductIdenfier(product.getProductIdenfier());
		if (product.getCategory() != null)	{
			productDTO.setCategory(CategoryDTO.convert(product.getCategory()));
		}
		return	productDTO;
	}

}
