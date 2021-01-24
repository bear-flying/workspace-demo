package com.bwie.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDaoImpl<T> implements BaseDao<T> {

	
	private Class<T> clazz ;
	
	@PersistenceContext
	private EntityManager em ;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl()
	{
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T t) {

		em.persist(t);
	}

	@Override
	public void update(T t) {

		em.merge(t);
	}

	@Override
	public void delete(T t) {

		em.remove(t);
	}

	@Override
	public T findById(String id) {
		
		return em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {

		String jpql = "from "+ clazz.getSimpleName() ;
		return (List<T>)em.createQuery(jpql).getResultList();
	}

}
