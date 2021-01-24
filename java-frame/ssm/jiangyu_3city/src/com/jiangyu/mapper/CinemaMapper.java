package com.jiangyu.mapper;

import java.util.List;

import com.jiangyu.pojo.Cinema;

public interface CinemaMapper {
   

    List<Cinema> findCinemasByMovieid(Integer id);

	List<Cinema> findCinemaByCity(Integer id);


  
}