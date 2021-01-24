package com.baidu.bmx.service;

import com.baidu.bmx.entity.Employee;
import com.baidu.bmx.utils.PageBean;

public interface EmployeeService {

	PageBean<Employee> findByPage(int page,int pageSize,String url)throws Exception;
	void save(Employee emp)throws Exception;
}
