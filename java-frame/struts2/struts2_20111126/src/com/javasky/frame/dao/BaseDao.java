package com.javasky.frame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��ݷ��ʶ���
 * 		Connection
 * 			��δ������ӣ�
 * 			Connection conn = DriverManager.getConnection(url,username,password);
 * 		�����ӵĻ��϶���ݿ���в���
 * 			Statement stmt;
 * 			PreparedStatement pstmt;
 * 			���еĲ����������������������
 * 		��������ѯ������һ�����
 * 		ResultSet rs;(��¼��ѯ���������)
 * @author Administrator
 *
 */
public class BaseDao {

	public BaseDao() {
		//������
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "stumgr";
	private String password = "stumgr";
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	protected Connection getConnection(){
		return conn;
	}
	
	/**
	 * ͳһ��ѯ
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String,Object>> executeQuery(String sql,Object...params){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		try{
			pstmt = conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				Map<String,Object> map = new HashMap<String,Object>();
				for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
					map.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
				}
				result.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return result;
	}
	
	/**
	 * ͳһ�޸ķ���
	 * @param sql �� Ҫִ�е�SQL���(Ԥ����)
	 * @param params(sql����Ҫ�Ĳ���)
	 */
	public void executeUpdate(String sql,Object...params){
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			pstmt.executeUpdate();
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	private void close(){
		try{
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
