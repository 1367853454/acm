package com.company.leetCode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZHANGWJ
 * @date 2020/6/11 16:48
 */
public class Test739 {

    public static void main(String[] args) {

        Test739 test739 = new Test739();

        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] t = test739.dailyTemperatures(T);

        for (int i : t) {
            System.out.print(i);
        }

    }

    public int[] dailyTemperatures(int[] T) {

        int[] t = new int[T.length];
        int max = T[0];
        int index = 0;
        int count = 0;
        for (int i = 0; i <T.length -2; i++) {
            if (T[i] > max) {
                t[index] = count;
                index = i;
                count = 0;
                max = T[i];
            } else {
                count ++;
            }
        }
        return t;
    }

    public void xx() {
        Map hashMap = new HashMap();
        hashMap.put(null,null);
        Map concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(null,null);
    }
}
