package com.bbb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bbb.dto.Card;
import com.bbb.dto.Person;
import com.bbb.utils.HibernateUtils;

public class PersonDAO {

	public void savePerson(Card card,Person person){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		
		//通过set方法建立主键关联关系
		card.setPerson(person);
		session.save(card);
		
		transaction.commit();
		session.close();
	}
	
	//删除
	public void deletePerson(Integer id){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		
		//删除
		Person person = (Person) session.load(Person.class, id);
		session.delete(person);
		
		transaction.commit();
		session.close();
	}
	
	//按id查询
	public Person getPersonById(Integer id){
		Session session = HibernateUtils.getSession();
		return (Person) session.load(Person.class, id);
	}
	
	
	//修改
	public void updatePerson(Card card,Person person){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		
		//通过set方法建立主键关联关系
		card.setPerson(person);
		session.update(card);
		
		transaction.commit();
		session.close();
	}
}
