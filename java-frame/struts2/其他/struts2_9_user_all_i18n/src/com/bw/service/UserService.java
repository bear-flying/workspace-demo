package com.bw.service;

import java.util.List;

import com.bw.dao.UserDAO;
import com.bw.entity.User;

public class UserService {

	private UserDAO dao = new UserDAO();
	/*
	 * 功能：添加
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public void add(User user){
		dao.add(user);
	}
	
	/*
	 * 功能：列表
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public List getListPage(Integer currentPage,Integer pageSize){
		return dao.getListPage(currentPage, pageSize);
	}
	
	/*
	 * 功能：总记录数
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public int getListCount(){
		return dao.getListCount();
	}
	
	/*
	 * 功能：删除
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public void delete(String id){
		dao.delete(id);
	}
	
	/*
	 * 功能：查询id
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public User getUserById(Integer id){
		return dao.getUserById(id);
	}
}
