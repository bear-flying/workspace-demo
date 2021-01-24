package com.zh.service;

import com.zh.dao.TypeDao;
import com.zh.po.Type;
import com.zh.utils.PageBean;

public class TypeService {

	private TypeDao dao = new TypeDao();
	
	/**
	 * 功能：列表
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public PageBean<Type> getList(Integer page,Integer pageSize){
		
		return dao.getList(page, pageSize);
	}
	
	/**
	 * 功能：查询单个数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public Type getObject(String id){
		
		return dao.getObject(id);
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
	
		dao.delete(id);
	}
	
	/**
	 * 功能：批量删除数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public void delAll(String ids){
		
		String[] idd = ids.split(",");
		for (String id : idd) {
			
			dao.delete(id);
		}
	}
	
}
