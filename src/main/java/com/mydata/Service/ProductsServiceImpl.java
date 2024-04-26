package com.mydata.Service;

import com.mydata.Model.Products;
import com.mydata.Repository.ProductRepository;
import com.mydata.Repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Override
	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

	@Override
	public Products getProductById(Long id) {
		return productsRepository.findById(id).get();
	}

	@Override
	public Products createProduct(Products product) {
		Long lastId = getLastProductId();
		Long nextId = lastId + 1;
		product.setId(nextId);
		return productsRepository.save(product);
	}

	@Override
	public Products updateProduct(Long id, Products product) {
		Optional<Products> optionalProduct = productsRepository.findById(id);
		if (optionalProduct.isPresent()) {
			Products existingProduct = optionalProduct.get();
			existingProduct.setProductName(product.getProductName());
			existingProduct.setDate(product.getDate());
			existingProduct.setAvailableQuantity(product.getAvailableQuantity());
			existingProduct.setMfgPrice(product.getMfgPrice());
			existingProduct.setSellingPrice(product.getSellingPrice());
			return productsRepository.save(existingProduct);
		} else {
			return null;
		}
	}

	@Override
	public void deleteProduct(Long id) {
		productsRepository.deleteById(id);
	}

	@Override
	public Double getProductSellingPrice(Long id) {
		Products product = productsRepository.findById(id).get();
		return (product != null) ? product.getSellingPrice() : null;

	}

	@Override
	public void deductQuantity(Long productId, int quantity) {
		Products product = productsRepository.findById(productId).orElse(null);
		if (product != null) {
			int updatedQuantity = product.getAvailableQuantity() - quantity;
			product.setAvailableQuantity(updatedQuantity);
			productsRepository.save(product);
		}
	}

	public Long getLastProductId() {
		Products lastProduct = productsRepository.findTopByOrderByIdDesc();
		return (lastProduct != null) ? lastProduct.getId() : 0L;
	}

	@Override
	public Integer getAvailableQuantity(String productName) {
		   Products product = productsRepository.findByProductName(productName);
		   return (product != null) ? product.getAvailableQuantity() : 0;
	    }
	
//	 @Override
//	    public List<Products> searchProductsByName(String productName) {
//	        return productsRepository.findByProductNameContainingIgnoreCase(productName);
//	    }
	@Override
	public List<Products> searchProductsByName(String productName) {
	    // First, try to find an exact match for the product name
	    Products exactMatchProduct = productsRepository.findByProductNameIgnoreCase(productName);
	    if (exactMatchProduct != null) {
	        // If an exact match is found, return the product
	        return Collections.singletonList(exactMatchProduct);
	    } else {
	        // If no exact match is found, search for products containing the search term as a substring
	        return productsRepository.findByProductNameContainingIgnoreCase(productName);
	    }
	}
	}
	