package com.javasky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.javasky.pojo.Student;
import com.javasky.tools.DataSource;

public class StudentDao {
	//新增的方法
		public boolean save(Student student){
			boolean flag = false;
			//1,获得数据库连接
			DataSource ds = DataSource.getInstance();
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO STUDENT(id,name,score) VALUES(?,?,?)";
			//获得连接
			conn = ds.getConnection();
			try {
				//2,设置 事务的提交方式为 手动提交
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql);
				//3,给 ？ 赋值
				pstmt.setInt(1, student.getId());
				pstmt.setString(2, student.getName());
				pstmt.setInt(3, student.getScore());
				//4,执行sql语句  如果执行失败 直接走catch代码块
				pstmt.executeUpdate();
				//5,提交事务
				conn.commit();
				//6,sql语句执行成功 flag = true
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
				//7,如果执行失败 回滚事务
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}finally{
				//8,......释放资源
				ds.close(conn, pstmt);
			}
			return flag;
		}
		//修改的方法
		public boolean update(Student student){
			boolean flag = false;
			//1,获得数据库连接
			DataSource ds = DataSource.getInstance();
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE student SET name=?, score=? where id=?";
			//获得连接
			conn = ds.getConnection();
			try {
				//2,设置 事务的提交方式为 手动提交
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql);
				//3,给 ？ 赋值
				pstmt.setInt(3, student.getId());
				pstmt.setString(1, student.getName());
				pstmt.setInt(2, student.getScore());
				//4,执行sql语句  如果执行失败 直接走catch代码块
				pstmt.executeUpdate();
				//5,提交事务
				conn.commit();
				//6,sql语句执行成功 flag = true
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
				//7,如果执行失败 回滚事务
				try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			//8,......释放资源
			ds.close(conn, pstmt);
		}
		return flag;
	}
	//删除 指定的ID
	public boolean delete(int id){
		boolean flag = false;
		//1,获得数据库连接
		DataSource ds = DataSource.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM student where id=?";
		//获得连接
		conn = ds.getConnection();
		try {
			//2,设置 事务的提交方式为 手动提交
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			//3,给 ？ 赋值
			pstmt.setInt(1, id);
			//4,执行sql语句  如果执行失败 直接走catch代码块
			pstmt.executeUpdate();
			//5,提交事务
			conn.commit();
			//6,sql语句执行成功 flag = true
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			//7,如果执行失败 回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			//8,......释放资源
			ds.close(conn, pstmt);
		}
		return flag;
	}
	//查询
	public void select(){
		//1,获得数据库连接
		DataSource ds = DataSource.getInstance();
		Connection conn = null;
		Statement stmt = null;
		String sql = "SELECT * FROM student";
		ResultSet rs = null;
		//获得连接
		conn = ds.getConnection();
		try {
			//2,设置 事务的提交方式为 手动提交
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			//3,执行sql语句 
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Object o1 = rs.getObject("id");
				Object o2 = rs.getObject("name");
				Object o3 = rs.getObject("score");
				System.out.println(o1+"  "+o2+"  "+o3);
			}
			//5,提交事务
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			//6,如果执行失败 回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			//7,......释放资源
			ds.close(conn, stmt, rs);
		}
	}
	//按ID查询
	public boolean selectId(int id){
		boolean flag = false;
		//1,获得数据库连接
		DataSource ds = DataSource.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM student where id=?";
		//获得连接
		conn = ds.getConnection();
		try {
			//2,设置 事务的提交方式为 手动提交
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			//3,给 ？ 赋值
			pstmt.setInt(1, id);
			//4,执行sql语句  如果执行失败 直接走catch代码块
			pstmt.executeUpdate();
			//5,提交事务
			conn.commit();
			//6,sql语句执行成功 flag = true
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			//7,如果执行失败 回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			//8,......释放资源
			ds.close(conn, pstmt);
		}
		return flag;
	}
	//排序
	public void sort(){
		//1,获得数据库连接
		DataSource ds = DataSource.getInstance();
		Connection conn = null;
		Statement stmt = null;
		String sql = "SELECT * FROM student order by score";
		ResultSet rs = null;
		//获得连接
		conn = ds.getConnection();
		try {
			//2,设置 事务的提交方式为 手动提交
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
				//3,执行sql语句 
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					Object o1 = rs.getObject("id");
					Object o2 = rs.getObject("name");
					Object o3 = rs.getObject("score");
					System.out.println(o1+"  "+o2+"  "+o3);
				}
				//5,提交事务
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				//6,如果执行失败 回滚事务
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally{
				//7,......释放资源
				ds.close(conn, stmt, rs);
			}
	  }
}
