package com.xiaobai.service;

import java.util.List;

import com.xiaobai.dao.RoleDao;
import com.xiaobai.domain.Role;

public class RoleService {

	private RoleDao dao = new RoleDao();
	
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		String sql = " select * from b_role ";
		
		return dao.findAll(sql);
	}

}
