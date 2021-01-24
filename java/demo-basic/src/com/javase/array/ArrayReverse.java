package com.javase.array;

/**
 * 数组反转
 */
public class ArrayReverse {

    public static void main(String[] args) {

        int[] arr = {2,3,4,6,7,8,12,24};

        resversArray(arr);

    }

    private static void resversArray(int[] arr) {

        int temp = 0;

        for (int start=0,end=arr.length-1; start < end; start++,end--){
            temp =  arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        for (int a : arr){
            System.out.print(a+" ");
        }

    }

}
