package com.jiangyu.pojo;

public class Food {
    private Integer id;

    private String name;

    public Food() {
		super();
	}

	public Food(Integer id) {
		super();
		this.id = id;
	}

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
        this.name = name == null ? null : name.trim();
    }
}