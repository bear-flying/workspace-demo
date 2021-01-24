package com.cms.dao;

import java.util.List;

import com.cms.pojo.UserRole;
import com.xiaobai.utils.BaseDao;

public class UserRoleDao {

	BaseDao dao = new BaseDao();
	
	public List<UserRole> findAllByCondition(
			String sql, int userId) {
		// TODO Auto-generated method stub
		return dao.findAllByCondition(UserRole.class, sql, userId);
	}

}
