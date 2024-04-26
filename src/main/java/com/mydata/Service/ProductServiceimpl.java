package com.mydata.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.Model.Product;
import com.mydata.Model.Products;

import com.mydata.Repository.ProductRepository;
import com.mydata.Repository.ProductsRepository;

@Service
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Override
	public Product saveproduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Products updateProduct(Long id, Products product) {
		Optional<Products> optionalProduct = productsRepository.findById(id);
		if (optionalProduct.isPresent()) {
			Products existingProduct = optionalProduct.get();
			existingProduct.setAvailableQuantity(product.getAvailableQuantity());
			return productsRepository.save(existingProduct);
		} else {
			return null;
		}
	}

	@Override
	public Products getProductByName(String productName) {
		return productsRepository.findByProductName(productName);
	}
	
	 @Override
	    public List<Products> searchProductsByName(String productName) {
	        return productsRepository.findByProductNameContainingIgnoreCase(productName);
	    }

}

