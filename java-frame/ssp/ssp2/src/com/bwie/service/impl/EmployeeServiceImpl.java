package com.bwie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwie.dao.EmployeeDao;
import com.bwie.entity.Employee;
import com.bwie.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao ;
	
	@Override
	public void save(Employee employee) {
		
		employeeDao.save(employee);

	}

	@Override
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

}
