package com.company.LeetCode;

/**
 * 反转一半数字
 * 负数一定不是回文数
 *
 */
public class TestPalindrome {

    public static void main(String[] args) {

        System.out.println(IsPalindrome(2121));

    }

    public static boolean IsPalindrome(int x){

        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int rev = 0;
        while (x > rev){
            rev =  rev * 10 + x % 10;
            x /= 10;
        }
        //考虑到长度为奇数时，可以通过 rev / 10 去除处于中位的数字。
        //对于12321 while的末尾可以得到 x = 12, rev = 123
        //中位的数字不影响回文
        return x == rev || x == rev / 10;
    }

}
