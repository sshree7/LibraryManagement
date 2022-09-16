package com.nagarro.training.librarianMvc.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.training.librarianMvc.domain.User;

public interface UserLoginDao extends CrudRepository<User, String> {
	
	public User findByUsername(final String username);

}