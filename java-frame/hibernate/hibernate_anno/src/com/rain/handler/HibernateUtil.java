package com.rain.handler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	
	private final static SessionFactory sessionFactory;
	
	static{
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
}
