package com.bbb.utils;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	public static Session getSession(){
		return new Configuration().configure().buildSessionFactory().openSession();
	}
}
