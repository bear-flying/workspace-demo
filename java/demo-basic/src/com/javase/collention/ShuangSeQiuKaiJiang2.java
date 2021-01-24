package com.javase.collention;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

public class ShuangSeQiuKaiJiang2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
 
		HashSet hq = new HashSet();
		int lq = 0;
		Random r = new Random();
		while(hq.size()<6){
			hq.add(r.nextInt(35)+1);
		}
		Object[] hq2 = hq.toArray();
		Arrays.sort(hq2,new Comparator(){
			public int compare(Object o1, Object o2){
				int i1 = (Integer)o1;
				int i2 = (Integer)o2;
				if(i1<i2){
					return 1;
				}else if(i1==i2){
					return 0;
				}else{
					return -1;
				}
			}
		});
		
		
	}

}
