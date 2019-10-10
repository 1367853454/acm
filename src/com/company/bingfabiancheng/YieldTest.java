package com.company.bingfabiancheng;

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
