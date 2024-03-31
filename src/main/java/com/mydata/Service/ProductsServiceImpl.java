package com.mydata.Service;

import com.mydata.Model.Product;
import com.mydata.Model.Products;
import com.mydata.Repository.ProductRepository;
import com.mydata.Repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
