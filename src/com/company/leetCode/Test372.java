package com.company.leetCode;

import java.util.Arrays;

/**
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * @author ZHANGWJ
 * @date 2020/10/11 14:09
 */
public class Test372 {

    public static final int base = 1337;

    public static int mypow(int a, int k) {

        if (k == 0) {
            return 1;
        }
        a %= base;
        if (k % 2 == 1) {
            return (a * mypow(a, k-1)) % base;
        } else {
            int sub = mypow(a, k/2);
            return (sub * sub) % base;
        }
    }

    public int superPow(int a, int[] b) {

        if (b.length == 0) {
            return 1;
        }
        int last = b[b.length -1];
        b = Arrays.copyOf(b,b.length -1);

        int part_1 = mypow(a, last);
        int part_2 = mypow(superPow(a, b), 10);

        return (part_1 * part_2) % base;
    }

    public static void main(String[] args) {

        Test372 test372 = new Test372();

        System.out.println(test372.superPow(2, new int[]{1,0}));

    }


}
