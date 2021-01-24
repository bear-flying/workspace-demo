package com.javase.array;

public class BubbleSort {

	/**
	 * 冒泡排序：栈中排序一次元素的比较次数，和整体的排序次数
	 * 都等于数组元素个数（数组长度减一）
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		int[] datas =new int[]{5,3,6,4,66,21};
		// Arrays.sort(datas); Java API 提供了一个封装好的冒泡排序方法
		int tmp=0;
		boolean JiaoHuanLe = false;
		//控制排序次数。
		for(int j=0;j<datas.length-1;j++){
			JiaoHuanLe = false;
			//一次冒泡排序（元素都比较完一次）
			for(int i=0;i<datas.length-1-j;i++){
				//交换。
				if(datas[i]<datas[i+1]){
					tmp=datas[i];
					datas[i]=datas[i+1];
					datas[i+1]=tmp;
					JiaoHuanLe = true;
				}
			}
			System.out.println("第"+(j+1)+"次排序后：");
			for(int i=datas.length-1;i >=0;i--){
				System.out.println(datas[i]+"，");
			}
			System.out.println("  ");
			if(!JiaoHuanLe){
				break;
			}
		}
		for(int i=datas.length-1;i >=0;i--){//遍历
			System.out.println(datas[i]);
		}

	}


	/**
	 给int数组进行冒泡排序。
	 @param arr 接收一个int类型的数组。
	 */
	public static void bubbleSort(int[] arr) {
		for (int x=0; x<arr.length-1 ; x++ ) {
			for(int y=0; y<arr.length-x-1; y++) {
				if(arr[y]>arr[y+1]) {
					swap(arr,y,y+1);
				}
			}
		}
	}

	/**
	 给数组中元素进行位置的置换。
	 @param arr  接收一个int类型的数组。
	 @param a 要置换的位置
	 @param b 要置换的位置
	 */
	private static void swap(int[] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
