package com.javasky.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javasky.datas.DataSource;
import com.javasky.datas.IDataSource;
import com.stumgr.pojo.User;

public class LoginDao {

					//规则：密码通常不会在调用方法的时候传
	public User getUserByName(String userName){
		IDataSource ds = DataSource.getInstance();
		Connection conn = ds.getConnection();
		String sql ="select * from users where username=?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		//这么写的目的是为了方便判断，如果用户名输入的用户名不存在，就给他返回null
		User user =null;
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				//如果查到结果,创建用户
				user= new User();
				user.setUserName(rs.getString("userName"));
				user.setPwd(rs.getString("upassword"));
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ds.close(conn, pstmt, rs);
		}
		return user;
	}
}
