package com.company.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 罗马数字中小的数字在大的数字右边，左边则是小一倍的
 * 如 IV 4 IX 9 CM 900 XC 90
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class TestRomanToInt {

    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("XII"));

    }

    public static int romanToInt(String s){

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length();){
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))){
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            }else {
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }
}
