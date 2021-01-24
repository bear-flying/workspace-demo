package com.jiangyu.mapper;

import java.util.List;
import java.util.Map;

import com.jiangyu.pojo.Cinema;
import com.jiangyu.pojo.Movie;

public interface MovieMapper {

	void addMovie(Movie movie);

	int findMovieId(Movie movie);

	List<Movie> findAll(Map<String, Object> map);

	int getCount();

	Movie findOneMovie(Integer id);

	List<Cinema> findCinemaByMovie(Integer movieid);
    
}