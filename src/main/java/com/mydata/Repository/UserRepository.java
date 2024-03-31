package com.mydata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	 boolean existsByUsernameAndPassword(String username, String password);
}
