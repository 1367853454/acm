package com.company.bingfabiancheng;

public class DeadLockTest2 {

    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    /**
     * synchronized同步关键字 保证了这是一个互斥资源 获得资源对象会获得监视器锁
     * 这里展示了一个死锁的情况
     *//*
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
    }*/

    //一般死锁的问题都是申请资源的顺序不当
    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + " A get ResocurceA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "A waiting get soueceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + " A get ResourceB");
                }
            }
        });
        //申请B的前提是先拿到A 只有获取了n-1所需的资源 才能获取n的资源
        Thread threadB = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + " B get ResourceA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " B waiting get sourceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + " B get sourceB");
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
