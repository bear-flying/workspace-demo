package com.ccc.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ccc.dto.Grade;
import com.ccc.dto.Student;
import com.ccc.utils.HibernateUtils;

public class TestHH {

	@Test
	public void testDelete(){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		
		Grade grade = (Grade) session.load(Grade.class, 2);
		
		session.delete(grade);
		
		
		transaction.commit();
		session.close();
	}
	
	
	/**
	 * 查询班级以及班级内的学生
	 */
	@Test
	public void testSave_grade_query_get(){
		Session session = HibernateUtils.getSession();
		Grade g = (Grade) session.get(Grade.class, 1);
		session.close();
		System.out.println(g.getGname());
		
		Set<Student> stu = g.getStu();
		
		for (Student student : stu) {
			System.out.println(student.getSname()+"\t"+student.getAge());
		}
		
	}
}
