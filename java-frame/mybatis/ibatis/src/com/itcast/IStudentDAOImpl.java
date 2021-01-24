package com.itcast;
import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ibatis.sqlmap.client.SqlMapClient;
public class IStudentDAOImpl implements IStudentDAO{
    private static SqlMapClient sqlMapClient = null;
    static
    {
        try
        {
            Reader reader = com.ibatis.common.resources.Resources.getResourceAsReader("com/itcast/SqlMapConfig.xml");
            sqlMapClient = com.ibatis.sqlmap.client.SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();  
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void addStudent(Student student) {
		try
        {
            sqlMapClient.insert("insertStudent",student);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }	
	}
	public void addStudentBySequence(Student student) {
		try
        {
			//1.从数据库序列中获取主键值
			//2.往student表中播入记录
            sqlMapClient.insert("insertStudentBySequence",student);
            System.out.println("sid="+student.getSid());
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
	}
	public void deleteStudentById(int id) {
		try
        {
            System.out.println(sqlMapClient.delete("deleteStudentById",id));
            //如果打印出来的值大于0，说明删除成功
            System.out.println("如果打印出来的值大于0，说明删除成功");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
	}
	public List<Student> queryAllStudent() {
		List<Student> studentList = null; 
        try
        {
        	studentList = sqlMapClient.queryForList("selectAllStudent");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return studentList;
	}
	public Student queryStudentById(int id) {
		Student student = null;
        try
        {
        	student = (Student)sqlMapClient.queryForObject("selectStudentById",id);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return student;
	}
	public List<Student> queryStudentByName(String name) {
		List<Student> studentList = null;
        try
        {
        	studentList = sqlMapClient.queryForList("selectStudentByName",name);
            
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return studentList;

	}
	public void updateStudent(Student student) {
		try
        {
            System.out.println(sqlMapClient.update("updateStudent",student));
            //如果打印出来的值大于0，说明更新成功
            System.out.println("如果打印出来的值大于0，说明更新成功");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
	}
    public static void main(String[] args)
    {
        IStudentDAOImpl dao = new IStudentDAOImpl();
        //1.查看所有学生
//        for(Student stus:dao.queryAllStudent())
//        {
//            System.out.println(stus);
//        }
    
        //2.按id查询学生
       // System.out.println(dao.queryStudentById(1));
     
        //3.插入一条学生记录
//        Student student = new Student();
//        student.setSid(5);
//        student.setSname("ddd");
//        student.setMajor("lsdkj");
//        student.setBirth(Date.valueOf("1809-08-08"));
//        student.setScore((float) 123.20);
//        
//        dao.addStudent(student);
//        System.out.println(dao.queryStudentById(5));
        
        
        //4.测试按id删除学生记录
        // dao.deleteStudentById(5);
    
        //5.测试修改学生记录
//        Student student = new Student();
//        student.setSid(4);
//        student.setSname("ddd");
//        student.setMajor("lsdkj");
//        student.setBirth(Date.valueOf("1809-08-08"));
//        student.setScore((float) 123.20);
//        
//        dao.updateStudent(student);
//        System.out.println(dao.queryStudentById(4));
         
        //6.测试通过名字进行模糊查询
//        for(Student student:dao.queryStudentByName("d"))
//        {
//            System.out.println(student);
//            
//        }

        //7.测试通过序列添加学生记录
        Student student = new Student();
        student.setSid(100);
        student.setSname("ttttt");
        student.setMajor("444444");
        student.setBirth(Date.valueOf("1843-08-08"));
        student.setScore((float) 155.20);
        dao.addStudentBySequence(student);
    }
}