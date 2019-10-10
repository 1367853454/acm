package com.company.bingfabiancheng;


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
                    System.out.println("thread is interrupted while sleeping");
                    return;
                }
                System.out.println("thread-leaving normally");
            }
        });

        thread.start();
        Thread.sleep(1000);

        //打断子线程的休眠，让子线程从sleep函数返回
        thread.interrupt();

        thread.join();

        System.out.println("main thread is over");
    }

}
