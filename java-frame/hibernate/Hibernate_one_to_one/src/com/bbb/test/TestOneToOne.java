package com.bbb.test;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.bbb.dto.Card;
import com.bbb.dto.Person;

public class TestOneToOne {

	/**
	 * Hibernate: insert into t_person (name, age) values (?, ?)
	 * Hibernate: insert into t_card (cname, cid) values (?, ?)
	 */
	/**
	 * 添加
	 */
	@Test
	public void testSave(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//保存身份证
		Card card = new Card();
		card.setCname("333");
		
		Person person = new Person();
		person.setName("张三丰3");
		person.setAge(140);
		
		//通过set方法建立主键关联关系
		card.setPerson(person);
		
		session.save(card);
		
		
		
		transaction.commit();
		session.close();
	}
	/**
	 * 测试1,错误测试
	 */
	@Test
	public void testSave1(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//保存身份证
		Card card = new Card();
		card.setCname("222222");
		
		Person person = new Person();
		person.setName("张三丰222");
		person.setAge(140);
		
		//通过set方法建立主键关联关系
		card.setPerson(person);
		
		session.save(person);
		
		
		
		transaction.commit();
		session.close();
	}
	
	
	/**
	 * 修改级联
	 * . 简述Hibernate中级联关键字以及可以配置哪些值?(5分)
		Cascade:
		all:代表在所有的情况下都执行级联操作
		none:在所有情况下都不执行级联操作(默认值)
		save-update:在保存和更新时执行级联操作
		delete:在删除时执行级联操作
	 */
	@Test
	public void testUpdate(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//修改
		Card card = new Card();
		card.setCname("666");
		card.setCid(3);
		
		
		Person person = new Person();
		person.setName("张三丰66");
		person.setAge(14);
		person.setId(3);
		
		//通过set方法建立主键关联关系
		card.setPerson(person);
		
		session.update(card);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * 删除person　cascade="all"  person　cascade="delete"
	 */
	@Test
	public void testDelete(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//删除
		Person person = (Person) session.load(Person.class, 3);
		session.delete(person);
		
		transaction.commit();
		session.close();
	}
	/**
	 * 删除card　　cascade="all"
	 */
	@Test
	public void testDelete1(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//删除
		Card card = (Card) session.load(Card.class, 1);
		session.delete(card);
		
		transaction.commit();
		session.close();
	}
	
	
	
	/**
	 * get查询person
	 * 重点
	 */
	@Test
	public void test_get(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		
		//get
		Person person = (Person) session.get(Person.class, 2);
		System.out.println(person.getName()+"\t"+person.getCard().getCname()+"\t"+person.getCard().getCid());
		
		session.close();
	}
	
	/**
	 * get查询card
	 */
	@Test
	public void test_get1(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//get
		Card card = (Card) session.get(Card.class,2);
		System.out.println(card.getPerson().getName()+"\t"+card.getCname());
		transaction.commit();
		session.close();
	}
	
	/**
	 * load加载
	 */
	@Test
	public void test_load(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//load
		Person person = (Person) session.load(Person.class, 2);
		System.out.println(person.getName()+"\t"+person.getCard().getCname());
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * load查询card
	 */
	@Test
	public void test_get2(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//get
		Card card = (Card) session.load(Card.class,2);
		System.out.println(card.getPerson().getName()+"\t"+card.getCname());
		transaction.commit();
		session.close();
	}
	
	/**
	 * 查询所有all
	 */
	@Test
	public void test_all(){
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Person";
		List<Person> list = session.createQuery(hql).list();
		for (Person person : list) {
			System.out.println(person.getName()+"\t"+person.getCard().getCname());
		}
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * 查询一条记录uniqueResult
	 */
	@Test
	public void test_uniqueResult(){
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "from Person where id=4";
		Person person = (Person) session.createQuery(hql).uniqueResult();
		System.out.println(person.getName()+"\t"+person.getCard().getCname());
		
		
		transaction.commit();
		session.close();
	}
	
	
	
	
	
}
