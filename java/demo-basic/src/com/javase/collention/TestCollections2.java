package com.javase.collention;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestCollections2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("cba");
		al.add("bac");
		al.add("abc");
		System.out.println("排序前：" + al);
		Collections.sort(al);
		System.out.println("升序排序后：" + al);
		Collections.sort(al, new Comparator() {
			public int compare(Object o1, Object o2) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				return s1.compareTo(s2) * -1;
			}
		});
		System.out.println("降序排序后：" + al);
	}
}
