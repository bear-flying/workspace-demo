package com.jiangyu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaobaixia.jiangyu.springmvc.ssm.utils.JiangYuPageUtil;

import com.jiangyu.mapper.AreaMapper;
import com.jiangyu.mapper.MovieMapper;
import com.jiangyu.mapper.TypeMapper;
import com.jiangyu.mapper.YearMapper;
import com.jiangyu.pojo.Area;
import com.jiangyu.pojo.Movie;
import com.jiangyu.pojo.Type;
import com.jiangyu.pojo.Year;
@Service
public class CoreService implements ICoreService {

	@Autowired
	private MovieMapper movieMapper;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private TypeMapper typeMapper;
	@Autowired
	private YearMapper yearMapper;
	
//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		return movieMapper.getCount();
//	}

	public int getCount(String searchname, String searchtype) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchname", searchname);
		map.put("searchtype", searchtype);
		return movieMapper.getCount(map);
	}
	
	
	@Override
	public List<Movie> findAll(Integer page, Integer pageSize,String searchname,String searchtype) {
		// TODO Auto-generated method stub
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("page", (page-1)*pageSize);
//		map.put("pageSize", pageSize);
		Map<String, Object> map = JiangYuPageUtil.findMap(page, pageSize);
		map.put("searchname", searchname);
		map.put("searchtype", searchtype);

		return movieMapper.findAll(map);
	}


	@Override
	public List<Area> findAllArea() {
		// TODO Auto-generated method stub
		return areaMapper.findAllArea();
	}


	@Override
	public List<Type> findAllType() {
		// TODO Auto-generated method stub
		return typeMapper.findAllType();
	}


	@Override
	public List<Year> findAllYear() {
		// TODO Auto-generated method stub
		return yearMapper.findAllYear();
	}


	@Override
	public void add(Movie movie) {
		// TODO Auto-generated method stub
		movieMapper.insert(movie);
	}

}
