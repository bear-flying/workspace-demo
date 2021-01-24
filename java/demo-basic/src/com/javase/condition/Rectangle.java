package com.javase.condition;

public class Rectangle {

	/*
	定义一个功能，用于打印矩形。
	思路：
	1，确定结果：没有，因为直接打印。所以返回值类型是void
	2，有未知内容吗？有，两个，因为矩形的行和列不确定。
	*/
	public static void draw(int row,int col) {
		for(int x=0; x<row; x++) {
			for(int y=0; y<col; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		draw(8,10);
	}

}
