package com.action;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Student;

public class SrudentAction {
	public String persistStu() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("qqq");     
	     EntityManager em = factory.createEntityManager();     
	     em.getTransaction().begin();//开启事务     
	     em.persist(new Student("张三"));     
	     em.getTransaction().commit();     
	     em.close();     
	     factory.close(); 
		return null;
	}
}
