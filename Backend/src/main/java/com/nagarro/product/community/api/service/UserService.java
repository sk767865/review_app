package com.nagarro.product.community.api.service;

import java.util.Set;

import com.nagarro.product.community.api.entity.User;
import com.nagarro.product.community.api.entity.UserRole;
import com.nagarro.product.community.api.exceptions.UserFoundException;

public interface UserService {

	public User createUser(User user, Set<UserRole> userRoles) throws UserFoundException;
	
	public User getUser(String username);
	
	public void deleteUser(Long userId) throws Exception;
	
	public long getNumberOfUsers();
	
}
