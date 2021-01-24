package com.javase.others;

import java.util.Enumeration;

public class EnumerationTest implements Enumeration{

	int count;//计数器
	int length;//存储的数组的数组的长度
	Object[] dataArray;//存储数据数组的引用

	public EnumerationTest(int count, int length, Object[] dataArray) {
		super();
		this.count = count;
		this.length = length;
		this.dataArray = dataArray;
	}

	@Override
	public boolean hasMoreElements() {
		return (count<length);
	}

	@Override
	public Object nextElement() {
		return dataArray[count++];
	}


}
