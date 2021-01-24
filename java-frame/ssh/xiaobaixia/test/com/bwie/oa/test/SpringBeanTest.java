package com.bwie.oa.test;


import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringBeanTest {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//	private RoleService roleService ;
	
	@Test
	public void testDataSource() {
		
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource);
	}
	


}
