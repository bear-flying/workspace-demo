package com.javase.collention;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class ShuangSeQiuKaiJiang {

	public static void main(String[] args) {
		HashSet hq = new HashSet();
		int lq = 0;
		Random r = new Random();
		while (hq.size() < 6) {
			hq.add(r.nextInt(35) + 1);
		}
		Object[] hq2 = hq.toArray();
		Arrays.sort(hq2);
		lq = r.nextInt(16) + 1;
		for (Object h : hq2) {// 遍历
			int i = (Integer) h;// 自动拆箱
			if (i < 10) {
				System.out.println("o" + h + "\t");
			} else {
				System.out.println(h + "\t");
			}
		}
		System.out.println(lq);
	}
}
