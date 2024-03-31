package com.mydata.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.Model.Employee;
import com.mydata.Repository.EmployeeRepository;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public boolean authenticate(String username, String password) {
		return employeeRepository.existsByUsernameAndPassword(username, password);
	}

	@Override
	public Employee savemployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
