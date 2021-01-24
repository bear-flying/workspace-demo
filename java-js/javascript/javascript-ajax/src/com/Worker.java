package com;

public class Worker {
private int id;
private String name;
private char sex;
private int age,workage;
public Worker(int id, String name, char sex, int age, int workage) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.workage = workage;
}
public Worker() {
	super();
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
public char getSex() {
	return sex;
}
public void setSex(char sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getWorkage() {
	return workage;
}
public void setWorkage(int workage) {
	this.workage = workage;
}
@Override
public String toString() {
	return id + " " + name + " " + sex + " "
			+ age + " " + workage;
}


}
