package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author by xiaobaixia 
 *
 */
public class DBUtils {

	private String user;
	private String pwd;
	private String url;
	
	private DBUtils(){
		user = "root";
		pwd = "root";
		url = "jdbc:mysql://localhost:3306/xiaobai?userUnicode=true&characterEncoding=utf-8";
		String driver ="com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	 private static DBUtils self = new DBUtils();
	 
	 public static DBUtils getInstance(){
		 return self;
	 }
	 
	 public Connection getConnection(){
		 Connection conn = null;
		 try {
			conn = DriverManager.getConnection(url, user, pwd);
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		 return conn;
	 }
	 
	 public void close(Connection conn,Statement st,ResultSet rs){
			try {
				 if(rs!=null)rs.close();
				 if(st!=null)st.close();
				 if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
}
