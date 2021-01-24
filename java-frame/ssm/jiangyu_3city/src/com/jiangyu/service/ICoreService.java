package com.jiangyu.service;

import java.util.List;

import com.jiangyu.pojo.Cinema;
import com.jiangyu.pojo.City;
import com.jiangyu.pojo.Movie;
import com.jiangyu.pojo.Type;

public interface ICoreService {

	List<Type> findTypes();

	List<City> findChina();

	List<City> findThird(Integer id);

	List<Cinema> findCinemaByCity(Integer id);

	void add(Movie movie, String addre, Integer[] cats);

	List<Movie> findAll(Integer page, Integer pageSize);

	int getCount();

	Movie findOneMovie(Integer id);

	City findOneCityname(Integer id);

	List<Cinema> findCinemaByMovie(Integer movieid);

}
