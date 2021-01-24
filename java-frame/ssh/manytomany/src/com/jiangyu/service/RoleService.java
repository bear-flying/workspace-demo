package com.jiangyu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangyu.dao.IEmpDao;
import com.jiangyu.dao.IRoleDao;
import com.jiangyu.pojo.CEmp;
import com.jiangyu.pojo.CRole;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private IRoleDao roleDao;
	
//	@Autowired
//	private IEmpDao empDao;

	public List<CRole> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll(" FROM CRole ");
	}

	public List<CRole> findEmpRole(Integer id) {
		// TODO Auto-generated method stub

		List<CRole[]> result = roleDao.findByConditionSql("select r.* from c_role r join c_emp_role er on r.id = er.rid and er.eid = ? ", String.valueOf(id));
		List<CRole> list= new ArrayList<CRole>();
		for (Object[] r : result) {
			CRole role = new CRole();
			role.setId((Integer)r[0]);
			list.add(role);
		}
		
		//另一种  直接返回一个Set 去前台迭代
//		CEmp cEmp = empDao.get(CEmp.class, id);
//		Set roles = cEmp.getCRoles();
		
		return list;
	}
	
	
	
}
