package com.jiangyu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuHibernateDao;

import com.jiangyu.pojo.Category;
@Repository
public class CategoryDao extends JiangYuHibernateDao<Category> implements ICategoryDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
