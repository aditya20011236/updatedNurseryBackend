package com.mydata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.Model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

	Products findByProductName(String productName);


	
}
