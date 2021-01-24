package com.javase.collention;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestCollections {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(3);
		al.add(1);
		al.add(2);
		System.out.println("排序前：" + al);
		Collections.sort(al);
		System.out.println("升序排序后：" + al);
		Collections.sort(al, new Comparator() {
			public int compare(Object o1, Object o2) {
				int i1 = (Integer) o1;
				int i2 = (Integer) o2;
				return (i1 - i2) * -1;
			}
		});
		System.out.println("降序排序后：" + al);
	}

}
