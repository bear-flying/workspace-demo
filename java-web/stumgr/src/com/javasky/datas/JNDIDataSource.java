package com.javasky.datas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JNDIDataSource implements IDataSource {

	private int maxIdle;//这个值怎么获取？？？
	private static javax.sql.DataSource ds;
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	static{
		try {
			Context cot = new InitialContext();
			
			ds = (DataSource) cot.lookup("java:comp/env/jdbc/empdemo");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static JNDIDataSource self = new JNDIDataSource();
	
	public JNDIDataSource getInstance(){
		return self;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}


	public void close(Connection conn) {
		close(conn,null,null);
		
	}

	public void close(Connection conn, Statement stmt) {
		close(conn,stmt,null);
		
	}

	public void close(Connection conn, Statement stmt, ResultSet rs) {
		if(null!=rs){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=stmt){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=conn){
			if(pool.size()==maxIdle){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				pool.add(conn);
			}
		}
	}

}
