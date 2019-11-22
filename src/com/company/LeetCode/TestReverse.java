package com.company.LeetCode;

/**
 *
 * 反转整数
 *
 * 为了便于解释，我们假设rev是正数。
 * 如果 temp = rev⋅10+pop 导致溢出，那么一定有 rev >= INTMAX / 10
 * 如果 rev > INTMAX / 10 temp=rev⋅10+pop 一定会溢出。
 * 如果 rev ==  INTMAX / 10 那么只要pop>7 temp=rev⋅10+pop 就会溢出
 */
public class TestReverse {

    public static void main(String[] args) {

        System.out.println(reverse(100));

        //重新转回int的时候会有溢出的问题
        System.out.println(new StringBuffer("42111111111111111111111111111111111").reverse().toString());

    }

    public static int reverse(int x){

        int rev = 0;

        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }

        return rev;
    }
}
