package com.javase.random;

import java.util.ArrayList;
import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        //随机生成一个[1-101)的结果
        Random r = new Random();
        int result = r.nextInt(100)+1;
        System.out.println(result);

        //随即生成m个不同的随机数，且随机数区间为[0,n)
        int n = 5;
        getDiffNO(n);
    }

    private static ArrayList<Integer> getDiffNO(int n) {
        // 生成 [0-n) 个不重复的随机数
        // list 用来保存这些随机数
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;

    }

}
