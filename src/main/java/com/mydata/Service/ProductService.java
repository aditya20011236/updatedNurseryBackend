package com.mydata.Service;

import java.util.List;

import com.mydata.Model.Product;
import com.mydata.Model.Products;

public interface ProductService {

	Product saveproduct(Product product);

	public Products updateProduct(Long id, Products product);

	Products getProductByName(String productName);

	List<Products> searchProductsByName(String productName);
}
