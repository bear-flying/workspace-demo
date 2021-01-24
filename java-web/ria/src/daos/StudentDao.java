package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.DBUtils;
import vos.Student;

public class StudentDao {

	DBUtils ds = DBUtils.getInstance();
	Connection conn = ds.getConnection();
	Statement st = null;
	ResultSet rs = null;
	public List<Student> queryAll(){
		List<Student> list = new ArrayList<Student>();
		Student stu =null;
		 try {
			st = conn.createStatement();
			String sql = "select * from student";			
			rs = st.executeQuery(sql);
			while(rs.next()){
				stu = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ds.close(conn, st, rs);
		}
		return list;
	}
	
	public void insert(Student stu){
		try {
			st = conn.createStatement();
			String sql = "insert into student(name,age,hiredate) values('"+stu.getName()+"','"+stu.getAge()+"','"+stu.getHiredate()+"'"+")";			
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ds.close(conn, st, rs);
		}
	}

	public Student queryById(int id) {
		Student stu =null;
		try {
			st = conn.createStatement();
			
			String sql = "select * from student where id='"+id+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
				stu = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ds.close(conn, st, rs);
		}
		return stu;
	}

	public void updateStudent(Student stu) {
		try {
			st = conn.createStatement();
			String sql ="update student set name='"+stu.getName()+"',age='"+stu.getAge()+"',hiredate='"+stu.getHiredate()+"' where id='"+stu.getId()+"'";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ds.close(conn, st, rs);
		}
		
		
	}

	public void deleteOne(int id) {
		try {
			st = conn.createStatement();
			String sql = "delete from student where id='"+id+"'";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ds.close(conn, st, rs);
		}
		
	}
}
