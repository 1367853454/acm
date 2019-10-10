package com.company.bingfabiancheng;

public class Interrupted_3 {

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().interrupted()){

                }
                System.out.println("thread isInterrupted:" +Thread.currentThread().isInterrupted());
            }
        });

        thread.start();

        thread.interrupt();

        thread.join();
        System.out.println("main thread is over");
    }

}
