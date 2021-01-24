package com.zh.utils;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.zh.utils.HibernateUtils;
import com.zh.utils.PageBean;


public class BaseDao {
	
	/**
	 * 功能：查询全部数据( 以List形式返回 + 无分页 )
	 * 作者：张强
	 * 日期：2015-9-15
	 * @user lenovo	
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz){
			
		Session session = HibernateUtils.getFactory().openSession();
		
		List<T> list = null;
		try {list = session.createCriteria(clazz).list();
		} catch (Exception e) {System.err.print("when execute getList catch an error!");
			System.out.println(e.getMessage());
		}finally{
			if(session != null && session.isOpen())session.close();
		}
		
		return list;					
	}
	
	/**
	 * 功能：查询数据(以pageBean形式返回+分页)
	 * 作者：张强
	 * 日期：2015-9-15
	 * @user lenovo	
	 */
	@SuppressWarnings("unchecked")
	public <T> PageBean<T> findByPage(Integer page,Integer pageSize,Class<T> clazz){	
		
		List<T> list = null;Integer totalNums = 0;
		Session session = HibernateUtils.getFactory().openSession();
		
		try {
			totalNums = findAll(clazz) != null ? findAll(clazz).size():0;
			list = session.createCriteria(clazz).setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();
		} catch (Exception e) {
			System.out.println("when EXECUTE findByPage : "+e.getMessage());}
		if(list == null || list.isEmpty())System.out.println("数据库为空或Page超出总页数范围!");
		
		return pageBean(page, pageSize, totalNums, list);					
	} 
		
	/**
	 * 功能：查询数据(以pageBean形式返回+分页+模糊查询)
	 * 作者：张强
	 * 日期：2015-9-15
	 * @user lenovo	
	 */
	@SuppressWarnings("unchecked")
	public <T> PageBean<T> findByPageAndCondition(Integer page,Integer pageSize,Class<T> clazz,Map<String,String> map){	
		
		List<T> list = null;Integer totalNums = 0;
		Session session = HibernateUtils.getFactory().openSession();

		try {Criteria query = session.createCriteria(clazz);
			if(map != null && map.size()>0){
				for (String key : map.keySet()) {
					query.add(Restrictions.like(key, ("%" + map.get(key).trim() + "%")));
				}
			}
			totalNums = query.list() != null ? query.list().size() : 0;
			list = query.setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();	
		} catch (Exception e) {
			System.out.println("whern EXECUTE findByPageAndCondition : "+e.getMessage());}
		if(list == null || list.isEmpty())System.out.println("没有与之匹配的内容或Page超出总页数范围!");
		
		return pageBean(page, pageSize, totalNums, list);					
	} 
	
	/**
	 * 功能：跟具Id查询数据
	 * 作者：张强
	 * 日期：2015-9-15
	 * @user lenovo	
	 */
	@SuppressWarnings("unchecked")
	public <T> T findById(Class<T> clazz,String id){			
		
		Session session = HibernateUtils.getFactory().openSession();
		
		int idd = -1;T obj = null;

		try {idd = Integer.parseInt(id);
		} catch (Exception e) {System.out.println(" 'id' convert error!");
		}

		try {obj = (T) session.get(clazz, idd);
		} catch (Exception e) {System.err.print("when execute getById catch an error!");
		}finally{
			if(session != null && session.isOpen())session.close();
		}
		if(idd == -1)System.out.println("id值为空!");
		
		return obj;
	}		
		
	/**
	 * 功能：增加
	 * 作者：张强
	 * 日期：2015-9-15
	 * @user lenovo	
	 */
	public <T> void insert(T t){	
		
		Session session = HibernateUtils.getFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		try {session.save(t);transaction.commit();
		} catch (Exception e) {
			if(transaction != null)transaction.rollback();
			System.out.println("Insert error!");
		}finally{
			if(session != null && session.isOpen())session.close();
		}
		
	}
		
	/**
	 * 功能：修改
	 * 作者：张强
	 * 日期：2015-9-15
	 * @user lenovo	
	 */
	public <T> void update(T t){
		
		Session session = HibernateUtils.getFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		try {
			session.update(t);transaction.commit();
		} catch (Exception e) {
			if(transaction != null)transaction.rollback();
			System.out.println("Insert error!");
		}finally{
			if(session != null && session.isOpen())session.close();
		}
		
	}
	
	/**
	 * 功能：删除
	 * 作者：张强
	 * 日期：2015-9-15
	 * @user lenovo	
	 */
	public <T> void delete(T t){
		
		Session session = HibernateUtils.getFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(t);transaction.commit();
		} catch (Exception e) {
			if(transaction != null)transaction.rollback();
			System.out.println("Delete error!");
		}finally{
			if(session != null && session.isOpen())session.close();
		}
		
	}	
	
	/**
	 * 功能：获取pageBean
	 * 作者：张强
	 * 日期：2015-9-18
	 * @user lenovo
	 */
	public <T> PageBean<T> pageBean(Integer page,Integer pageSize,Integer totalNums,List<T> list){
		
		PageBean<T> pagebean = new PageBean<T>();
		Integer totalPages = 0;

		try {
			totalPages = (totalNums/pageSize)+(totalNums%pageSize==0?0:1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		pagebean.setPage(page);pagebean.setPageSize(pageSize);
		pagebean.setList(list);pagebean.setTotalPages(totalPages);
		
		return pagebean;
	}
	
	/**
	
	//模糊查询示例
	@Test
	public void test1(){

		Map<String,String> map = new HashMap<String, String>();
		
		//查询name包含”阿斯顿发生“的数据
		map.put("name", "阿斯顿发生");
		
//		//查询name包含”阿斯顿发生“并且address包含"中观园"的数据
//		map.put("name", "阿斯顿发生");   map.put("address", "中观园");
		
		PageBean<Yyy> pageBean = findByPageAndCondition(1,6,Yyy.class, map);
		
		List<Yyy> list = pageBean.getList();
		
		for (Yyy yyy : list) {
			System.out.println(yyy);
		}
		
	}
		
		
	*/
}
