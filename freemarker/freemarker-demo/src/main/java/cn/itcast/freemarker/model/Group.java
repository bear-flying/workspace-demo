package cn.itcast.freemarker.model;

public class Group {
	private String name;
	
	String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {
	}
	
	public void sayHello(){
		System.out.println("hello");
	}
	

	public void sayHello2(){
		System.out.println("hello");
	}
	
	public void sayHello1(){
		System.out.println("hello");
		
		System.out.println("hello2");
		
		System.out.println("hello3");
	}
}
