package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.entity.LoginUser;
import com.example.login.entity.NewUserForm;
import com.example.login.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void create(NewUserForm newUser) {
		LoginUser loginUser = new LoginUser();
		loginUser.setUserName(newUser.getUserName());
		loginUser.setPassword(newUser.getPassword());
		userRepository.save(loginUser);
	}
}
