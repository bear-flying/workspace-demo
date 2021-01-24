package com.javasky.stock.order.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javasky.frame.dao.BaseDao;
import com.javasky.frame.util.DateUtils;
import com.javasky.frame.util.StringUtils;
import com.javasky.stock.order.pojo.Order;

public class OrderDao extends BaseDao {
	
	
	public List<Order> query(String sql,Object...params){
		
		List<Order> list = new ArrayList<Order>();
		List<Map<String,Object>> result = super.executeQuery(sql, params);
		Order order = null;
		for(Map<String,Object> map : result){
			order = new Order();
			order.setId(StringUtils.trim(map.get("ID")));
			order.setOrderDate(DateUtils.parseDate(StringUtils.trim(map.get("ORDER_DATE")), "yyyy-MM-dd"));
			order.setFlag(Integer.parseInt(StringUtils.trim(map.get("FLAG"))));
			order.setOrderNo(StringUtils.trim(map.get("ORDER_NO")));
			list.add(order);
		}
		return list;
	}
	
	
	public Order queryById(String sql,Object...params){
		
		List<Order> list = new ArrayList<Order>();
		List<Map<String,Object>> result = super.executeQuery(sql, params);
		Order order = null;
		for(Map<String,Object> map : result){
			order = new Order();
			order.setId(StringUtils.trim(map.get("ID")));
			order.setOrderDate(DateUtils.parseDate(StringUtils.trim(map.get("ORDER_DATE")), "yyyy-MM-dd"));
			order.setFlag(Integer.parseInt(StringUtils.trim(map.get("FLAG"))));
			order.setOrderNo(StringUtils.trim(map.get("ORDER_NO")));
			list.add(order);
		}
		return list.get(0);
	}
	
	public void saveOrder(String orderSQL,List<String> detailsSQL){
		Connection conn = super.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			stmt.executeUpdate(orderSQL);
			
			for(int i=0;i<detailsSQL.size();i++){
				stmt.addBatch(detailsSQL.get(i));
			}
			stmt.executeBatch();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
}
