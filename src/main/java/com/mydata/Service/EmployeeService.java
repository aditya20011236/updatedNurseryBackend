package com.mydata.Service;

import com.mydata.Model.Employee;

public interface EmployeeService {

	Employee savemployee(Employee employee);
	
	 boolean authenticate(String username, String password);
}
