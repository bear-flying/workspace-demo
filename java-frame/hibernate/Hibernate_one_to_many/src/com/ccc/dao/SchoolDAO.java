package com.ccc.dao;

import org.hibernate.Session;

import com.ccc.dto.Grade;
import com.ccc.dto.Student;
import com.ccc.utils.HibernateUtils;

public class SchoolDAO {

	//根据班级id查找班级对象
	public Grade getGradeById(int gid){
		Session session = HibernateUtils.getSession();
		Grade g = (Grade) session.get(Grade.class, gid);
		session.close();
		return g;
	}
	
	//根据学生id查询学生对象
	public Student getStudentById(int sid){
		Session session = HibernateUtils.getSession();
		Student stu = (Student) session.get(Student.class, sid);
		session.close();
		return stu;
	}
}
