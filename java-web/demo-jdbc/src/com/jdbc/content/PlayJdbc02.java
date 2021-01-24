package com.jdbc.content;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PlayJdbc02 {
	public static void main(String[] args) {
		/*加载oracle的驱动程序
		 * oracle.jdbc.driver.OracleDriver
		 * 
		 *当驱动程序加载成功之后，驱动程序会自动通过调用
		 *java.sql.DriverManager.registerDriver()静态方法
		 *进行驱动注册，注册到Java虚拟机之中。
		 * 
		 * URL: jdbc:oracle:thin:@192.168.1.xx:1521:sid 
		 * scott
		 * tiger
		 * 
		 * java.sql.SConnection conn = DriverManage. getConnection(url,user,pwd);
		 */
		String url = "jdbc:oracle:thin:@192.168.1.177:1521:orcl";
		String user ="scott";
		String pwd ="tiger";
		
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入工作种类：");
		String job = scan.next();
		
		try {
			//加载oracle jdbc驱动程序。
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//获得数据库连接。
			Connection conn = DriverManager.getConnection(url, user, pwd);
			/*声明SQL语句
			 这种查询 有SQL注入这个bug，可以换成预处理的SQL语句执行器来解决。
			  String sql = "select * from emp where job='"+job+"'";
			    创建静态sql语句执行器
			  Statement stmt = conn.createStatement();
			*/
			//预处理sql语句 写的时候 把你的参数值写成 ？
			String sql = "select * from emp where job=? and sal=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			//在执行查询之前为 ？赋值 它的索引从1开始 尽可能的保证类型正确。
			stmt.setString(1, job);
			stmt.setFloat(2, 800);
			//执行查询，并将查询结果返回给ResultSet。
			//注意，预处理stmt在执行时 不能有参数 
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Object o1 = rs.getObject(1);
				Object o2 = rs.getObject(2);
				Object o3 = rs.getObject(3);
				Object o4 = rs.getObject(4);
				System.out.println(o1+"  "+o2+"  "+o3+"  "+o4 +" ");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			/*1 url没写对
			 *2  用户名|密码不正确
			 *3  数据库没开
			 * */
			e.printStackTrace();
		}
	}
}
