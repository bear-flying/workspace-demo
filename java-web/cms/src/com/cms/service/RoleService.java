package com.cms.service;

import java.util.List;


import com.cms.dao.RoleDao;
import com.cms.pojo.Role;
import com.xiaobai.utils.PageBean;

public class RoleService {

	private RoleDao dao = new RoleDao();
	
	public List<Role> query() {
		// TODO Auto-generated method stub
		String sql = "select * from a_role";
		return dao.query(sql);
	}

	public void add(Role role) {
		// TODO Auto-generated method stub
		String sql = "insert into a_role(role_name,role_desc) values(?,?)";
		dao.add(sql,role);
	}

	public void drop(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from a_role where id = ?";
		dao.drop(sql,id);
	}

	public Role queryOne(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from a_role where id = ?";
		return dao.queryOne(sql,id);
	}

	public void alter(Role role) {
		// TODO Auto-generated method stub
		String sql = "update a_role set role_name=?,role_desc=? where id = ?";
		dao.alter(sql,role);
	}

	public List<Role> findRolesByUserId(int userId){
		
		String sql ="select id , role_name from a_role where id in (select role_id from a_user_role where user_id = ?)";
	
		return dao.findRolesByUserId(sql,userId);
	}

	public PageBean<Role> queryByPage(int page, int pageSize) {

		String sql = "select * from a_role limit ?,?";
		
		String count = "select count(*) from a_role";
		
		return dao.queryByPage(sql,count,page,pageSize);
	}

	public void dropMiddle(int id) {
		// TODO Auto-generated method stub
		String sql = " delete from a_user_role where role_id = ? ";
		dao.drop(sql,id);
	}
	
	
}
