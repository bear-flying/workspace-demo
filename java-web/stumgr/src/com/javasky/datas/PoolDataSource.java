package com.javasky.datas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

public class PoolDataSource implements IDataSource {

	private String user;
	private String pwd;
	private String url;
	private int maxIdle;
	private int minIdle;
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	private PoolDataSource(){
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
			user = prop.getProperty("user");
			pwd = prop.getProperty("pwd");
			url = prop.getProperty("url");
			String driver = prop.getProperty("driver");
			maxIdle = Integer.parseInt(prop.getProperty("maxIdle","2"));
			minIdle = Integer.parseInt(prop.getProperty("minIdle","1"));
			Class.forName(driver);
			for(int i=0;i<minIdle;i++){
				pool.add(getConnection());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static IDataSource self = new PoolDataSource();
	
	public static IDataSource getInstance(){
		return self;
	}
	
	/* (non-Javadoc)
	 * @see com.emp.datas.IDataSource#getConnection()
	 */
	
	public synchronized Connection getConnection(){
		Connection conn = null;
		if(pool.size()>minIdle){
			conn = pool.removeLast();
		}else{
			try {
				conn=DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	/* (non-Javadoc)
	 * @see com.emp.datas.IDataSource#close(java.sql.Connection)
	 */

	public void close(Connection conn){
		close(conn,null,null);
	}
	/* (non-Javadoc)
	 * @see com.emp.datas.IDataSource#close(java.sql.Connection, java.sql.Statement)
	 */

	public void close(Connection conn,Statement stmt){
		close(conn,stmt,null);
	}
	/* (non-Javadoc)
	 * @see com.emp.datas.IDataSource#close(java.sql.Connection, java.sql.Statement, java.sql.ResultSet)
	 */

	public void close(Connection conn,Statement stmt,ResultSet rs){
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
		synchronized(this){
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
	
}
