package com.company.bingfabiancheng;

/**
 * interrupted方法获取的是调用者的中断状态 而不是被调用者的中断状态
 */
public class Interrupted_2 {

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {

                }
            }
        });

        thread.start();
        //设置中断标志
        thread.interrupt();
        //获取中断标志
        System.out.println("isInterrputed:" + thread.isInterrupted());
        //获取中断标志并重置
        System.out.println("isInterrputed:" + thread.interrupted());
        //获取中断标志并重置
        System.out.println("isInterrputed:" + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrputed:" + thread.isInterrupted());

        thread.join();

        System.out.println("main thread is over");
    }

}