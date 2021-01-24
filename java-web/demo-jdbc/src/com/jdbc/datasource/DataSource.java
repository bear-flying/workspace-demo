package com.jdbc.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataSource {
	private String url;
	private String user;
	private String pwd;
	private DataSource(){
		Properties prop = new Properties();
		//读取属性文件  基于类加载路径去寻找
		try {
	  prop.load(this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			pwd = prop.getProperty("pwd");
			String driver = prop.getProperty("driver");
			//加载驱动
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static DataSource self = new DataSource();
	
	public static DataSource getInstance(){
		return self;
	}
	public Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("连接成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//以下为释放资源的方法 关闭的顺序：最后的先关然后往前推
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
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
