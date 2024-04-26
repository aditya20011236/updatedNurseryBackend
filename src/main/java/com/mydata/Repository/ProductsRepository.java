package com.mydata.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.Model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

	Products findByProductName(String productName);

	Products findTopByOrderByIdDesc();
	
	 List<Products> findByProductNameContainingIgnoreCase(String productName);
	 
	 Products findByProductNameIgnoreCase(String productName);

}
