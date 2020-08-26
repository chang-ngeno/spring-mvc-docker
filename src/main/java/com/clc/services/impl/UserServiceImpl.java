package com.clc.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clc.business.UserBO;
import com.clc.model.User;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	UserBO userBO;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = new User();
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		try {
			user = userBO.findUserByUsername(username);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

}
