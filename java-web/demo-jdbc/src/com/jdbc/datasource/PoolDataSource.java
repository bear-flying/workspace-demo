package com.jdbc.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

public class PoolDataSource {
	private String url;
	private String user;
	private String pwd;
	private int maxIdle;
	private int minIdle;
	/*由于pool中的连接 经常 删除和加入，为了效率 使用链表*/
	private static LinkedList<Connection> pool = new  LinkedList<Connection>();
	private PoolDataSource(){
		Properties prop = new Properties();
		//读取属性文件  基于类加载路径去寻找
		try {
	prop.load(this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			pwd = prop.getProperty("pwd");
		maxIdle = Integer.parseInt(prop.getProperty("maxIdle","2"));//如果忘写了 默认为2个
			minIdle = Integer.parseInt(prop.getProperty("minIdle","1"));
			String driver = prop.getProperty("driver");
			//加载驱动
			Class.forName(driver);
			//初始化连接池，加入minIdle个Connection到池中去
			for(int i =0;i<minIdle;i++){
				//这样 程序启动的时候 连接就已经装好了 启动比较慢 但以后用的时候 很快 不需要多少时间
				pool.add(getConnection());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static PoolDataSource self = new PoolDataSource();
	
	public static PoolDataSource getInstance(){
		return self;
	}
	/**
	 * 获得数据库连接时 首先判断 池是否有东西，
	 * 如果有 池中取，并删除被取走的那个
	 * 如果池中没有，创建新的
	 * 
	 * 这个方法必须是同步的 因为有可能被几个对象同时取，
	 * 所以要让他们排队，加锁，synchronized
	 * */
	public synchronized Connection getConnection(){
		Connection conn = null;
		if(pool.size()>minIdle){
			conn = pool.removeLast();
		}else{
			try {
				conn = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
		
	}
	/*
	 * 放回池中时 判断 池是否达到最大容量，如果没有达到
	 * 装入池中 否则 释放
	 */
	public void close(Connection conn){
		close(conn,null,null);//调用最后的方法
	}
	public void close(Connection conn, Statement stmt){
		close(conn,stmt,null);
	}

	public void close(Connection conn, Statement stmt, ResultSet rs){
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
		//因为上面是给对象加锁 所以这里也一样
		synchronized(this){
			if(null!=conn){
				if(pool.size()==maxIdle){//如果池满了 释放
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else{
					pool.add(conn);//装入到池中
				}
			}
		}
	}
}
