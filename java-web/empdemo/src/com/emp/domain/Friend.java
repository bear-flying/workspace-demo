package com.emp.domain;

public class Friend {

	private int id;
	private String name;
	private String description;
	private int age;
	public Friend(int id, String name, String description, int age) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.age = age;
	}
	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", description="
				+ description + ", age=" + age + "]";
	}
	
	
}
