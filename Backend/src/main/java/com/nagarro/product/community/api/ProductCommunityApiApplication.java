package com.nagarro.product.community.api;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nagarro.product.community.api.entity.Role;
import com.nagarro.product.community.api.entity.User;
import com.nagarro.product.community.api.entity.UserRole;
import com.nagarro.product.community.api.exceptions.UserFoundException;
import com.nagarro.product.community.api.service.UserService;

@SpringBootApplication
public class ProductCommunityApiApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductCommunityApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
		User user = new User();
		
		user.setFirstName("admintwo");
		user.setLastName("admintwo");
		user.setUsername("admintwo");
		user.setPassword(this.bCryptPasswordEncoder.encode("admintwo"));
		user.setEmail("admintwo@gmail.com");
		
		Role role1 = new Role();
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		
		userRoles.add(userRole);
		
		this.userService.createUser(user, userRoles);
		} catch(UserFoundException e) {
			System.out.println("Admin already created with this name Please try another name for admin");
		}
		
	}

}
