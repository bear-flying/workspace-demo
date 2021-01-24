package com.doctor.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
/**
 * 
 * @author by 椋炲ぉ鐚唺----濮滃畤 锛團eiTianMaoXiong----jiangyu锛�
 *
 */
public class DBUtils {

	public static String USERNAME;
	public static String PASSWORD;
	public static String URL;
	public static String DRIVER;
	
	private static ResourceBundle rb = ResourceBundle.getBundle("com.doctor.utils.db-config");
	
	private DBUtils(){}
	
	static{
		USERNAME = rb.getString("username");
		PASSWORD = rb.getString("password");
		URL = rb.getString("url");
		DRIVER = rb.getString("driver");
		//System.out.println(USERNAME+PASSWORD+URL+DRIVER);
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("杩炴帴鏁版嵁搴撳け璐ワ紒");
		}
		return conn;
	}
	
	public static void close(Connection conn,Statement st,ResultSet rs){
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
