package com.mydata.Service;

import com.mydata.Model.User;

public interface UserService {

	User saveuser(User user);
	
	 boolean authenticate(String username, String password);
}
