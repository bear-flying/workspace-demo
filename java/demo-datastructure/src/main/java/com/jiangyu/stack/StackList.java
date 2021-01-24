package com.jiangyu.stack;

import java.util.Arrays;

/**
 * 
 * 栈(堆栈) ---- 使用数组模拟实现
 * 
 * @author JiangYu
 *
 */
public class StackList {

	Object[] elements;
	
	int index = 0;//当前的索引值

	public StackList() {
		this.elements = new Object[10];
	}
	
	//添加内容
	public void add(Object o){
		//添加元素之前应该先检查是否容量够用
		ensureCapcity();
		elements[index++] = 0;
	}

	//检查当前的数组使用是否够用
	public void ensureCapcity() {
		if(index == elements.length){
			//计算一个新的长度
			int newLength = elements.length*2;
			elements = Arrays.copyOf(elements, newLength);
		}
	}
	
	//获取当前的元素个数
	public int size(){
		return index;
	}
	
	//出栈 ：删除集合中的元素并返回
//	public Object pop(){
//		return elements[--index];
//	}
	//上面的出栈的方法是存在问题的，删除元素值的时候，并没有取出变量的指向
	public Object pop(){
		int tempIndex = --index;
		Object o = elements[tempIndex];
		elements[tempIndex] = null;//clear to let GC do its work
		return o;
	}
	
	public static void main(String[] args) {
		StackList list = new StackList();
		list.add("张三");
		list.add("李四");
		list.add("王二麻子");
		list.add("李五");
		list.add("赵六");
		list.add("陈七");
		list.add("王八");
		//list.pop()每次执行以后，list.size()就会发生变化。
		//所以这里先定义了size的值。
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.pop());
		}
	}
	
}
