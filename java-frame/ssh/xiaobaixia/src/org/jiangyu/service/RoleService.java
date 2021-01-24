package org.jiangyu.service;

import java.util.List;

import org.jiangyu.pojo.Role;

public interface RoleService {

	List<Role> findAll();

	void add(Role model);

	Role findOne(Long id);

	void remove(Role role);

	void modify(Role model);

}
