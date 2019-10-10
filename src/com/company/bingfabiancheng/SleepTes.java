package com.company.bingfabiancheng;

public class SleepTes {

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child thread is in awaked");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        Thread.sleep(2000);

        thread.interrupt();
    }

}
