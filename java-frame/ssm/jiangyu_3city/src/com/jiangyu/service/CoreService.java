package com.jiangyu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaobaixia.jiangyu.springmvc.ssm.utils.JiangYuPageUtil;

import com.jiangyu.mapper.CinemaMapper;
import com.jiangyu.mapper.CityMapper;
import com.jiangyu.mapper.MovieMapper;
import com.jiangyu.mapper.MovietoCinemaMapper;
import com.jiangyu.mapper.TypeMapper;
import com.jiangyu.pojo.Cinema;
import com.jiangyu.pojo.City;
import com.jiangyu.pojo.Movie;
import com.jiangyu.pojo.MovietoCinema;
import com.jiangyu.pojo.Type;
@Service
public class CoreService implements ICoreService {

	@Autowired
	private TypeMapper typeMapper;
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private CinemaMapper cinemaMapper;
	@Autowired
	private MovieMapper movieMapper;
	@Autowired
	private MovietoCinemaMapper movietoCinemaMapper;
	
	public List<Type> findTypes() {
		// TODO Auto-generated method stub
		return typeMapper.findAllType();
	}

	public List<City> findChina() {
		// TODO Auto-generated method stub
		return cityMapper.findChina();
	}

	public List<City> findThird(Integer id) {
		// TODO Auto-generated method stub
		return cityMapper.findThird(id);
	}

	public List<Cinema> findCinemaByCity(Integer id) {
		// TODO Auto-generated method stub
		return cinemaMapper.findCinemaByCity(id);
	}

	public void add(Movie movie, String addre, Integer[] cats) {
		// TODO Auto-generated method stub

		movie.setAddressId(addre);
		movieMapper.addMovie(movie);
		int id = movieMapper.findMovieId(movie);
		for (Integer cat : cats) {
			MovietoCinema mc = new MovietoCinema(id,cat);
			movietoCinemaMapper.add(mc);
		}
		
	}

	public List<Movie> findAll(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = JiangYuPageUtil.findMap(page, pageSize);
		return movieMapper.findAll(map);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return movieMapper.getCount();
	}

	public Movie findOneMovie(Integer id) {
		// TODO Auto-generated method stub
		return movieMapper.findOneMovie(id);
	}

	public City findOneCityname(Integer id) {
		// TODO Auto-generated method stub
		return cityMapper.findOneCityname(id);
	}

	public List<Cinema> findCinemaByMovie(Integer movieid) {
		// TODO Auto-generated method stub
		return movieMapper.findCinemaByMovie(movieid);
	}

}
