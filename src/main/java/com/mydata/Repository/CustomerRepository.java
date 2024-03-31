package com.mydata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.Model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
