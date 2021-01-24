package com.maomao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private final static Configuration configure = new Configuration();//
	
	private static SessionFactory factory = null;
	
	static{
		configure.configure();//初始化
		factory = configure.buildSessionFactory();//构建session-factory
	}
	
	public static Session getSession(){
		return factory.openSession();
	}
	
}
