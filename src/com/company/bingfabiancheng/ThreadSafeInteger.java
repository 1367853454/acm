package com.company.bingfabiancheng;

/**
 * @author ZHANGWJ
 * @date 2020/4/20 14:34
 */
public class ThreadSafeInteger {

    /**
     * 当前等价下面那种 但是是非阻塞的
     * 以下情况使用volatile
     * 写入变量值不依赖变量的当前值(如果依赖当前值 就需要获取-计算-写入 而volatile不能保证原子性)
     * 读写变量值时没有加锁
     */
    private volatile int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /*private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }*/

}
