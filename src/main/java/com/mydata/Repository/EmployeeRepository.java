package com.mydata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.Model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	boolean existsByUsernameAndPassword(String username, String password);

}
