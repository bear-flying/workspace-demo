package com.cms.service;


import com.cms.dao.RoleDao;
import com.cms.dao.UserDao;
import com.cms.pojo.User;
import com.xiaobai.utils.PageBean;

public class UserService {

	UserDao dao = new UserDao();
	
	RoleDao roledao = new RoleDao();

	public void add(User user) {
		// TODO Auto-generated method stub
		String sql = " insert into a_user(login_name,password,real_name,sex,age) values(?,?,?,?,?)" ;
		dao.add(sql,user);
	}

	public void drop(int id) {
		// TODO Auto-generated method stub
		String sql = " delete from a_user where id = ? ";
		dao.drop(sql,id);
	}

	public void alter(User user) {
		// TODO Auto-generated method stub
		String sql = " update a_user set login_name=?,password=?,real_name=?,sex=?,age=? where id =? ";
		dao.alter(sql,user);
	}

	public User queryOne(int id) {
		// TODO Auto-generated method stub
		String sql = " select * from a_user where id = ? ";
		return dao.queryOne(sql,id);
	}

	public PageBean<User> queryByPage(int page, int pageSize,
			User user) {
		
		return dao.queryByPage2(page,pageSize,user);
	}

	public void dropMiddle(int id) {
		// TODO Auto-generated method stub
		String sql = " delete from a_user_role where user_id = ? ";
		dao.drop(sql,id);
	}

	public User findUserById(int userId) {
		// TODO Auto-generated method stub
		String sql = " select * from a_user where id = ? ";
		
		return dao.findUserById(sql,userId);
	}

	public void changeRole(int userId, String[] roleIds) {
		// TODO Auto-generated method stub
		String sql = "delete from a_user_role where user_id = ? ";
		String sql2 = "insert into a_user_role(user_id,role_id) values(?,?)";
		dao.removeMiddle(sql,userId);
		if(roleIds!=null){
			for (String s : roleIds) {
				roledao.changeRole(sql2,userId,new Integer(s));
			}
		}
		
	}

	
}

