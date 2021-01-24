package com.jiangyu.utils;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * SSH验证工具类
 * 
 * 小白侠专用ssh----JiangYuSpringDao<T>
 * by 1405javaB 姜宇 
 * 飞天猫熊 2015-09-22 by JiangYu
 * 
 * 注意：不允许删改此注释！不允许改名！！！
 */
public class JiangYuSpringDao<T> extends HibernateDaoSupport implements JiangYuIspringDao<T> {
	

	public void setSuperSessionFactory(SessionFactory sessionFactory){
		
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:15:18
	 * 功能：查询所有数据
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(String hql){
		try{
			return getHibernateTemplate().find(hql);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:15:56
	 * 功能：保存（新增、添加）一条数据
	 * @param entityObj
	 */
	public void addOne(T entityObj){
		try{
			getHibernateTemplate().save(entityObj);
			//saveOrUpdate：有id就update，没id就save
			//getHibernateTemplate().saveOrUpdate(entityObj);
		
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:16:31
	 * 功能：修改一条数据
	 * @param entityObj
	 */
	public void modify(T entityObj){
		try{
			getHibernateTemplate().update(entityObj);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:16:46
	 * 功能：删除一条数据
	 * @param entityObj
	 */
	public void removeOne(T entityObj){
		try{
			getHibernateTemplate().delete(entityObj);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:23:17
	 * 功能：按ID 删除一条数据
	 * @param id
	 * @param entityClass
	 */
	public void removeOneById(Integer id,Class<T> entityClass){
		try{
			Object object = getHibernateTemplate().get(entityClass, id);
			getHibernateTemplate().delete(object);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:17:08
	 * 功能：按对象集合 批量添加
	 * @param entities
	 */
	public void addAll(Collection<T> entities){
		try{
			getHibernateTemplate().saveOrUpdateAll(entities);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:17:08
	 * 功能：按对象集合 批量删除
	 * @param entities
	 */
	public void removeAll(Collection<T> entities){
		try{
			getHibernateTemplate().deleteAll(entities);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:32:31
	 * 功能：按id字符串 批量删除
	 * @param entityClass
	 * @param ids
	 */
	public void removeAllById(Class<T> entityClass,String ids){
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String name = entityClass.getSimpleName();
		Query query = session.createQuery("delete from "+name+" where id in("+ids+")");
		query.executeUpdate();//执行更新（删除和修改）
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午5:15:46
	 * 功能：按id的Integer集合 批量删除
	 * @param ids
	 * @param entityClass
	 */
	public void removeBacth(final List<Integer> ids,final Class<T> entityClass) {
		getHibernateTemplate().execute(new HibernateCallback<T>() {

			public T doInHibernate(Session session)
					throws HibernateException, SQLException {
				String name = entityClass.getSimpleName();
				String hql = "delete from "+name+" where id in(:ids)";
				Query query = session.createQuery(hql);
				query.setParameterList("ids", ids);
				query.executeUpdate();
				return null;
			}
		});
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午5:15:46
	 * 功能：按id的String集合 批量删除
	 * @param ids
	 * @param entityClass
	 */
	public void removeBacth2(final List<String> ids,final Class<T> entityClass) {
		getHibernateTemplate().execute(new HibernateCallback<T>() {
			
			public T doInHibernate(Session session)
					throws HibernateException, SQLException {
				String name = entityClass.getSimpleName();
				String hql = "delete from "+name+" where id in(:ids)";
				Query query = session.createQuery(hql);
				List<Integer> list = new ArrayList<Integer>();
				for (String s : ids) {
					list.add(new Integer(s));
				}
				query.setParameterList("ids", list);
				query.executeUpdate();
				return null;
			}
		});
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:33:16
	 * 功能：get方式 查询一条
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T get(Class<T> entityClass,Serializable id){
		try{
			return (T) getHibernateTemplate().get(entityClass, id);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:33:34
	 * 功能：load方式查询一条
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T load(Class<T> entityClass,Serializable id){
		try{
			return (T) getHibernateTemplate().load(entityClass, id);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:59:26
	 * 功能：按条件查询一条
	 * @param hql
	 * @param args
	 * @return
	 */
	public T findOne(String hql,String...args){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query q = session.createQuery(hql);
		for(int i=0;i<args.length;i++){
			q.setString(i, args[i]);
		}
		@SuppressWarnings("unchecked")
		List<T> list = q.list();
		return list.get(0);
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:59:26
	 * 功能：按条件查询一条
	 * @param hql
	 * @param args
	 * @return
	 */
	public boolean findOneBoolean(String hql,String...args){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		
		Query q = session.createQuery(hql);
		for(int i=0;i<args.length;i++){
			q.setParameter(i, args[i]);//setString
		}
		@SuppressWarnings("unchecked")
		List<T> list = q.list();
		if(list.size()==0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午7:04:18
	 * 功能：按条件查询
	 * @param hql
	 * @param pramas
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public List<T[]> findByConditionSql(String sql, Object... pramas) {
		List<T> list = null ;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		for(int i=0;i<pramas.length;i++){
			query.setParameter(i, pramas[i]);
		}
		List<T[]> list2 = query.list();
//		try{
//			list  =	(List<T>) getHibernateTemplate().execute(new HibernateCallback<T>(){
//				public T doInHibernate(Session session)
//						throws HibernateException, SQLException {
//					SQLQuery query = session.createSQLQuery(sql);
//					for(int i=0;i<pramas.length;i++){
//						query.setParameter(i, pramas[i]);
//					}
//					return (T) query.list();
//				}	
//			});
//		}catch(DataAccessException e){
//			e.printStackTrace();
//		}
		return list2;
	}
	
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午7:04:18
	 * 功能：按条件查询
	 * @param hql
	 * @param pramas
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByConditionHql(final String hql, final Object... pramas) {
		List<T> list = null ;
		try{
			list  =	(List<T>) getHibernateTemplate().execute(new HibernateCallback<T>(){
				public T doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					for(int i=0;i<pramas.length;i++){
						query.setParameter(i, pramas[i]);
					}
					return (T) query.list();
				}	
			});
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:47:09
	 * 功能：分页支持 获取总记录数
	 * @param entityClass
	 * @return
	 */
	public int getCount(Class<T> entityClass){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String name = entityClass.getSimpleName();
		Query query = session.createQuery("select count(*) from "+name);
		Long count = (Long) query.uniqueResult();
		return count.intValue();
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:47:09
	 * 功能：分页支持 按HQL获取总记录数
	 * @param entityClass
	 * @return
	 */
	public int getCount(String hql){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		
		Query query = session.createQuery(hql);
		
		Long count = (Long) query.uniqueResult();
		return count.intValue();
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:49:43
	 * 功能：根据SQL语句分页查询
	 * @param hql
	 * @param currentPageNo
	 * @param onePageCount
	 * @return
	 */
	public List<T> queryBySql(final String sql,final Class<T> entityClass){
		try{
			getHibernateTemplate().execute(new HibernateCallback<T>() {
				@SuppressWarnings("unchecked")
				public T doInHibernate(Session session) throws HibernateException,SQLException {
					//匿名内部类引用上边的 必须是final的
					SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(entityClass);
					return (T) sqlQuery.list();
				}
			});
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:49:43
	 * 功能：根据HQL语句分页查询
	 * @param hql
	 * @param currentPageNo
	 * @param onePageCount
	 * @return
	 */
	public List<T> queryPage(String hql,int currentPageNo,int onePageCount){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(onePageCount*(currentPageNo-1)).setMaxResults(onePageCount);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:49:43
	 * 功能：根据类名分页查询
	 * @param hql
	 * @param currentPageNo
	 * @param onePageCount
	 * @return
	 */
	public List<T> queryPage(Class<T> entityClass,int currentPageNo,int onePageCount){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String name = entityClass.getSimpleName();
		Query query = session.createQuery("from "+name);
		if(currentPageNo>0){
			query.setFirstResult((currentPageNo-1)*onePageCount).setMaxResults(onePageCount);
		}
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:49:43
	 * 功能：根据类名分页查询
	 * @param hql
	 * @param currentPageNo
	 * @param onePageCount
	 * @return
	 */
	public List<T> getPageList(Class<T> entityClass,int currentPageNo,int onePageCount,String hql){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String name = entityClass.getSimpleName();
		Query query = session.createQuery(" from "+name+" where 1=1 "+hql);
		if(currentPageNo>0){
			query.setFirstResult((currentPageNo-1)*onePageCount).setMaxResults(onePageCount);
		}
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午5:09:13
	 * 功能：模糊查询 带分页
	 * @param entityClass
	 * @param currentPageNo
	 * @param onePageCount
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> getPageList(final Class<T> entityClass,final String column,
			final int currentPageNo,final int onePageCount,final String condition) {
		
		return (List<T>) getHibernateTemplate().execute(
			new HibernateCallback<T>(){
				public T doInHibernate(Session session)throws HibernateException, SQLException {
					List<String> list = new ArrayList<String>();
					String name = entityClass.getSimpleName();
					String hql = "from "+name+" where 1=1 ";
					if(condition != null && condition.length() > 0) {
						hql += " and "+column+" like ? ";
						list.add("%" + condition + "%");		
					}
				Query query = session.createQuery(hql);
				query.setFirstResult((currentPageNo-1)*onePageCount)
						.setMaxResults(onePageCount);
				for (int i = 0; i < list.size(); i++) {
					query.setParameter(i, list.get(i));
				}
				return (T) query.list();
			}	
		});
	}
	
}
