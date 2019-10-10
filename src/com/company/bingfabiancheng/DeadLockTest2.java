package com.company.bingfabiancheng;

public class DeadLockTest2 {

    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {

        Thread threadA =  new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread() + " get ResocurceA");
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get soueceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread() + " get ResourceB");
                    }
                }
            }
        }) ;

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    System.out.println(Thread.currentThread() + " get ResourceB");
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " waiting get sourceA");
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread() + " get sourceA");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }

}
