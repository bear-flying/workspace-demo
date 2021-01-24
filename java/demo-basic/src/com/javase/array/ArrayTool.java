package com.javase.array;

/**
 ArrayTool工具类  这是一个可以对数组进行操作的工具类，该类中提供了，获取最值，排序等功能。
 @author 张三
 @version V1.1
 */
public class ArrayTool {
	/**
	 空参数构造函数。
	 */
	private ArrayTool(){}

	/**
	 获取一个整形数组中的最大值。
	 @param arr 接收一个int类型的数组。
	 @return 会返回一个该数组中最大值。
	 */
	public static int getMax(int[] arr) {
		int max = 0;
		for(int x=1; x<arr.length; x++) {
			if(arr[x]>arr[max])
				max = x;
		}
		return arr[max];
	}

	/**
	 获取一个整形数组中的最小值。
	 @param arr 接收一个int类型的数组。
	 @return 会返回一个该数组中最小值。
	 */
	public static int getMin(int[] arr) {
		int min = 0;
		for(int x=1; x<arr.length; x++) {
			if(arr[x]<arr[min])
				min = x;
		}
		return arr[min];
	}

	/**
	 用于打印数组中的元素。打印形式是：[elemet1, element2, ...]
	 */
	public static void printArray(int[] arr) {
		System.out.print("[");
		for(int x=0; x<arr.length; x++) {
			if(x!=arr.length-1)
				System.out.print(arr[x]+", ");
			else
				System.out.println(arr[x]+"]");
		}
	}

    //定义功能，获取key第一次出现在数组中的位置。如果返回是-1，那么代表该key在数组中不存在。
    public static int getIndex(int[] arr,int key) {
        for(int x=0; x<arr.length; x++) {
            if(arr[x]==key)
                return x;
        }
        return -1;
    }

    /**
     * ArrayTool工具类测试
     */
	public static void main(String[] args) {

	    int[] arr = {3,1,87,32,8};

		int max = ArrayTool.getMax(arr);
		System.out.println("max="+max);
		/*
		ArrayTool tool = new ArrayTool();

		int max = tool.getMax(arr);
		System.out.println("max="+max);

		int min = tool.getMin(arr);
		System.out.println("min="+min);

		tool.printArray(arr);
		tool.selectSort(arr);
		tool.printArray(arr);

		int[] arr1 = {};

		ArrayTool tool1 = new ArrayTool();
		*/
	}

}
