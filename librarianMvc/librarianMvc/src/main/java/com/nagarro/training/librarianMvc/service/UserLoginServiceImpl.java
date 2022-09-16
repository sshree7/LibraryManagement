package com.nagarro.training.librarianMvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.training.librarianMvc.dao.UserLoginDao;
import com.nagarro.training.librarianMvc.domain.User;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginDao userLoginDao;

	public boolean isValidUser(final String username, final String password) {
		final User user = this.userLoginDao.findByUsername(username);
		return username.equals(user.getUsername()) && password.equals(user.getPassword());
	}
}
