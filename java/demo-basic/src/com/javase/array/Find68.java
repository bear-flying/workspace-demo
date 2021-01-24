package com.javase.array;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.Random;

/**
 * Demo: 随机一个长度100的数组，从中查找68的下标 如果找不到 查69 以此类推
 */
public class Find68 {

    public static void main(String[] args) {

        int[] arr = new int[100];
        Random random = new Random();

        for (int i=0; i<100; i++){
            arr[i] = random.nextInt(100) + 1;
        }

        int index = -1;
        int key = 68;
        int[] newarr = null;

        do {
            index = Arrays.binarySearch(arr, key);
            if (index >= 0) {
                newarr = new int[index + 1];
                System.arraycopy(arr, 0, newarr, 0, index + 1);
                break;
            }
            key++;
        }while (index <= -1);

        if (newarr == null){
            System.out.println("未找到！");
        } else {
            System.out.println("KEY: " + key + ", NEW ARRAY LENGTH: " + newarr.length);
        }
    }

}
