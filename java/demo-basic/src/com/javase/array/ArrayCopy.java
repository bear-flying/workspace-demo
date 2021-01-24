package com.javase.array;

public class ArrayCopy {

	public int[] copy(int[] origin) {
		int[] result = new int[origin.length];
		for (int i = 0; i < origin.length; i++) {
			result[i] = origin[i];
		}
		return result;
	}

	public int[] copy2(int[] origin, int from, int end) {
		// from代表开始的元素，end代表结束的元素。
		int[] result = new int[origin.length];
		for (int i = 0; i < origin.length; i++) {
			result[i] = origin[i];
		}
		return result;
	}

}
