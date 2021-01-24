package com.javasky.stock.material.service;

import java.util.List;

import com.javasky.stock.material.dao.MaterialDao;
import com.javasky.stock.material.pojo.Material;

public class MaterialService {
	
	
	public List<Material> query(){
		String sql = "select * from db_material";
		MaterialDao dao = new MaterialDao();
		return dao.query(sql, null);
	}
	
	
	
}
