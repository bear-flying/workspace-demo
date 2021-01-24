package com.jiangyu.service;

import java.util.List;

import com.jiangyu.pojo.CRole;

public interface IRoleService {

	List<CRole> findAll();

	List<CRole> findEmpRole(Integer id);

}
