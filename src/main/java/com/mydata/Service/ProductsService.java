package com.mydata.Service;

import com.mydata.Model.Products;

import java.util.List;

public interface ProductsService {
	List<Products> getAllProducts();

	Products getProductById(Long id);

	Products createProduct(Products product);

	Products updateProduct(Long id, Products product);

	void deleteProduct(Long id);

	public Double getProductSellingPrice(Long id);

	void deductQuantity(Long productId, int quantity);

	Long getLastProductId();
}
