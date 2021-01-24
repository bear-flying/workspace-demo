package com.javase.collention;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class StudentCollection {

	/**
	 * 使用HashSet TreeSet ArrayList三种方式
	 * 实现添加三个学生对象 并循环打印
	 *
	 * 要求：① TreeSet采用两种方式实现对学生对象的排序
	 * 	        ② ArratList添加元素后 要求排序
	 */
	public static void main(String[] args) {
		//创建HashSet类对象
		HashSet<Student> hashset = new HashSet<Student>();
		//创建三个Student类对象
		Student s1 = new Student("刘瑞1",90);
		Student s2 = new Student("刘瑞2",91);
		Student s3 = new Student("刘瑞3",92);
		//将三个Student类对象存入HashSet集合中
		hashset.add(s1);
		hashset.add(s2);
		hashset.add(s3);
		//利用迭代器遍历输出学生信息
		Iterator<Student> iterator = hashset.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

		//过渡换行
		System.out.println();

		//创建TreeSet类对象
		TreeSet<Student> treeset = new TreeSet<Student>(new StudentComparator());
		//创建四个Student类对象
		Student s4 = new Student("刘瑞4",90);
		Student s5 = new Student("刘瑞5",94);
		Student s6 = new Student("刘瑞6",97);
		Student s7 = new Student("刘瑞4",90);
		//将三四个Student类对象存入TreeSet集合中 其中一个重复的直接过虑掉
		treeset.add(s4);
		treeset.add(s5);
		treeset.add(s6);
		treeset.add(s7);
		//利用迭代器遍历输出学生信息
		Iterator<Student> iterator1 = treeset.iterator();
		while(iterator1.hasNext()){
			System.out.println(iterator1.next());
		}

		//过渡换行
		System.out.println();

		//创建ArrayList类对象
		ArrayList<Student> arraylist = new ArrayList<Student>();
		//创建三个Student类对象
		Student s8 = new Student("刘瑞8",98);
		Student s9 = new Student("刘瑞9",90);
		Student s10 = new Student("刘瑞10",94);
		//将三个Student类对象存入ArrayList集合中
		arraylist.add(s8);
		arraylist.add(s9);
		arraylist.add(s10);
		//排序
		Collections.sort(arraylist, new StudentComparator());
		//遍历输出
		for(Student ss:arraylist){
			System.out.println(ss);
		}
	}

}
