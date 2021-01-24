package com.jiangyu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuHibernateDao;

import com.jiangyu.pojo.BeeKind;
@Repository
public class BeeKindDao extends JiangYuHibernateDao<BeeKind> implements IBeeKindDao {

	
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession(){
		
		return sessionFactory.getCurrentSession();
		
	}
	
}
