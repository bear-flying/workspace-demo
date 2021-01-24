package com.jiangyu.mapper;

import java.util.List;
import java.util.Map;

import com.jiangyu.pojo.Movie;


public interface MovieMapper {
	List<Movie> findAll(Map<String, Object> map);
	
	
    int insert(Movie movie);
    
    int getCount(Map<String, Object> map);
    
}