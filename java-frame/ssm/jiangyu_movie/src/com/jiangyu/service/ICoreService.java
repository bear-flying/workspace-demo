package com.jiangyu.service;

import java.util.List;

import com.jiangyu.pojo.Area;
import com.jiangyu.pojo.Movie;
import com.jiangyu.pojo.Type;
import com.jiangyu.pojo.Year;

public interface ICoreService {

	int getCount(String searchname, String searcharea);

	List<Movie> findAll(Integer page, Integer pageSize,String searchname,String searcharea);

	List<Area> findAllArea();

	List<Type> findAllType();

	List<Year> findAllYear();

	void add(Movie movie);

}
