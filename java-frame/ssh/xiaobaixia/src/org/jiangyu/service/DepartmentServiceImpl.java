package org.jiangyu.service;

import java.util.List;

import org.jiangyu.dao.DepartmentDao;
import org.jiangyu.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		String hql = " FROM Department ";
		
		return departmentDao.findAll(hql);
	}

	@Override
	public Department findOne(Long id) {
		// TODO Auto-generated method stub
		return departmentDao.get(Department.class, id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		Department d = departmentDao.get(Department.class, id);
		departmentDao.removeOne(d);
	}

	@Override
	public void modify(Department model) {
		// TODO Auto-generated method stub
		departmentDao.modify(model);
	}

	@Override
	public void add(Department model) {
		// TODO Auto-generated method stub
		departmentDao.addOne(model);
	}

}
