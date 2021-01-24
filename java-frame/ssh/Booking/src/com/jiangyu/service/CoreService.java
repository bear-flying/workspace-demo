package com.jiangyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jiangyu.dao.IAddressDao;
import com.jiangyu.dao.ICityDao;
import com.jiangyu.dao.IStreetDao;
import com.jiangyu.pojo.Address;
import com.jiangyu.pojo.City;
import com.jiangyu.pojo.Street;

@Service
public class CoreService implements ICoreService {

	@Autowired
	private ICityDao cityDao;
	@Autowired
	private IStreetDao streetDao;
	@Autowired
	private IAddressDao addressDao;
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-11-21上午9:39:26
	 * 功能：查询所有城市信息
	 * @return
	 */
	public List<City> findCitys() {
		// TODO Auto-generated method stub
		return cityDao.findAll(" FROM City ");
	}
	public List<Street> findStreetsByCondition(String mess, String cityid) {
		// TODO Auto-generated method stub
		//City city = cityDao.findOneByHql(" FROM City c WHERE c.id = ? ", cityid);
		String sql = "select a.* from t_street a left join t_city b on a.cid = b.id where 1 = 1 and a.name like '%"+mess+"%' and b.id = "+cityid;
		//streetDao.findAllBySql(Street.class, "select a.* from t_street a left join t_city b on a.cid = b.id where 1 = 1 and a.name like '%"+mess+"%' and b.id ="+cityid);
		List<Street> list = streetDao.findStreetsByCondify(sql);
		//List<Street> list = streetDao.findAllBySql(Street.class, sql);
		return list;
	}
	

	
	public void addAddress(String city, String street, String meg) {
		// TODO Auto-generated method stub
		City c = new City();
		c.setId(Integer.valueOf(city));
		Street s = streetDao.findOneByHql(" FROM Street a where a.name= ? ", street);
		Address addr = new Address();
		addr.setCity(c);
		addr.setStreet(s);
		addr.setAddress(meg);
		addressDao.addOne(addr);
	}

}
