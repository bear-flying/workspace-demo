package com.baidu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuHibernateDao;

import com.baidu.pojo.Student;

@Repository
public class StudentDao extends JiangYuHibernateDao<Student> implements IStudentDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
}
