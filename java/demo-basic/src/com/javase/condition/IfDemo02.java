package com.javase.condition;
import java.util.Scanner;
public class IfDemo02 {

	/**
	 * .成绩分段,用户输入一个字符,
	 * A(90~100),B(80~89),
	 * C(70~79),D(60~69),E(不及格) （***）
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		for(i=1;i<=5;i++){
			System.out.println("请输入学生成绩：");
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
		/*if(num>=90){
			System.out.println("A");
		}else if(num<90&&num>=80){
			System.out.println("B");
		}else if(num<80&&num>=70){
			System.out.println("C");
		}else {
			System.out.println("不及格");
		}*/
			int score = num/10;

			switch(score){
				case 10:
				case 9:
					System.out.println("A");
					break;
				case 8:
					System.out.println("B");
					break;
				case 7:
					System.out.println("C");
					break;
				default:
					System.out.println("不及格");
			}
		}
	}

}
