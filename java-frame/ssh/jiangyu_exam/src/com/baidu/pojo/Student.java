package com.baidu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_student")
public class Student {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private String adddate;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	private Classes classes;
	
	@ManyToOne
	@JoinColumn(name="academy_id")
	private Academy academy;
	
	@ManyToMany
	@JoinTable(name="t_student_hobby",
			joinColumns=@JoinColumn(name="sid"),
			inverseJoinColumns=@JoinColumn(name="hid"))
	private Set<Hobby> hobbys = new HashSet<Hobby>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdddate() {
		return adddate;
	}

	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	public Set<Hobby> getHobbys() {
		return hobbys;
	}

	public void setHobbys(Set<Hobby> hobbys) {
		this.hobbys = hobbys;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	
}
