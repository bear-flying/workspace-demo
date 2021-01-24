package com.baidu.bmx.utils;

import java.util.List;

/**
 * 作者：金哲
 * 功能：
 * 时间：2015年10月23日
 */
public interface Dao<T> {

	public void save(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public T findById(int id);
	
	public List<T> findAll();
	
	public PageBean<T> findByPage(int page,int pageSize,String url);
	
}
