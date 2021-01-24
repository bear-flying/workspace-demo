package com.javasky.stock.material.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javasky.frame.dao.BaseDao;
import com.javasky.frame.util.StringUtils;
import com.javasky.stock.material.pojo.Material;

public class MaterialDao extends BaseDao{
	
	
	public List<Material> query(String sql,Object...params){
		List<Material> list = new ArrayList<Material>();
		List<Map<String,Object>> result = super.executeQuery(sql, params);
		Material material = null;
		for(Map<String,Object> map : result){
			material = new Material();
			material.setId(StringUtils.trim(map.get("ID")));
			material.setMaterialName(StringUtils.trim(map.get("MATER_NAME")));
			material.setStorage(Double.parseDouble(StringUtils.trim(map.get("STORAGE"))));
			list.add(material);
		}
		return list;
	}
	
	
	
}
