package com.jiangyu.service;

import java.util.List;

import com.jiangyu.pojo.Address;
import com.jiangyu.pojo.Food;
import com.jiangyu.pojo.Order;
import com.jiangyu.pojo.Times;

public interface ICoreService {

	List<Order> findAll(Integer page, Integer pageSize);

	int getCount();

	void add(Order order, Integer[] cats);

	void modify(Order order, Integer[] cats);

	List<Times> findTimes();

	List<Address> findAddress();

	List<Food> findFoods();

}
