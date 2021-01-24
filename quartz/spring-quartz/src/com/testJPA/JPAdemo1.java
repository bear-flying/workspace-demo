package com.testJPA;


import javax.persistence.EntityManager;     
import javax.persistence.EntityManagerFactory;     
import javax.persistence.Persistence;     

import org.junit.BeforeClass;     
import org.junit.Test;      

import com.entity.Student;
 
public class JPAdemo1 {     
 
 @BeforeClass    
 public static void setUpBeforeClass() throws Exception {     
 }     
 
 @Test public void save(){     
     //对实体bean进行操作，第一步应该获取什么对象啊？     SessionFactory对象     
     //这里用获取的EntityManagerFactory对象，这可以把它看成跟Hibernate的SessionFactory对象差不多的东西     
     EntityManagerFactory factory = Persistence.createEntityManagerFactory("qqq");     
     EntityManager em = factory.createEntityManager();     
     em.getTransaction().begin();//开启事务     
     em.persist(new Student("张三"));     
     em.getTransaction().commit();     
     em.close();     
     factory.close();     
 
     //SessionFactory  -->  Session  -->  begin事务     
 }     
}  
