package ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author by 飞天猫熊之小白侠--姜宇
 */
public class DataUtils {

	private String user;
	private String pwd;
	private String url;

	private DataUtils(){
		user = "stumgr";
		pwd = "stumgr";
		url = "jdbc:oracle:thin:localhost:1521:orcl";
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static DataUtils self = new DataUtils();

	public static DataUtils getInstance(){
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

	public void close(Connection conn,Statement stmt,ResultSet rs){
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}
