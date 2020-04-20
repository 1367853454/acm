package com.company.bingfabiancheng;

/**
 * 一个线程调用sleep、wait、join方法一般是为了等到特定条件的到来
 * 但是在sleep的期间内可能条件已经满足 如果一直等待下去就比较不划算
 * 这时候通过调用该线程的interrupt方法强制sleep方法抛出InterruptedException而返回
 * 线程可以恢复到激活状态
 */
public class Interrupted_1 {

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("thread begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("thread awaking");
                }catch (InterruptedException e){
                    System.out.println("thread is interrupted while sleeping e.printStackTrace(): " +  e);
                    return;
                }
                System.out.println("thread-leaving normally");
            }
        });
        thread.start();
        //确保子线程已经进入了休眠状态
        Thread.sleep(1000);
        //打断子线程的休眠，让子线程从sleep函数返回
        thread.interrupt();

        thread.join();

        System.out.println("main thread is over");
    }

}
