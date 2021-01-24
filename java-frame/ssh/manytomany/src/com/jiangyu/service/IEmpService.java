package com.jiangyu.service;

import java.util.List;

import com.jiangyu.pojo.CEmp;

public interface IEmpService {

	List<CEmp> findAll();

	void modifyEmpRole(Integer id, Integer[] roleid);

	void remove(Integer id);

}
