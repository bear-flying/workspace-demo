package com.javase.bitwise;

/*
数组的查找操作。

练习：有一个有序的数组，想要将一个元素插入到该数组中，
还要保证该数组是有序的。如何获取该元素在数组中的位置。
*/

class ArrayTest4 {
	public static void main(String[] args) {
//		int[] arr = {3,2,1,5,4,2,9};
//		int index = getIndex(arr,2);
//		System.out.println("index="+index);

		int[] arr = {2,4,5,7,8,19,32,45};//8

		int index = getIndex_2(arr,190);
		System.out.println("index="+index);

//		int x = Arrays.binarySearch(arr,190);//java提供好的一个进行折半查找的功能。开发时使用这个。
//		System.out.println("x="+x);


	}

	public static int getIndex_2(int[] arr,int key)
	{
		int min = 0,max = arr.length-1,mid;

		while(min<=max)
		{
			mid = (max+min)>>1;

			if(key>arr[mid])
				min = mid + 1;
			else if(key<arr[mid])
				max = mid - 1;
			else
				return mid;
		}
		return min;
	}

	/*
	折半查找。
	*/
	public static int halfSearch_2(int[] arr,int key)
	{
		int min = 0,max = arr.length-1,mid;

		while(min<=max)
		{
			mid = (max+min)>>1;

			if(key>arr[mid])
				min = mid + 1;
			else if(key<arr[mid])
				max = mid - 1;
			else
				return mid;
		}
		return -1;
	}



}
