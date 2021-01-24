package com.ccc.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ccc.dao.SchoolDAO;
import com.ccc.dto.Grade;
import com.ccc.dto.Student;
import com.ccc.utils.HibernateUtils;

public class TestStudent {

	
	
	/**
	 * 增加班级
	 */
	@Test
	public void testSave_grade(){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Grade g = new Grade();
			g.setGname("1213");
			
			session.save(g);
			transaction.commit();
		} catch (Exception e) {
			
			transaction.rollback();
		}finally{
			
			session.close();
		}
		
	}
	
	/**
	 * 查询班级以及班级内的学生
	 */
	@Test
	public void testSave_grade_query_get(){
		Session session = HibernateUtils.getSession();
		Grade g = (Grade) session.get(Grade.class, 2);
		session.close();
		System.out.println(g.getGname());
		
		Set<Student> stu = g.getStu();
		for (Student student : stu) {
			System.out.println(student.getSname());
		}
	
		
		
		
	}
	/*
	 * 调用dao的
	 * 查询班级
	 */
	@Test
	public void testSave_grade_query_get_dao(){
		SchoolDAO dao = new SchoolDAO();
		Grade g = dao.getGradeById(1);
		
		System.out.println(g.getGname());
		
		Set<Student> stu = g.getStu();
		for (Student student : stu) {
			System.out.println(student.getSname());
		}
		
	}
	/*
	 * 调用dao的
	 * 学生的
	 */
	@Test
	public void testSave_stu_query_get_dao(){
		SchoolDAO dao = new SchoolDAO();
		Student s = dao.getStudentById(3);
		
		System.out.println(s.getSname());
		System.out.println(s.getGrade().getGname());
		
		
	}
}
