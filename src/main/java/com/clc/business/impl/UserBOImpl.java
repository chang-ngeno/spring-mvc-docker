package com.clc.business.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.clc.business.UserBO;
import com.clc.model.User;
import com.clc.util.HibernateUtil;

@Service
public class UserBOImpl implements UserBO {
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	public boolean registerUser(User user) throws Exception {
		boolean results = false;
		User foundUser = findUserByUsername(user.getUsername());
		if (foundUser == null) {
			user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			results = true;
		} else {
			results = false;
		}
		return results;
	}

	@SuppressWarnings("rawtypes")
	public boolean login(User user) throws Exception {
		boolean allowLogin = false;
		// User user = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM user U WHERE U.username =: username and U.password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		List results = query.list();

		if (!results.isEmpty())
			allowLogin = true;
		session.close();
		return allowLogin;
	}

	@SuppressWarnings("rawtypes")
	public User findUserByUsername(String username) throws Exception {
		User user = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM user U WHERE U.username =: username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		List results = query.getResultList();
		if (!results.isEmpty()) {
			user = (User) results.get(0);
		}
		session.close();
		return user;
	}

}
