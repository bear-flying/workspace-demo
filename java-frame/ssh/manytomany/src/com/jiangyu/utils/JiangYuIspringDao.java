package com.jiangyu.utils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface JiangYuIspringDao<T> {

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:15:18
	 * 功能：查询所有数据
	 * @param hql
	 * @return
	 */
	
	public abstract List<T> findAll(String hql);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:15:56
	 * 功能：保存（新增、添加）一条数据
	 * @param entityObj
	 */
	public abstract void addOne(T entityObj);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:16:31
	 * 功能：修改一条数据
	 * @param entityObj
	 */
	public abstract void modify(T entityObj);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:16:46
	 * 功能：删除一条数据
	 * @param entityObj
	 */
	public abstract void removeOne(T entityObj);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:23:17
	 * 功能：按ID 删除一条数据
	 * @param id
	 * @param entityClass
	 */
	public abstract void removeOneById(Integer id, Class<T> entityClass);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:17:08
	 * 功能：按对象集合 批量添加
	 * @param entities
	 */
	//public abstract void addAll(Collection<T> entities);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:17:08
	 * 功能：按对象集合 批量删除
	 * @param entities
	 */
	public abstract void removeAll(Collection<T> entities);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:32:31
	 * 功能：按id字符串 批量删除
	 * @param entityClass
	 * @param ids
	 */
	public abstract void removeAllById(Class<T> entityClass, String ids);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午5:15:46
	 * 功能：按id的Integer集合 批量删除
	 * @param ids
	 * @param entityClass
	 */
	public abstract void removeBacth(final List<Integer> ids,
			final Class<T> entityClass);
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午5:15:46
	 * 功能：按id的Integer集合 批量删除
	 * @param ids
	 * @param entityClass
	 */
	public abstract void removeBacth2(final List<String> ids,
			final Class<T> entityClass);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:33:16
	 * 功能：get方式 查询一条
	 * @param entityClass
	 * @param id
	 * @return
	 */
	
	public abstract T get(Class<T> entityClass, Serializable id);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:33:34
	 * 功能：load方式查询一条
	 * @param entityClass
	 * @param id
	 * @return
	 */
	
	public abstract T load(Class<T> entityClass, Serializable id);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:59:26
	 * 功能：按条件查询一条
	 * @param hql
	 * @param args
	 * @return
	 */
	public abstract T findOne(String hql, String... args);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:59:26
	 * 功能：按条件查询一条
	 * @param hql
	 * @param args
	 * @return
	 */
	public abstract boolean findOneBoolean(String hql, String... args);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午7:04:18
	 * 功能：按条件查询
	 * @param hql
	 * @param pramas
	 * @return
	 */
	
	public abstract List<T> findByConditionHql(final String hql,
			final Object... pramas);

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午7:04:18
	 * 功能：按条件查询
	 * @param hql
	 * @param pramas
	 * @return
	 */
	
	public abstract List<T[]> findByConditionSql(String sql,
			Object... pramas);
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:47:09
	 * 功能：分页支持 获取总记录数
	 * @param entityClass
	 * @return
	 */
	public abstract int getCount(Class<T> entityClass);
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-10-13下午4:47:09
	 * 功能：分页支持 获取总记录数
	 * @param entityClass
	 * @return
	 */
	public abstract int getCount(String hql);

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
	public abstract List<T> queryBySql(final String sql,
			final Class<T> entityClass);

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
	public abstract List<T> queryPage(String hql, int currentPageNo,
			int onePageCount);

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
	public abstract List<T> queryPage(Class<T> entityClass, int currentPageNo,
			int onePageCount);

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
	public abstract List<T> getPageList(Class<T> entityClass,
			int currentPageNo, int onePageCount, String hql);

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

	public abstract List<T> getPageList(final Class<T> entityClass,
			final String column, final int currentPageNo,
			final int onePageCount, final String condition);

}