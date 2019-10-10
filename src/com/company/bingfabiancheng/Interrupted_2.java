package com.company.bingfabiancheng;

public class Interrupted_2 {

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;);
            }
        });

        thread.start();
        //设置中断标志
        thread.interrupt();
        //获取中断标志
        System.out.println("isInterrputed:" +thread.isInterrupted() + Thread.currentThread());
        //获取中断标志并重置
        System.out.println("isInterrputed:" + thread.interrupted() + Thread.currentThread());
        //获取中断标志并重置
        System.out.println("isInterrputed:" + Thread.interrupted() + Thread.currentThread());
        //获取中断标志
        System.out.println("isInterrputed:" + thread.isInterrupted() + Thread.currentThread());

        thread.join();

        System.out.println("main thread is over");
    }

}