package com.zh.service;

import java.util.List;

import com.zh.dao.BookDao;
import com.zh.po.Book;
import com.zh.po.Type;
import com.zh.utils.PageBean;

public class BookService {

	private BookDao dao = new BookDao();
	
	/**
	 * 功能：列表
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public PageBean<Book> getList(Integer page,Integer pageSize){
		
		return dao.getList(page, pageSize);
	}
	
	/**
	 * 功能：类型列表
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public List<Type> getTypes(){
		
		return dao.getTypes();
	}
	
	/**
	 * 功能：查询单个数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public Book getObject(String id){
		
		return dao.getObject(id);
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
	 * 功能：更新数据
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
	
		dao.delete(id);
	}
	
	/**
	 * 功能：批量删除
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
