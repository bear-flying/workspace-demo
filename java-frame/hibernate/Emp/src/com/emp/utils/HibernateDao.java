package com.emp.utils;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class HibernateDao<T> {
	/**
	 * 小白侠专用HibernateDao
	 */
	private Session session = null;
	
	/**
	 * 添加
	 */
	public void addOne(T entityObj){
		// 获取session
		session = HibernateUtils.getSession();
		// 打开事务
		Transaction tran = session.beginTransaction();
		try{
			session.save(entityObj);
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	/**
	 * 删除
	 */
	public void remove(T entityObj){
		// 获取session
		session = HibernateUtils.getSession();
		// 打开事务
		session.beginTransaction();
		try{
			session.delete(entityObj);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	/**
	 * 根据Integer类型的ID删除
	 */
	public void removeById(Integer id,Class<T> clazz){
		session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
	    Object obj = session.get(clazz, id);
		try {
		   session.delete(obj);
		   tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}finally{
			session.close();
		}
	}
	/**
	 * 根据类名和String类型的id 删除和批量删除
	 */
	public void deleAll(Class<T> clazz,String id){
		// 获取session
		session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		String name = clazz.getSimpleName();
		Query query = session.createQuery("delete from "+name+" where id in("+id+")");
		try {
			query.executeUpdate();//执行更新（删除和修改）
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}finally{
			session.close();
		}
	}
	
	/**
	 * 修改
	 */
	public void modify(T entityObj){
		// 获取session
		session = HibernateUtils.getSession();
		// 打开事务
		session.beginTransaction();
		try{
			session.update(entityObj);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	/**
	 * 根据get方法查一条
	 */
	public T findOneByGet(Class<? extends Object> entityClass,Serializable id){
		session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		T obj = (T) session.get(entityClass, id);
		session.close();
		return obj;
	}

	/**
	 * 根据load方法查一条
	 */
	public T findOneByLoad(Class<? extends Object> entityClass,Serializable id){
		session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		T obj = (T) session.load(entityClass, id);
		session.close();
		return obj;
	}
	
	/**
	 * 根据sql语句查询所有数据，并返回指定的对象集合(select *)
	 */
	public List<T> findAllBySql(Class<T> entityClass,String sql){
		// 获取session
		session = HibernateUtils.getSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(entityClass);
		@SuppressWarnings("unchecked")
		List<T> list = sqlQuery.list();
		session.close();
		return list;
	}
	
	/**
	 * 根据hql语句查询所有数据，并返回指定的对象集合
	 */
	public List<T> findAll(String hql){
		// 获取session
		session = HibernateUtils.getSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		session.close();
		return list;
	}
	
	/**
	 * 根据sql语句分页查询，并返回指定的对象集合(select *)
	 */
	public List<T> queryPageBySQL(Class<T> entityClass,String sql,int currentPageNo,int onePageCount){
		// 获取session
		session = HibernateUtils.getSession();
		//addEntity():查询的结果，往哪个类里装。使用SQL的时候需要，必须用这个方法指定。
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(sql).addEntity(
			entityClass).setFirstResult(onePageCount*(currentPageNo-1)).setMaxResults(onePageCount);
		@SuppressWarnings("unchecked")
		List<T> list = sqlQuery.list();
		session.close();
		return list;
	}
	
	/**
	 * 根据hql语句分页查询，并返回指定的对象集合
	 */
	public List<T> queryPage(String hql,int currentPageNo,int onePageCount){
		session = HibernateUtils.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(onePageCount*(currentPageNo-1)).setMaxResults(onePageCount);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		session.close();
		return list;
	}

	/**
	 * 根据类名分页查询，并返回指定的对象集合
	 */
	public List<T> getList(int currentPageNo,int onePageCount,Class<T> clazz){
		session = HibernateUtils.getSession();
		String name = clazz.getSimpleName();
		 Query query = session.createQuery("from "+name);
		if(currentPageNo>0){
			query.setFirstResult((currentPageNo-1)*onePageCount).setMaxResults(onePageCount);
		}
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		session.close();
		return list;	 
	}
	
	/**
	 * 根据类名 分页、模糊查询，并返回指定的对象集合
	 */
	public List<T> getList(int currentPageNo,int onePageCount,String hql,Class<T> clazz){
		session = HibernateUtils.getSession();
		String name = clazz.getSimpleName();
		//System.out.println(name);
		Query query = session.createQuery("from "+name+" where 1=1"+hql);
		if(currentPageNo>0){
			query.setFirstResult((currentPageNo-1)*onePageCount).setMaxResults(onePageCount);
		}
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		session.close();
		return list;
	}
	
	/**
	 * 分页支持：根据sql语句查询总记录数
	 */
	public int getTotalCountBySql(String sql){
		String coutSql = "select count(*) cn from("+sql+")";
		session = HibernateUtils.getSession();
		Object obj = session.createSQLQuery(coutSql).uniqueResult();
		session.close();
		return Integer.parseInt(obj.toString());
	}
	
	/**
	 * 分页支持：根据hql语句查询总记录数
	 */
	public int getTotalCountByHql(String hql){
		String coutSql = "select count(*) cn from("+hql+")";
		session = HibernateUtils.getSession();
		Object obj = session.createQuery(coutSql).uniqueResult();
		session.close();
		return Integer.parseInt(obj.toString());
	}
	
	/**
	 * 分页支持：根据类名获取总记录数
	 */
	public Long getCount(Class<T> clazz){
		// 获取session
		session = HibernateUtils.getSession();
		String name = clazz.getSimpleName();
		Query query = session.createQuery("select count(*) from "+name);
		Long count = (Long) query.uniqueResult();
		session.close();
		return count;
	}
	
	/**
	 * 分页支持：总记录数、模糊和唯一验证
	 */
	public Long getCount(String hql,Class<T> clazz){
		// 获取session
		session = HibernateUtils.getSession();
		String name = clazz.getSimpleName();
		Query query = session.createQuery("select count(*) from "+name+" where 1=1 "+hql);
		Long count = (Long) query.uniqueResult();
		session.close();
		return count;
	}
}
