package com.jiangyu.service;

import java.util.List;
import java.util.Set;

import com.jiangyu.pojo.Address;
import com.jiangyu.pojo.Food;
import com.jiangyu.pojo.Order;
import com.jiangyu.pojo.Time;

public interface ICoreService {

	int getCount();

	List<Order> findAllOrder(Integer page, Integer pageSize);

	List<Time> findAllTime();

	List<Address> findAllAddress();

	void add(Order order, String[] cats);

	void remove(Integer id);

	Order findOneOrder(Integer id);

	List<Food> findFoods();

	void modifyOrder(Order order, String[] cats);

	void removeBatch(Integer[] ids);

	Set<Food> findFoodsByOrderid(Integer id);

	void modifyOnefoodByOrderid(Integer id, String[] cats);

}
