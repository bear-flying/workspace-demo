package com.jiangyu.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangyu.dao.IEmpDao;
import com.jiangyu.dao.IRoleDao;
import com.jiangyu.pojo.CEmp;
import com.jiangyu.pojo.CRole;
@Service
public class EmpService implements IEmpService {

	@Autowired
	private IEmpDao empDao;
	
	@Autowired
	private IRoleDao roleDao;
	
	public List<CEmp> findAll() {
		// TODO Auto-generated method stub
		return empDao.findAll(" FROM CEmp ");
	}

	public void modifyEmpRole(Integer id, Integer[] roleid) {
		// TODO Auto-generated method stub
		CEmp emp = empDao.get(CEmp.class, id);
		//清除掉该用户原来的角色
		emp.setCRoles(null);//emp.getCRoles().clear();
		Set<CRole> set = new HashSet<CRole>();
		for(Integer i : roleid){
			CRole r =roleDao.get(CRole.class, i);
			set.add(r);//emp.getCRoles().add(r);
		}
		emp.setCRoles(set);
		//如果 在emp.hbm.xml中存在inverse=true 那么下面的更新empDao.modify(emp);将
		//不会被执行，因为emp没有维护关联关系 也就是说emp永远不管中间表
		//执行role对象的时候才会生效
		empDao.modify(emp);
		
		/*********另一种**********/
//		CEmp emp = empDao.get(CEmp.class, id);
//		emp.getCRoles().clear();
//		for(Integer i : roleid){ //只要双方没有级联更新的关系 就不会修改角色表
//			CRole r = new CRole();
//			emp.getCRoles().add(r);
//		}
//		empDao.modify(emp);
		
	}

	public void remove(Integer id) {
		// TODO Auto-generated method stub
		CEmp emp = empDao.get(CEmp.class, id);
		empDao.removeOne(emp);
	}

}
