package com.javase.collention;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TestCollections3 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List d1406d=new LinkedList();
		Student xs1=new Student("zhangsan",81);
		Student xs2=new Student("lisi",81);
		Student xs3=new Student("wanger",81);
		d1406d.add(xs1);
		d1406d.add(xs2);
		d1406d.add(xs3);
		System.out.println("排序前："+1406d);
		Collections.sort(d1406d,new Comparator(){
			public int compare(Object o1,Object o2){
				Student xs1=(Student)o1;
				Student xs2=(Student)o2;
				return (int) ((xs1.getScore()-xs2.getScore())*-1);
			}
		});
		System.out.println("排序后："+1406d);
	}
}
