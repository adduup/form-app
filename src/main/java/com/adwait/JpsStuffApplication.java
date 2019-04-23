package com.adwait;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adwait.model.Role;
import com.adwait.model.User;
import com.adwait.service.UserService;

@SpringBootApplication

public class JpsStuffApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(JpsStuffApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role();
		role.setRole("EMPLOYEE");
		User user = new User();
		user.setFirstName("Adwait");
		user.setLastName("uprety");
		user.setPassword("{noop}billy");
		user.setEmail("google@goole.com");
		user.setUsername("babu");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		userService.saveUser(user);

	}

}
