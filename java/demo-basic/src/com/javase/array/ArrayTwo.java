package com.javase.array;

/**
 * 二维数组
 */
public class ArrayTwo {

	public static void main(String[] args) {
		int[][]a=new int[][]{{1,2,3},{4,5,6,7}};
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
