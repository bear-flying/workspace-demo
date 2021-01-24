package com.ccc.dao;

import java.util.Set;

import org.hibernate.Session;

import com.ccc.dto.Courses;
import com.ccc.dto.Grade;
import com.ccc.dto.Student;
import com.ccc.utils.HibernateUtils;

public class SchoolDAO {

	public Grade getGradeById(int gid){
		Session session = HibernateUtils.getSession();
		Grade g = (Grade) session.get(Grade.class, gid);
		session.close();
		return g;
	}
	
	public Student getStudentById(int sid){
		Session session = HibernateUtils.getSession();
		Student stu = (Student) session.get(Student.class, sid);
		session.close();
		return stu;
	}
	
	public Courses getCoursesById(int cid){
		Session session = HibernateUtils.getSession();
		Courses cou = (Courses) session.get(Courses.class, cid);
		session.close();
		return cou;
	}
	
	
	/**
	 * 功能：通过学生id找到学生所选的课程
	 * @param sid
	 * @return
	 */
	public String[] getStudentById_course(int sid){
		//得到session
		Session session = HibernateUtils.getSession();
		//通过学生id找到学生对象
		Student student = this.getStudentById(sid);
		
		//通过学生找到对应的课程集合
		Set<Courses> cou = student.getCou();
		//课程数组的长度
		int len = 0;
		for (Courses courses : cou) {
			len++;
		}
		//定义课程数组，并装载课程
		String[] course = new String[len];
		int i = 0;
		for (Courses courses : cou) {
			course[i] = courses.getCname();
			i++;
		}
		//返回学生选的课程数组
		return course;
	}
	
	
	/**
	 * 功能：通过学生id找到学生所选的课程
	 * 
	 * @param sid
	 * @return
	 */
	public String[] getCoursesByStudentId(Integer id){
		//通过学生id得到学生对象
		Student student = this.getStudentById(1);
		//通过学生对象得到课程集合
		Set<Courses> cou = student.getCou();
		//定义课程数组的长度
		int len = 0;
		for (Courses courses : cou) {
			len++;
		}
		//定义一个课程数组，并装载课程
		String[] course = new String[len];
		int i=0;
		for (Courses courses : cou) {
			course[i] = courses.getCname();
			i++;
		}
		//返回课程的数组
		return course;
	}
	
	/**
	 * 功能：通过学生id找到学生所选的课程
	 * 
	 * @param sid
	 * @return
	 */
	public Set getCourses(Integer sid){
		//通过学生id得到学生对象
		Student student = this.getStudentById(1);
		//通过学生对象得到课程集合
		Set<Courses> cou = student.getCou();
		return cou;
	}
	
	
	
	
	
}
