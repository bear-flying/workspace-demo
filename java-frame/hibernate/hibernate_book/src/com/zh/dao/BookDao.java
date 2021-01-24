package com.zh.dao;

import java.util.List;

import com.zh.po.Book;
import com.zh.po.Type;
import com.zh.utils.BaseDao;
import com.zh.utils.PageBean;

public class BookDao {

	private BaseDao dao = new BaseDao();
	
	
	
	/**
	 * 功能：列表
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public PageBean<Book> getList(Integer page,Integer pageSize){
		
		return dao.findByPage(page, pageSize, Book.class);
	}
	
	/**
	 * 功能：类型列表
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public List<Type> getTypes(){
		
		return dao.findAll(Type.class);
	}
	
	/**
	 * 功能：查询单个数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public Book getObject(String id){
		
		return dao.findById(Book.class, id);
	}
	
	/**
	 * 功能：添加数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public void insert(Book book){
		
		dao.insert(book);
	}
	
	/**
	 * 功能：修改数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public void update(Book book){
		
		dao.update(book);
	}

	/**
	 * 功能：删除数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public void delete(String id){
	
		Book book = dao.findById(Book.class, id);
		dao.delete(book);
	}	
	
}
