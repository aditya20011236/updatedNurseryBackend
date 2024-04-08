package com.mydata.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.Model.Customer;
import com.mydata.Service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.viewallCustomerDetails();
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.savecustomerinfo(customer);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomerbyid(id);
	}

	 @GetMapping("/latestId")
	    public ResponseEntity<Long> getLastCustomerId() {
	        try {
	            Long latestId = customerService.getLatestId();
	            return new ResponseEntity<>(latestId, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	}