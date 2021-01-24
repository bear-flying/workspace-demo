package com.javasky.stock.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.javasky.frame.dao.BaseDao;
import com.javasky.frame.util.DateUtils;

public class OrderUtils extends BaseDao{
	
	
	public synchronized String createOrderNo(){
		Connection conn = super.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String orderNo = null;
		String sql = "select order_no from db_order where order_date=? order by order_no desc";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(new Date().getTime()));
			rs = pstmt.executeQuery();
			while(rs.next()){
				orderNo = rs.getString("ORDER_NO");
				break;
			}
			if(orderNo==null){
				orderNo = "DD"+DateUtils.format(new Date(),"yyyyMMdd")+"01";
			}else{//DD2011112601
				Integer tempNo = Integer.parseInt(orderNo.substring(orderNo.length()-2))+1;
				if(tempNo < 10){
					orderNo = "DD"+DateUtils.format(new Date(),"yyyyMMdd")+"0"+tempNo;
				}else{
					orderNo = "DD"+DateUtils.format(new Date(),"yyyyMMdd")+tempNo;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return orderNo;
	}
	
	
	
	
}
