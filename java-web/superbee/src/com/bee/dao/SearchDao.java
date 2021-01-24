package com.bee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bee.utils.DBUtils;
import com.bee.vo.Food;

public class SearchDao {

	DBUtils ds = DBUtils.getInstance();
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public List<Food> querySome(String city,String content) {
		List<Food> list = new ArrayList<Food>();
		conn = ds.getConnection();
		Food food = null;
		String sql = null;
		if(content==null||content.equals("")){
			sql = "select * from food where city='"+city+"'";
		}else{
			sql = "select * from food where city='"+city+"' and name='"+content+"'";
		}	 
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				food= new Food(rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
