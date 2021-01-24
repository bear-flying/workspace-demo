package com.javasky.stock.order.service;

import java.util.ArrayList;
import java.util.List;

import com.javasky.frame.util.DateUtils;
import com.javasky.frame.util.UUIDUtils;
import com.javasky.stock.order.dao.OrderDao;
import com.javasky.stock.order.pojo.Order;
import com.javasky.stock.util.OrderUtils;

public class OrderService {
	
	
	public List<Order> query(){
		String sql = "select * from db_order";
		OrderDao dao = new OrderDao();
		return dao.query(sql, null);
	}
	
	
	public Order queryById(String id){
		OrderDao dao = new OrderDao();
		String sql = "select * from db_order where id=?";
		return dao.queryById(sql, new Object[]{id});
	}
	
	public void saveOrder(Order order,String[] materIds,String[] counts){
		
		OrderUtils ou = new OrderUtils();
		
		String uuid = UUIDUtils.createUUID();
		String insertOrderSql = "insert into db_order(id,flag,order_date,order_no) values(" +
				" '"+uuid+"',0,to_date('"+DateUtils.format(order.getOrderDate(),"yyyy-MM-dd")+"','yyyy-MM-dd'),'"+ou.createOrderNo()+"')";
		
		List<String> detailsSQL = new ArrayList<String>();
		for(int i=0;i<materIds.length;i++){
			String sql = "insert into db_order_detail (id,order_id,mater_id,count) values(" +
					" '"+UUIDUtils.createUUID()+"','"+uuid+"','"+materIds[i]+"',"+Double.parseDouble(counts[i])+")";
			detailsSQL.add(sql);
		}
		OrderDao dao = new OrderDao();
		dao.saveOrder(insertOrderSql,detailsSQL);
	}
	
	
}
