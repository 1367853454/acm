package com.company.leetCode;

/**
 * @author ZHANGWJ
 * @date 2020/9/24 14:41
 * 阶乘后的零数
 */
public class Test172 {

    public static void main(String[] args) {
        Test172 test172 = new Test172();
        System.out.println(test172.trailingZeroes(25));
    }

    public int trailingZeroes(int n) {

        int result = 0;
        Long division = 5L;
        while (division <= n) {
            result += n / division;
            division *= 5;
        }
        return result;
    }

}
