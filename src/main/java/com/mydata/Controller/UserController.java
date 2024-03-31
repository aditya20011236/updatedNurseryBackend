package com.mydata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.Model.User;
import com.mydata.Service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveuser(user);
	}

	@PostMapping("/api/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		if (userService.authenticate(user.getUsername(), user.getPassword())) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
		}
	}
}