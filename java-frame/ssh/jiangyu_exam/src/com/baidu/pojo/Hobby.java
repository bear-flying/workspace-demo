package com.baidu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_hobby")
public class Hobby {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
//	@ManyToMany
//	@JoinTable(name="t_student_hobby",
//			joinColumns=@JoinColumn(name="hid"),
//			inverseJoinColumns=@JoinColumn(name="sid"))
//	private Set<Student> students = new HashSet<Student>();


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


//	public Set<Student> getStudents() {
//		return students;
//	}
//
//
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}


	public Hobby(Integer id) {
		super();
		this.id = id;
	}


	public Hobby() {
		super();
	}
	
	
	
	
}
