package com.javase.condition;

public class PrimeNumber {
	/**
	 *
	 * 判断101-200之间有多少个素数，并输出所有素数。
	 *
	 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt（这个数），
	 * 如果能被整除，则表示此数不是素数，反之是素数。
	 *
	 * 素数：除了1和它本身，再不能被任何数整除。
	 */
	public static void main(String[] args) {
		pn1();
		pn2();
		pn3();
	}

	private static void pn1() {
		int sum = 0;
		for(int i=101;i<=200;i++){
			for(int j=2;j<i;j++){
				if(i%j==0)//不是素数
					break;
				if(j==(i-1)){
					System.out.println(i);
					sum++;
				}
			}
		}
		System.out.println("共"+sum+"个");
	}

	private static void pn2() {
		int sum=0;
		for(int i=101;i<=200;i++){
			boolean flag = true;//flag如果为true，就为素数
			for(int j=2;j<i;j++){
				if(i%j==0){
					//不是素数
					flag=false;//flag为false，不是素数
					break;
				}
			}
			if(flag==true){
				System.out.println(i);
				sum++;
			}
		}
		System.out.println("共"+sum+"个");
	}

	private static void pn3() {
		boolean chuKaiLe = false;
		for(int i=1;i<=100;i++){
			chuKaiLe = false;
			for(int j=2;j<i;j++){
				if(i%j==0){//意思是除开了，才能走进来，除开的不是素数
					chuKaiLe = true;//chuKaiLe为真，即!chuKaiLe为假，不输出。
				}
			}

			if(!chuKaiLe){
				System.out.println(i);
			}
		}
	}

}
