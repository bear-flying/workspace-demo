package com.xiaobai.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


public class BaseDaoSupport {

	//查询支持：把结果集转成List套Map
	protected List<Map<String, Object>> changeToListMap(ResultSet rs) throws SQLException {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();		
		if(rs!=null){
			List<String> labels = getColumnLabels(rs);
			Map<String, Object> map = null;
			while(rs.next()){
				map = new HashMap<String, Object>();
				for(String label : labels){
					Object obj = rs.getObject(label);
					map.put(label, obj);
				}
				result.add(map);
			}
		}
		return result;
	}
	
	//获取数据库表中所有的列 
	protected List<String> getColumnLabels(ResultSet rs) throws SQLException {
		List<String> labels = new ArrayList<String>();		
		for(int i=0;i<rs.getMetaData().getColumnCount();i++){
			String label = rs.getMetaData().getColumnLabel(i+1);
			labels.add(label);
		}
		return labels;
	}
	
	//查询支持：把List套Map转成List
	protected <T> List<T> changeToList(Class<T> clazz,List<Map<String, Object>> result) 
			throws InstantiationException, IllegalAccessException, InvocationTargetException{
		List<T> list = new ArrayList<T>();
		T bean = null;
		if(result!=null){
			for(Map<String, Object> map : result){
				bean = clazz.newInstance();
				for(Map.Entry<String, Object> entry : map.entrySet()){
					String key = entry.getKey();
					Object value = entry.getValue();
					
					BeanUtils.setProperty(bean, key, value);
				}
				list.add(bean);
			}
		}
		return list;
	}
	
	//分页查询支持  需要一个select * FROM 表名…… limit ? , ?
	protected <T> List<T> getForList(Class<T> clazz,String sql,int page,int pageSize){
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, pageSize*(page-1));
			st.setInt(2, pageSize);
			rs = st.executeQuery();
			List<Map<String, Object>> result = changeToListMap(rs);
			list = changeToList(clazz,result);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn, st, rs);
		}
		
		return list;
	}
	
	//分页支持：获取共多少条数据
	protected int getTotalNums(String sql){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int totalNums = 0;
		try {
			conn = DBUtils.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				totalNums = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn, st, rs);
		}
		return totalNums;
	}
	
}
