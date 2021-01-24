package com.bee.utils;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class HibernateDao<T> {
	/**
	 * Hibernate工具类
	 * 
	 * 小白侠专用DaoHibernateDao<T>
	 * by 1405javaB 姜宇 
	 * 飞天猫熊 2015-09-07 by JiangYu
	 */
	private Session session = null;

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:39:36
	 * 功能：添加
	 * @param entityObj：实体类对象
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:39:36
	 * 功能：删除
	 * @param entityObj：实体类对象
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:41:06
	 * 功能：根据Integer类型的ID删除
	 * @param id 
	 * @param clazz
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:41:51
	 * 功能：根据类名和String类型的id 删除和批量删除
	 * @param clazz
	 * @param id
	 */
	public void removeAll(Class<T> clazz,String id){
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:42:38
	 * 功能：修改
	 * @param entityObj：实体类对象
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:53:31
	 * 功能：根据get方法查一条
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T findOneByGet(Class<? extends Object> entityClass,Serializable id){
		session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		T obj = (T) session.get(entityClass, id);
		session.close();
		return obj;
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:54:18
	 * 功能：根据load方法查一条
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T findOneByLoad(Class<? extends Object> entityClass,Serializable id){
		session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		T obj = (T) session.load(entityClass, id);
		session.close();
		return obj;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:54:57
	 * 功能：根据sql语句查询所有数据，并返回指定的对象集合(select *)
	 * @param entityClass
	 * @param sql
	 * @return
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:55:11
	 * 功能：根据HQL带条件查询一条
	 * @param hql
	 * @param args
	 * @return
	 */
	public T findOneByHql(String hql,String...args){
		// 获取session
		session = HibernateUtils.getSession();
		Query q = session.createQuery(hql);
		for(int i=0;i<args.length;i++){
			q.setString(i, args[i]);
		}
		@SuppressWarnings("unchecked")
		List<T> list = q.list();
		session.close();
		return list.get(0);
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:55:11
	 * 功能：根据HQL带条件查询一条
	 * @param hql
	 * @param args
	 * @return
	 */
	public boolean findOneByHql2(String hql,String...args){
		// 获取session
		session = HibernateUtils.getSession();
		Query q = session.createQuery(hql);
		for(int i=0;i<args.length;i++){
			q.setParameter(i, args[i]);//setString
		}
		@SuppressWarnings("unchecked")
		List<T> list = q.list();
		session.close();
		if(list.size()==0){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:55:24
	 * 功能：根据SQL带条件查询一条
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object findOneBySql(String sql,String...args){
		session = HibernateUtils.getSession(); 
		Query query = session.createSQLQuery(sql);
				
		 for(int i=0;i<args.length;i++){
			 query.setParameter(i, args[i]);
		 }
	
		Object result =  query.uniqueResult();
		session.close();

		return result;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:55:24
	 * 功能：根据SQL带条件查询一条
	 * @param sql
	 * @param args
	 * @return
	 */
	public T findOneBySql(Class<T> entityClass,String sql,String...args){
		session = HibernateUtils.getSession(); 
		Query query = session.createSQLQuery(sql).addEntity(entityClass);
		
		for(int i=0;i<args.length;i++){
			query.setParameter(i, args[i]);
		}
		
		@SuppressWarnings("unchecked")
		T result =  (T)query.uniqueResult();
		session.close();
		
		return result;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:56:17
	 * 功能：根据hql语句查询所有数据，并返回指定的对象集合
	 * @param hql
	 * @return
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:56:35
	 * 功能：根据sql语句分页查询，并返回指定的对象集合(select *)
	 * @param entityClass
	 * @param sql
	 * @param currentPageNo
	 * @param onePageCount
	 * @return
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:56:50
	 * 功能：根据hql语句分页查询，并返回指定的对象集合
	 * @param hql
	 * @param currentPageNo
	 * @param onePageCount
	 * @return
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:57:02
	 * 功能：根据类名分页查询，并返回指定的对象集合
	 * @param currentPageNo
	 * @param onePageCount
	 * @param clazz
	 * @return
	 */
	public List<T> getPageList(int currentPageNo,int onePageCount,Class<T> entityClass){
		session = HibernateUtils.getSession();
		String name = entityClass.getSimpleName();
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
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:57:38
	 * 功能：根据类名 分页、模糊查询，并返回指定的对象集合
	 * @param currentPageNo
	 * @param onePageCount
	 * @param hql
	 * @param clazz
	 * @return
	 */
	public List<T> getPageList(Class<T> entityClass,int currentPageNo,int onePageCount,String hql){
		session = HibernateUtils.getSession();
		String name = entityClass.getSimpleName();
		//System.out.println(name);
		Query query = session.createQuery("from "+name+" where 1=1 "+hql);
		if(currentPageNo>0){
			query.setFirstResult((currentPageNo-1)*onePageCount).setMaxResults(onePageCount);
		}
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		session.close();
		return list;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:57:55
	 * 功能：分页支持：根据sql语句查询总记录数
	 * @param sql
	 * @return
	 */
	public int getTotalCountBySql(String sql){
		String coutSql = "select count(*) cn from("+sql+")";
		session = HibernateUtils.getSession();
		Object obj = session.createSQLQuery(coutSql).uniqueResult();
		session.close();
		return Integer.parseInt(obj.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:58:14
	 * 功能：分页支持：根据hql语句查询总记录数
	 * @param hql
	 * @return
	 */
	public int getTotalCountByHql(String hql){
		String coutSql = "select count(*) cn from("+hql+")";
		session = HibernateUtils.getSession();
		Object obj = session.createQuery(coutSql).uniqueResult();
		session.close();
		return Integer.parseInt(obj.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:58:31
	 * 功能：分页支持：根据类名获取总记录数
	 * @param clazz
	 * @return
	 */
	public int getCount(Class<T> entityClass){
		// 获取session
		session = HibernateUtils.getSession();
		String name = entityClass.getSimpleName();
		Query query = session.createQuery("select count(*) from "+name);
		Long count = (Long) query.uniqueResult();
		session.close();
		return count.intValue();
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-9-07下午4:58:57
	 * 功能：分页支持：总记录数、模糊和唯一验证
	 * @param hql
	 * @param clazz
	 * @return
	 */
	public int getCount(String hql,Class<T> entityClass){
		// 获取session
		session = HibernateUtils.getSession();
		String name = entityClass.getSimpleName();
		Query query = session.createQuery("select count(*) from "+name+" where 1=1 "+hql);
		Long count = (Long) query.uniqueResult();
		session.close();
		return count.intValue();
	}
}
