package com.mydata.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.Model.Invoice;
import com.mydata.Model.Product;
import com.mydata.Model.Products;
import com.mydata.Service.InvoiceService;
import com.mydata.Service.ProductService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;

	private final ProductService productService;

	@Autowired
	public InvoiceController(ProductService productService) {
		this.productService = productService;
	}

//	@PostMapping
//	public Invoice createInvoice(@RequestBody Invoice invoice) {
//		return invoiceService.saveInvoice(invoice);
//	}

	@GetMapping("/getDataBetweenDates")
	public List<Invoice> getDataBetweenDates(@RequestParam String startDate, @RequestParam String endDate) {
		return invoiceService.getDataBetweenDates(startDate, endDate);
	}

	@GetMapping("/getDataBetweenDates/date")
	public List<Invoice> getInvoicesBetweenDates(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return invoiceService.getInvoicesBetweenDates(startDate, endDate);
	}

//	@PostMapping
//	public void saveInvoice(@RequestBody Invoice invoice) {
//		double grandTotal = calculateGrandTotal(invoice.getProducts(), Double.parseDouble(invoice.getDiscount()));
//		invoice.setGrandtotal(String.valueOf(grandTotal));
//		invoiceService.saveInvoice(invoice);
//	}

	@PostMapping
	public void saveInvoice(@RequestBody Invoice invoice) {
		double grandTotal = calculateGrandTotal(invoice.getProducts(), Double.parseDouble(invoice.getDiscount()));
		invoice.setGrandtotal(String.valueOf(grandTotal));

		// Update available quantity for each product
		List<Product> products = invoice.getProducts();
		for (Product product : products) {
			Products storedProduct = productService.getProductByName(product.getProductName());
			int availableQuantity = storedProduct.getAvailableQuantity() - product.getQuantity();
			storedProduct.setAvailableQuantity(availableQuantity);
			productService.updateProduct(storedProduct.getId(), storedProduct);
		}

		// Save the invoice
		invoiceService.saveInvoice(invoice);
	}

	private double calculateGrandTotal(List<Product> products, double discount) {
		double grandTotal = products.stream().mapToDouble(product -> Double.parseDouble(product.getTotal())).sum();

		if (discount > 0 && discount <= 100) {
			double discountAmount = grandTotal * (discount / 100);
			grandTotal -= discountAmount;
		}
		return grandTotal;
	}

//	@GetMapping("/latest")
//	public ResponseEntity<Integer> getLatestInvoiceNumber() {
//		try {
//			int latestInvoiceNo = invoiceService.getLatestInvoiceNumber();
//
//			return ResponseEntity.ok(latestInvoiceNo);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1);
//		}
//	}
	 @GetMapping("/latest")
	    public int getLatestInvoiceNumber() {
	        try {
	            int latestInvoiceNo = invoiceService.getLatestInvoiceNumber();
	            return latestInvoiceNo;
	        } catch (Exception e) {
	            return -1; // Return -1 in case of error
	        }
	    }
	

	
	@GetMapping
	public List<Invoice>getAllInvoices(){
		return invoiceService.getAllinvoices();
		
	}
}
