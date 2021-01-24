package org.jiangyu.service;

import java.util.List;

import org.jiangyu.dao.RoleDao;
import org.jiangyu.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		String hql = " FROM Role ";
		
		return roleDao.findAll(hql);
	}

	@Override
	public void add(Role model) {
		// TODO Auto-generated method stub
		
		roleDao.addOne(model);
	}

	@Override
	public Role findOne(Long id) {
		// TODO Auto-generated method stub
		return roleDao.get(Role.class, id);
	}

	@Override
	public void remove(Role role) {
		// TODO Auto-generated method stub
		roleDao.removeOne(role);
	}

	@Override
	public void modify(Role model) {
		// TODO Auto-generated method stub
		roleDao.modify(model);
	}

}
