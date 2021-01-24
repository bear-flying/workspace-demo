package com.baidu.bmx.utils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 * 作者：蔡子鲁
 * 功能：JPA+SpringMVC+Spring的工具包持久层
 * 时间：2015年10月23日
 */
@SuppressWarnings("unchecked")
public class BaseDao<T> implements Dao<T> {

	
	private Class<T> clazz ;
	
	@PersistenceContext
	private EntityManager em ;
	
	public BaseDao()
	{
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}
	
	/**
	 * 作者：蔡子鲁
	 * 功能：CRUD
	 * 时间：2015年10月23日
	 */
	//添加
	@Override
	public void save(T t) {
		em.persist(t);
	}

	//更新
	@Override
	public void update(T t) {
		em.merge(t);
	}

	//删除
	@Override
	public void delete(T t) {
		em.remove(t);
	}

	//按ID查找
	@Override
	public T findById(int id) {
		
		return em.find(clazz, id);
	}

	//查找所有
	@Override
	public List<T> findAll() {
		String jpql = "from "+ clazz.getSimpleName() ;
		return (List<T>)em.createQuery(jpql).getResultList();
	}

	//分页查找
	@Override
	public PageBean<T> findByPage(int page, int pageSize, String url) {
		
		PageBean<T> pageBean=new PageBean<T>();
		String name=clazz.getSimpleName();
		
		//第几页
		pageBean.setPage(page);
		//每页多少条数据
		pageBean.setPageSize(pageSize);
		pageBean.setUrl(url);
		
		//From Employee e left outer join fetch e.dept
		String hql="from " + name;
		Query query = em.createQuery(hql).setFirstResult((page-1)*pageSize).setMaxResults(pageSize);
		List<T> list = query.getResultList();
		
		Long totalNum = (Long) em.createQuery("select count(*) from "+name).getSingleResult();
		int totalNums = totalNum.intValue();
		int totalPages=totalNums%pageSize==0 ? totalNums/pageSize : totalNums/pageSize+1;
		
		//总页数
		pageBean.setTotalPages(totalPages);
		//总记录数
		pageBean.setTotalNums(totalNums);
		//存放当前页数据的集合
		pageBean.setList(list);
		pageBean.setActualPageSize(list.size());
		
		return pageBean;
	}

}
