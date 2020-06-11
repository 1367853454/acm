package com.company.bingfabiancheng.reentrantLock;

/**
 * @author ZHANGWJ
 * @date 2020/6/11 11:52
 */
public class ReentrantLockTest {

    //共享读锁 65536
    static final int SHARED_SHIFT = 16;

    static final int SHARED_UNIT = (1 << SHARED_SHIFT);

    public static void main(String[] args) {

        System.out.println(SHARED_UNIT);

    }

}
