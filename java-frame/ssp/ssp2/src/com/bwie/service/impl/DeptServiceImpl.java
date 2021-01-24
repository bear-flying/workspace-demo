package com.bwie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwie.dao.DeptDao;
import com.bwie.entity.Dept;
import com.bwie.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptDao deptDao ;
	
	@Override
	public List<Dept> findAll() {
		
		return deptDao.findAll();
	}

}
