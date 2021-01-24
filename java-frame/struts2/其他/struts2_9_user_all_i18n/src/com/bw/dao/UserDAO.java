package com.bw.dao;

import java.util.List;

import com.bw.entity.User;
import com.bw.utils.JDBCUtil;

public class UserDAO {

	/*
	 * 功能：添加
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public void add(User user){
		String sql = "insert into t_user(name,pwd,age,sex,hobby,content,datea,dept) values('"+user.getName()+"','"+user.getPwd()+"',"+user.getAge()+",'"+user.getSex()+"','"+user.getHobby()+"','"+user.getContent()+"','"+user.getDatea()+"','"+user.getDept()+"')";
		System.out.println("sql_add="+sql);
		JDBCUtil.executeSQL(sql);
	}
	
	/*
	 * 功能：列表
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public List getListPage(Integer currentPage,Integer pageSize){
		String sql = "select * from t_user limit "+currentPage*pageSize+","+pageSize;
		return JDBCUtil.getList(User.class, sql);
	}
	
	/*
	 * 功能：总记录数
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public int getListCount(){
		String sql = "select count(*) from t_user";
		return JDBCUtil.getListCount(sql);
	}
	
	/*
	 * 功能：删除
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public void delete(String id){
		String sql = "delete from t_user where id in("+id+")";
		System.out.println("sql_del="+sql);
		JDBCUtil.executeSQL(sql);	
	}
	
	/*
	 * 功能：查询id
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public User getUserById(Integer id){
		String sql = "select * from t_user where id="+id;
		return (User) JDBCUtil.getObjectById(User.class, sql);
	}
}
