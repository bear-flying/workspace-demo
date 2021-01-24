package com.jiangyu.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuHibernateDao;

import com.jiangyu.pojo.Street;
@Repository
public class StreetDao extends JiangYuHibernateDao<Street> implements IStreetDao{

	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public List<Street> findStreetsByCondify(String sql){
		Session session = this.getSession();
		
		SQLQuery query = session.createSQLQuery(sql).addEntity(Street.class);
		List<Street> list = query.list();
		
		return list;
		
	}
}
