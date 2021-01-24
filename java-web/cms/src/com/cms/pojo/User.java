package com.cms.pojo;

import java.util.ArrayList;
import java.util.List;


public class User {

	private int id;
	private String login_name;
	private String password;
	private String real_name;
	private String sex;
	private int age;
	
	public User(int id, String login_name, String password, String real_name,
			String sex, int age) {
		super();
		this.id = id;
		this.login_name = login_name;
		this.password = password;
		this.real_name = real_name;
		this.sex = sex;
		this.age = age;
	}
	private List<Role> roleList = new ArrayList<Role>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", login_name=" + login_name + ", password="
				+ password + ", real_name=" + real_name + ", sex=" + sex
				+ ", age=" + age + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String login_name, String password, String real_name,
			String sex, int age, List<Role> roleList) {
		super();
		this.id = id;
		this.login_name = login_name;
		this.password = password;
		this.real_name = real_name;
		this.sex = sex;
		this.age = age;
		this.roleList = roleList;
	}
	public User(String login_name, String password, String real_name,
			String sex, int age, List<Role> roleList) {
		super();
		this.login_name = login_name;
		this.password = password;
		this.real_name = real_name;
		this.sex = sex;
		this.age = age;
		this.roleList = roleList;
	}
	public User(String login_name, String password, String real_name,
			String sex, int age) {
		super();
		this.login_name = login_name;
		this.password = password;
		this.real_name = real_name;
		this.sex = sex;
		this.age = age;
	}

	
	
}
