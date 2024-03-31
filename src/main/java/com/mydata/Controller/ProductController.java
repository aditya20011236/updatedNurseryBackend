package com.mydata.Controller;

import com.mydata.Model.Products;
import com.mydata.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductsService productService;

	@GetMapping
	public ResponseEntity<List<Products>> getAllProducts() {
		List<Products> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable Long id) {
		Products product = productService.getProductById(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Products> createProduct(@RequestBody Products product) {
		Products createdProduct = productService.createProduct(product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products product) {
		Products updatedProduct = productService.updateProduct(id, product);
		if (updatedProduct != null) {
			return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/product/{id}/price")
	public Double getProductSellingPrice(@PathVariable Long id) {
		return productService.getProductSellingPrice(id);
	}

	
}