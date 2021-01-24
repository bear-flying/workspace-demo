package com.jiangyu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuHibernateDao;

import com.jiangyu.pojo.Shop;
@Repository
public class ShopDao extends JiangYuHibernateDao<Shop> implements IShopDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int getTotalCountBySql(String sql){
		Session session = getSession();
		Object obj = session.createSQLQuery(sql).uniqueResult();
		return Integer.parseInt(obj.toString());
	}
	
}
