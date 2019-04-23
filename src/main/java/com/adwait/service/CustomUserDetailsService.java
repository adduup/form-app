package com.adwait.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.adwait.model.CustomUserDetails;
import com.adwait.model.User;
import com.adwait.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optionalUser = userRepository.findByUsername(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("username not found"));

		return optionalUser.map(CustomUserDetails::new).get();

	}

}
