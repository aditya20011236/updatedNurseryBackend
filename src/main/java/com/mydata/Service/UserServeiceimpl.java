package com.mydata.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.Model.User;
import com.mydata.Repository.UserRepository;

@Service
public class UserServeiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveuser(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean authenticate(String username, String password) {
		return userRepository.existsByUsernameAndPassword(username, password);
	}

}