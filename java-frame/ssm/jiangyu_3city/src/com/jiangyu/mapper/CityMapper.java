package com.jiangyu.mapper;

import java.util.List;

import com.jiangyu.pojo.City;

public interface CityMapper {
    

    City selectByPrimaryKey(Integer id);

	List<City> findChina();

	List<City> findThird(Integer id);

	City findOneCityname(Integer id);

}