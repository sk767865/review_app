package com.nagarro.product.community.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.product.community.api.entity.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
