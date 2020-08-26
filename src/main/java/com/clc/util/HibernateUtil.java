package com.clc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		sessionFactory = (SessionFactory) new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
		return sessionFactory;
	}			

}
