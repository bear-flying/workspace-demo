package com.xiaobai.dao;

import java.util.List;

import com.xiaobai.domain.Role;
import com.xiaobai.utils.BaseDao;

public class RoleDao {

	private BaseDao dao = new BaseDao();
	
	public List<Role> findAll(String sql) {
		// TODO Auto-generated method stub
		return dao.queryAll(Role.class, sql);
	}

}
