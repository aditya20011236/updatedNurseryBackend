package com.mydata.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.Model.Customer;
import com.mydata.Repository.CustomerRepository;

@Service
public class Customerserviceimpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer savecustomerinfo(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> viewallCustomerDetails() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getcustomerbyid(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public void deleteCustomerbyid(Long id) {
		customerRepository.deleteById(id);
	}

}
