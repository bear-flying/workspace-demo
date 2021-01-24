package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DBUtils;
import vos.Login;

public class LoginDao {

	DBUtils ds =null; 
	Connection conn =null; 
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ss = null;
	public boolean login(Login login){
		boolean flag= false;
		 try {
			ds= DBUtils.getInstance();
			conn= ds.getConnection();
			st = conn.createStatement();
			String sql = "select * from login where username='"+login.getUser()+"'and pass='"+login.getPass()+"'";			
			rs = st.executeQuery(sql);
			if(rs.next()){
				flag=true;
			}else{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ds.close(conn, st, rs);
		}
		return flag;
	}
	
	public Login queryOne(Login login){
		Login lo = null;
		 try {
			 ds= DBUtils.getInstance();
			conn= ds.getConnection();
			String sql = "select * from login where username=?";
			ss= conn.prepareStatement(sql);	
			ss.setString(1, login.getUser());
			rs = ss.executeQuery();
			if(rs.next()){
				lo = new Login(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ds.close(conn, st, rs);
		}
		return lo;
	}
//	public static void main(String[] args) {
//		Login login=new Login("zh3", "1234");
//		LoginDao ld=new LoginDao();
//		System.out.println(ld.login(login));
//	}
//	

	public void insert(Login login) {
		 try {
			ds= DBUtils.getInstance();
			conn= ds.getConnection();
			st = conn.createStatement();
			String sql = "insert into login(username,pass,rank) values('"+login.getUser()+"','"+login.getPass()+"','"+login.getRank()+"')";			
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ds.close(conn, st, rs);
		}

	}
}
