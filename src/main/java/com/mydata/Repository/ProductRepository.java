package com.mydata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.Model.Product;
import com.mydata.Model.Products;

public interface ProductRepository  extends JpaRepository<Product, Integer>{






}
