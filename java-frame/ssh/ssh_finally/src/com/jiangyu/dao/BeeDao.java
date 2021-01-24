package com.jiangyu.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuHibernateDao;

import com.jiangyu.pojo.Bee;

@Repository
public class BeeDao extends JiangYuHibernateDao<Bee> implements IBeeDao {

	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession(){
		
		return sessionFactory.getCurrentSession();
		
	}
	
}
