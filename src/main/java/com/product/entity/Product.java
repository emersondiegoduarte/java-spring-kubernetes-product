package com.product.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.product.dto.ProductDTO;

@Entity(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private BigDecimal preco;
	
	private String descricao;
	
	@Column(name = "product_identifier")
	private String productIdenfier;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

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
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static Product convert (ProductDTO productDTO) {
		Product	product	=	new	Product();
		product.setNome(productDTO.getNome());
		product.setPreco(productDTO.getPreco());			
		product.setDescricao(productDTO.getDescricao());								
		product.setProductIdenfier(productDTO.getProductIdenfier());
		if (productDTO.getCategory() !=	null)	{
		  product.setCategory(Category.convert(productDTO.getCategory()));
		}
		return	product;
	}
	
}
