package com.clc.business;

import com.clc.model.User;


public interface UserBO {
	public boolean registerUser(User user) throws Exception;

	public boolean login(User user) throws Exception;

	public User findUserByUsername(String username) throws Exception;
}
