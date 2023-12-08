package com.nagarro.product.community.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nagarro.product.community.api.dao.RoleDao;
import com.nagarro.product.community.api.dao.UserDao;
import com.nagarro.product.community.api.entity.User;
import com.nagarro.product.community.api.entity.UserRole;
import com.nagarro.product.community.api.exceptions.UserFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws UserFoundException {
		User userLocal = this.userDao.findByUsername(user.getUsername());
		if (userLocal != null) {
				throw new UserFoundException();
		} else {
			for (UserRole i : userRoles) {
				roleDao.save(i.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			userLocal = this.userDao.save(user);
		}
		return userLocal;
	}

	@Override
	public User getUser(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) throws Exception {
		try{
			this.userDao.deleteById(userId);	
		} catch(EmptyResultDataAccessException e) {
			throw new Exception("Data does not exist");
		}
	}

	@Override
	public long getNumberOfUsers() {
		return userDao.count();
	}

}
