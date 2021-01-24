package com.jiangyu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaobaixia.jiangyu.springmvc.ssm.utils.JiangYuPageUtil;

import com.jiangyu.mapper.AddressMapper;
import com.jiangyu.mapper.FoodMapper;
import com.jiangyu.mapper.OrderMapper;
import com.jiangyu.mapper.TimesMapper;
import com.jiangyu.pojo.Address;
import com.jiangyu.pojo.Food;
import com.jiangyu.pojo.Order;
import com.jiangyu.pojo.Times;
@Service
public class CoreService implements ICoreService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private TimesMapper timesMapper;
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private FoodMapper foodMapper;
	
	public List<Order> findAll(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = JiangYuPageUtil.findMap(page, pageSize);
		
		return orderMapper.findAll(map);
		
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return orderMapper.getCount();
	}

	public void add(Order order, Integer[] cats) {
		// TODO Auto-generated method stub
		List<Food> lists = new ArrayList<Food>();
		for (Integer cat : cats) {
			lists.add(new Food(cat));
		}
		order.setFoods(lists);
		orderMapper.add(order);
	}

	public void modify(Order order, Integer[] cats) {
		// TODO Auto-generated method stub
		
	}

	public List<Times> findTimes() {
		// TODO Auto-generated method stub
		return timesMapper.findAllTimes();
	}

	public List<Address> findAddress() {
		// TODO Auto-generated method stub
		return addressMapper.findAllAddress();
	}

	public List<Food> findFoods() {
		// TODO Auto-generated method stub
		return foodMapper.findAllFoods();
	}

}
