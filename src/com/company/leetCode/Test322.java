package com.company.leetCode;

import java.util.Arrays;

/**
 * @author ZHANGWJ
 * @date 2020/9/22 14:57
 * n种硬币凑金额最少需要的硬币数量
 */
public class Test322 {

    public static void main(String[] args) {

        Test322 test322 = new Test322();

        int[] coins = new int[]{1,2,5};

        System.out.println(test322.coinChange(coins, 11));

//        int[] coins = new int[]{186,419,83,408};
//
//        System.out.println(test322.coinChange(coins, 6249));
    }

    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount + 1];

        return dp(memo,coins,amount);
    }

    public int dp(int[] memo, int[] coins, int amout) {
        if (amout == 0) {
            return 0;
        }
        if (amout < 0) {
            return -1;
        }
        if (memo[amout] != 0) {
            return memo[amout];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(memo,coins,amout-coin);
            //去除无解
            if (sub == -1) {
                continue;
            }
            result = Math.min(result,sub+1);
        }
        if (Integer.MAX_VALUE != result) {
            memo[amout] = result;
        } else {
            memo[amout] = -1;
        }
        return memo[amout];
    }
}
