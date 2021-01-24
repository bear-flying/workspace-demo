package com.bwie.service;

import java.util.List;

import com.bwie.entity.Employee;

public interface EmployeeService {

	public void save(Employee employee);
	
	public List<Employee> findAll();
}
