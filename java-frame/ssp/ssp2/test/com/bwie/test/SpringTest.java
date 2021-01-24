package com.bwie.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	@Test
	public void testDataSource() {

		
		DataSource source = context.getBean(DataSource.class);
		System.out.println(source);
	
	}

}
