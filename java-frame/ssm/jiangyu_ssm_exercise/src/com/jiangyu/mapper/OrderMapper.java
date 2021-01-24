package com.jiangyu.mapper;

import java.util.List;
import java.util.Map;

import com.jiangyu.pojo.Order;

public interface OrderMapper {
	
	List<Order> findAll(Map<String, Object> map);

	int getCount();

	void add(Order order);

	
}