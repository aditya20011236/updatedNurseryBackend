package com.mydata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.Model.Employee;
import com.mydata.Service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/register")
	public Employee saveUser(@RequestBody Employee employee) {
		return employeeService.savemployee(employee);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Employee employee) {
		if (employeeService.authenticate(employee.getUsername(), employee.getPassword())) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
		}
	}
}