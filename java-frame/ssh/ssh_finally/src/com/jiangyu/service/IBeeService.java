package com.jiangyu.service;

import java.util.List;

import com.jiangyu.pojo.Bee;
import com.jiangyu.pojo.BeeKind;

public interface IBeeService {

	int getCount(String name);

	List<Bee> findAll(Integer page, Integer pageSize, String name);

	List<BeeKind> getKinds();

	void add(Bee bee);

	void remove(Integer id);

	void removeBatch(String[] ids);

	Bee findOne(String id);

	void modify(Bee bee);

}
