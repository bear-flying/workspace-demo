package org.jiangyu.service;

import java.util.List;

import org.jiangyu.pojo.Department;

public interface DepartmentService {

	List<Department> findAll();

	Department findOne(Long id);

	void remove(Long id);

	void modify(Department model);

	void add(Department model);

}
