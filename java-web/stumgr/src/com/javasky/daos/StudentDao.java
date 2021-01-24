package com.javasky.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.javasky.datas.DataSource;
import com.javasky.datas.IDataSource;
import com.stumgr.pojo.Student;

public class StudentDao {

	public boolean save(Student student){
		boolean flag = false;
		//1，获得数据源实例
		IDataSource ds = DataSource.getInstance();
		//2,获得数据库连接
		Connection conn = ds.getConnection();
		//3,声明SQL语句 序号sno是由序列创建出来的 所以要从序列中取
		String sql ="insert into students(sname,gender,mobile,hobby,classes,sno) values(?,?,?,?,?,seq_stu.nextval)";
		//4,声明预处理SQL语句执行器
		PreparedStatement pstmt =null;
		try {
			//5,设置事务的提交方式为手动
			conn.setAutoCommit(false);
			//6，创建pstmt实例
			pstmt=conn.prepareStatement(sql);
			//7,赋值
			pstmt.setString(1, student.getSname());
			pstmt.setString(2, student.getGender());
			pstmt.setString(3, student.getMobile());
			pstmt.setString(4, student.getHobby());
			pstmt.setString(5, student.getClasses());
			//8,执行SQL语句
			pstmt.executeUpdate();
			//9,提交事务
			conn.commit();
			//10,若提交成功 设置flag为true
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			//11,若提交失败 回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			//12,释放资源
			ds.close(conn, pstmt);
		}
		return flag;
	}
	
	public boolean update(Student student){
		boolean flag = false;
		//1，获得数据源实例
		IDataSource ds = DataSource.getInstance();
		//2,获得数据库连接
		Connection conn = ds.getConnection();
		//3,声明SQL语句 序号sno是由序列创建出来的 所以要从序列中取
		String sql ="UPDATE STUDENTS SET sname=?,gender=?,mobile=?,hobby=?,classes=? where sno=?";
		//4,声明预处理SQL语句执行器
		PreparedStatement pstmt =null;
		try {
			//5,设置事务的提交方式为手动
			conn.setAutoCommit(false);
			//6，创建pstmt实例
			pstmt=conn.prepareStatement(sql);
			//7,赋值
			pstmt.setString(1, student.getSname());
			pstmt.setString(2, student.getGender());
			pstmt.setString(3, student.getMobile());
			pstmt.setString(4, student.getHobby());
			pstmt.setString(5, student.getClasses());
			pstmt.setInt(6, student.getSno());
			//8,执行SQL语句
			pstmt.executeUpdate();
			//9,提交事务
			conn.commit();
			//10,若提交成功 设置flag为true
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			//11,若提交失败 回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			//12,释放资源
			ds.close(conn, pstmt);
		}
		return flag;
	}
	
	public boolean delete(int sno){
		boolean flag = false;
		String sql ="delete from students where sno=?";
		IDataSource ds = DataSource.getInstance();
		PreparedStatement stmt = null;
		Connection conn = ds.getConnection();
		try {
			conn.setAutoCommit(false);
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, sno);
			stmt.executeUpdate();
			conn.commit();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			ds.close(conn, stmt);
		}
		return flag;
	}
	
	//按照学号查询该学生
	public Student getBySno(int sno){
		ListDao<Student> stuDao = new ListDao<Student>();
		Student stu = stuDao.getList(Student.class, "SELECT * FROM STUDENTS WHERE SNO="+sno).get(0);
		return stu;
	}
	
}
