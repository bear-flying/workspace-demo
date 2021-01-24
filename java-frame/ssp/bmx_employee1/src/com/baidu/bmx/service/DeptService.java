package com.baidu.bmx.service;

import java.util.List;

import com.baidu.bmx.entity.Dept;

public interface DeptService {

	List<Dept> findAll()throws Exception;
}
