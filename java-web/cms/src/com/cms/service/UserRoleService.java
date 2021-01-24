package com.cms.service;

import java.util.List;

import com.cms.dao.UserRoleDao;
import com.cms.pojo.UserRole;

public class UserRoleService {

	UserRoleDao dao = new UserRoleDao();
	
	public List<UserRole> findUserRolesById(int userId){
		
		
		String sql = "select id , user_id , role_id from a_user_role where user_id = ?";
		return dao.findAllByCondition(sql, userId);
		
	}
}
