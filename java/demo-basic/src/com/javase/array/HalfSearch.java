package com.javase.array;

/**
 * demo: 折半查找法（要求必须是有序数组）
 */
public class HalfSearch {


    public static void main(String[] args) {

        int[] arr = {1,3,5,7,9,11,24,45,66,79,91};

        int keyIndex = halfSearch(arr, 66);

        System.out.println(keyIndex);

        //int keyIndex = Arrays.binarySearch(arr,190);//java提供好的一个进行折半查找的功能。

    }

    /*
    折半查找。提高效率，但是必须要保证该数组是有序的数组。
    */
    public static int halfSearch(int[] arr,int key) {
        int min, max, mid;
        min = 0;
        max = arr.length-1;
        mid = (max+min)/2;

        while(arr[mid]!=key) {
            if(key>arr[mid])
                min = mid + 1;
            else if(key<arr[mid])
                max = mid - 1;

            if(min>max)
                return -1;
            mid = (max+min)/2;
        }
        return mid;
    }


}
