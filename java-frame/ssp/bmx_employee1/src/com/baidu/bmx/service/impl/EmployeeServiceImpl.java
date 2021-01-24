package com.baidu.bmx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.bmx.dao.EmployeeDao;
import com.baidu.bmx.entity.Employee;
import com.baidu.bmx.service.EmployeeService;
import com.baidu.bmx.utils.PageBean;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao eDao;
	@Override
	public PageBean<Employee> findByPage(int page, int pageSize, String url)
			throws Exception {
		// TODO Auto-generated method stub
		return eDao.findByPage(page, pageSize, url);
	}
	@Override
	public void save(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		eDao.save(emp);
	}



}
