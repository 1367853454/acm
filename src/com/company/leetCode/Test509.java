package com.company.leetCode;

/**
 * @author ZHANGWJ
 * @date 2020/9/22 14:29
 */
public class Test509 {

    public static void main(String[] args) {

        Test509 test509 = new Test509();

        System.out.println(test509.fib(20));
    }

    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n + 1];

        return memorandum(memo, n);
    }

    public int memorandum(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = memorandum(memo,n-1) + memorandum(memo,n-2);
        return memo[n];
    }

}
