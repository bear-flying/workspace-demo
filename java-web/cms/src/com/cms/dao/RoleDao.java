package com.cms.dao;

import java.util.List;

import com.cms.pojo.Role;
import com.xiaobai.utils.BaseDao;
import com.xiaobai.utils.PageBean;

public class RoleDao {

	private BaseDao dao = new BaseDao();
	
	public List<Role> query(String sql) {
		// TODO Auto-generated method stub
		return dao.queryAll(Role.class, sql);
	}

	public void add(String sql, Role role) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, role.getRole_name(),role.getRole_desc());
	}

	public void drop(String sql, int id) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, id);
	}

	public Role queryOne(String sql, int id) {
		// TODO Auto-generated method stub
		return dao.queryOne(Role.class, sql, id);
	}


	public void alter(String sql, Role role) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, role.getRole_name(),role.getRole_desc(),role.getId());
	}

	public List<Role> findRolesByUserId(String sql,int userId){
		
		return dao.findAllByCondition(Role.class, sql, userId);
	}

	public void changeRole(String sql, int userId, int roleId) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, userId, roleId);
	}

	public PageBean<Role> queryByPage(String sql,String count, int page, int pageSize) {
		// TODO Auto-generated method stub
		return dao.queryByPage(Role.class, sql, count, page, pageSize);
	}
	
}
