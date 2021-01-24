package com.zh.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9064238192953702200L;
	
	private Integer id;
	private String name;
	
	private Set<Book> books = new HashSet<Book>(0);

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

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + "]";
	}	

}
