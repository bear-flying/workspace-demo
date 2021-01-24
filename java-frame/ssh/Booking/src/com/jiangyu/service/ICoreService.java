package com.jiangyu.service;

import java.util.List;

import com.jiangyu.pojo.City;
import com.jiangyu.pojo.Street;

public interface ICoreService {

	List<City> findCitys();

	List<Street> findStreetsByCondition(String mess, String cityid);
	void addAddress(String city, String street, String meg);
}
