package com.mydata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.Model.Customer;
import com.mydata.Model.Products;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

	Customer findTopByOrderByIdDesc();


}
