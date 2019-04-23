package com.adwait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adwait.model.User;
import com.adwait.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

}
