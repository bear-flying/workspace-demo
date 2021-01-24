package vos;

import java.sql.Date;

public class Student {

	private int id;
	private String name;
	private int age;
	private Date hiredate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Student(int id, String name, int age, Date hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.hiredate = hiredate;
	}
	public Student(String name, int age, Date hiredate) {
		super();
		this.name = name;
		this.age = age;
		this.hiredate = hiredate;
	}
	
	
}
