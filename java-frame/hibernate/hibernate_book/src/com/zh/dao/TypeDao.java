package com.zh.dao;


import com.zh.po.Type;
import com.zh.utils.BaseDao;
import com.zh.utils.PageBean;

public class TypeDao {

	private BaseDao dao = new BaseDao();
	
	
	/**
	 * 功能：列表
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public PageBean<Type> getList(Integer page,Integer pageSize){
		
		return dao.findByPage(page, pageSize, Type.class);
	}
	
	/**
	 * 功能：查询单个数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public Type getObject(String id){
		
		return dao.findById(Type.class, id);
	}
	
	/**
	 * 功能：添加数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public void insert(Type type){
		
		dao.insert(type);
	}
	
	/**
	 * 功能：更新数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public void update(Type type){
		
		dao.update(type);
	}

	/**
	 * 功能：删除数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public void delete(String id){
	
		Type type = dao.findById(Type.class, id);
		dao.delete(type);
	}
	
}
