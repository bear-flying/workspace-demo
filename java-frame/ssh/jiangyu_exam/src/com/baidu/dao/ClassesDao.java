package com.baidu.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuHibernateDao;

import com.baidu.pojo.Classes;

@Repository
public class ClassesDao extends JiangYuHibernateDao<Classes> implements IClassesDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Classes> findAllBySql(Class<Classes> entityClass,String sql){
		// ªÒ»°session
		Session session = getSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(entityClass);
		@SuppressWarnings("unchecked")
		List<Classes> list = sqlQuery.list();
		return list;
	}
}
