package com.mydata.Controller;

import com.mydata.Model.DeductQuantityRequest;
import com.mydata.Model.Products;
import com.mydata.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

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

	@PutMapping("/deductQuantity")
	public ResponseEntity<Void> deductQuantity(@RequestBody DeductQuantityRequest request) {
		productService.deductQuantity(request.getProductId(), request.getQuantity());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}/checkQuantity")
	public ResponseEntity<String> checkQuantity(@PathVariable Long id, @RequestParam int quantity) {
		Products product = productService.getProductById(id);
		if (product != null) {
			if (quantity > product.getAvailableQuantity()) {
				return ResponseEntity.badRequest().body("Insufficient quantity!");
			} else {
				return ResponseEntity.ok("Quantity is available.");
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/lastId")
	public Long getLastProductId() {
		return productService.getLastProductId();
	}

	@GetMapping("/{productName}/quantity")
	public ResponseEntity<Integer> getAvailableQuantity(@PathVariable String productName) {
		Integer availableQuantity = productService.getAvailableQuantity(productName);
		if (availableQuantity != null) {
			return ResponseEntity.ok(availableQuantity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}