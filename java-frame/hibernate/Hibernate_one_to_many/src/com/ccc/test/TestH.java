package com.ccc.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ccc.dao.SchoolDAO;
import com.ccc.dto.Grade;
import com.ccc.dto.Student;
import com.ccc.utils.HibernateUtils;

public class TestH {

	/**
	 * <set name="stu" lazy="false">
	 * Hibernate: select grade0_.gid as gid2_0_, grade0_.gname as gname2_0_ from Grade grade0_ where grade0_.gid=?
	   Hibernate: select stu0_.gid as gid1_, stu0_.sid as sid1_, stu0_.sid as sid0_0_, stu0_.sname as sname0_0_, stu0_.age as age0_0_, stu0_.birthday as birthday0_0_, stu0_.gid as gid0_0_ from Student stu0_ where stu0_.gid=?
		重点班
		4	 张三
		3	jack
	 * <set name="stu" lazy="false"  fetch="join">
	 * Hibernate: select grade0_.gid as gid2_1_, grade0_.gname as gname2_1_, stu1_.gid as gid3_, stu1_.sid as sid3_, stu1_.sid as sid0_0_, stu1_.sname as sname0_0_, stu1_.age as age0_0_, stu1_.birthday as birthday0_0_, stu1_.gid as gid0_0_ from Grade grade0_ left outer join Student stu1_ on grade0_.gid=stu1_.gid where grade0_.gid=?
		重点班
		3	jack
		4	 张三
	  注：fetch="join"：把两条语句连接起来了
	  注：fetch="select"：单表查询
	 */
	@Test
	public void testSave_grade_query_get(){
		Session session = HibernateUtils.getSession();
		Grade g = (Grade) session.get(Grade.class, 2);
		
		
		
		System.out.println(g.getGname());
		
		Set<Student> set = g.getStu();
		for (Student student : set) {
			System.out.println(student.getSid()+"\t"+student.getSname());
		}
		session.close();
		
	}
	/**
	 * 学生
	 */
	@Test
	public void testSave_grade_query_get1(){
		Session session = HibernateUtils.getSession();
		Student stu = (Student) session.get(Student.class, 3);
		
		System.out.println(stu.getSname()+"\t"+stu.getGrade().getGname());
		
		
		session.close();
		
	}
	
	/**
	 * get   grade
	 * load  student
	 * lazy="false"
	 */
	@Test
	public void testSave_grade_query1(){
		SchoolDAO dao = new SchoolDAO();
		Grade g = dao.getGradeById(2);
		System.out.println(g.getGname());
		
		Set<Student> set = g.getStu();
		for (Student student : set) {
			System.out.println(student.getSid()+"\t"+student.getSname());
		}
	}
	
	
	@Test
	public void testSave_stu_query1(){
		SchoolDAO dao = new SchoolDAO();
		Student stu = dao.getStudentById(1);
		System.out.println(stu.getSname());
		
		System.out.println(stu.getGrade().getGname());
		
	}
	
}
