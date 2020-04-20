package com.company.bingfabiancheng;

/**
 * sleep和yield的区别
 * 线程调用sleep方法时调用线程会被阻塞挂起指定的时间 在这段时间内线程调度器不会去调度该线程
 * 调用yield只是让出自己剩余的时间片 并没有被阻塞挂起 线程调度器下一次调度时就有可能调度到当前线程执行
 */
public class YieldTest implements Runnable{

    YieldTest(){
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            if ((i % 5) == 0){
                System.out.println(Thread.currentThread() + " yield cpu...");
                //让出cpu执行权，放弃时间片，进行下一轮调度
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + " is over");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}
