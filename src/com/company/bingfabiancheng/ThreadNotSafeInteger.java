package com.company.bingfabiancheng;

/**
 * @author ZHANGWJ
 * @date 2020/4/20 14:33
 */
public class ThreadNotSafeInteger {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
