package com.baidu.user.bean;

import java.util.Date;

import com.baidu.dept.bean.Dept;
import com.baidu.group.bean.Group;


public class User {
	      private Integer id;
          private String loginname;
          private String password;
          private String realname;
          private Integer age;
          private String sex;
          private String phone;
          private String mail;
          private Date birthday;
          private String adddate;
          private String role;
          private Dept dept;
          
//          private Grade grade;
//          
//		public Grade getGrade() {
//			return grade;
//		}
//		public void setGrade(Grade grade) {
//			this.grade = grade;
//		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getLoginname() {
			return loginname;
		}
		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRealname() {
			return realname;
		}
		public void setRealname(String realname) {
			this.realname = realname;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public String getAdddate() {
			return adddate;
		}
		public void setAdddate(String adddate) {
			this.adddate = adddate;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", loginname=" + loginname
					+ ", password=" + password + ", realname=" + realname
					+ ", age=" + age + ", sex=" + sex + ", phone=" + phone
					+ ", mail=" + mail + ", adddate=" + adddate + "]";
		}
		public Dept getDept() {
			return dept;
		}
		public void setDept(Dept dept) {
			this.dept = dept;
		}
		
          

		
}
