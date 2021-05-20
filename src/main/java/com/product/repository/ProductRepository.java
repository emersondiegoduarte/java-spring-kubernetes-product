package com.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value = "select p from product p join category c on p.category.id = c.id where c.id = :categoryId")
	public Optional<Product> getProductsByCategory(@Param(value = "categoryId") Long categoryId);
	
	public Optional<Product> findByProductIdenfier(String productIdenfier);

}
