package com.nagarro.product.community.api.dao;
import com.nagarro.product.community.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
