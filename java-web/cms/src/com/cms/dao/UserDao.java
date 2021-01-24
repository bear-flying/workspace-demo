package com.cms.dao;

import java.util.List;

import com.cms.pojo.Role;
import com.cms.pojo.User;
import com.cms.service.RoleService;
import com.xiaobai.utils.BaseDao;
import com.xiaobai.utils.PageBean;

public class UserDao {

	private BaseDao dao = new BaseDao();
	private RoleService r = new RoleService();
	

	public PageBean<User> queryByPage2(int page, int pageSize, User user) {
		// TODO Auto-generated method stub
		 PageBean<User> pb = dao.queryByPage2(User.class, "a_user", "real_name", page, pageSize, user.getReal_name());
		 //System.out.println(pb.getList().toString());
		 for(User u : pb.getList()){
			 List<Role> roles = r.findRolesByUserId(u.getId());
			 //System.out.println(roles);
			 u.setRoleList(roles);
		 }
		 return pb;
	}


	public void add(String sql, User user) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, user.getLogin_name(),user.getPassword(),user.getReal_name(),user.getSex(),user.getAge());
		
	}


	public User queryOne(String sql, int id) {
		// TODO Auto-generated method stub
		return dao.queryOne(User.class, sql, id);
	}


	public void alter(String sql, User user) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, user.getLogin_name(),user.getPassword(),user.getReal_name(),user.getSex(),user.getAge(),user.getId());
	}


	public void drop(String sql, int id) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, id);
	}


	public User findUserById(String sql, int userId) {
		// TODO Auto-generated method stub
		return dao.queryOne(User.class, sql, userId);
	}


	public void removeMiddle(String sql,int userId) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, userId);
	}

}
