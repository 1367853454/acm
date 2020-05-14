package com.company.bingfabiancheng.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ZHANGWJ
 * @date 2020/5/14 15:33
 */
public class TestPark {

    public void TestPark() {

        LockSupport.park();
    }

    public static void main(String[] args) {

        TestPark testPark = new TestPark();
        testPark.TestPark();

    }

}
