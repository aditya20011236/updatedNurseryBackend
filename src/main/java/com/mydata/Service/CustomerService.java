package com.mydata.Service;

import java.util.List;

import com.mydata.Model.Customer;

public interface CustomerService {

	Customer savecustomerinfo(Customer customer);
	
	List<Customer>viewallCustomerDetails();
	
	Customer getcustomerbyid(Long id);
	
	void deleteCustomerbyid(Long id);
}
