package com.company.bingfabiancheng;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SleepTest2 {

    /*private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try{
                    System.out.println("child threadA is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child threadA is in awaked");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("child threadB is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child ThreadB is in awaked");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
    }*/

    public static void main(String[] args) throws InterruptedException{
        //睡眠期间其他线程调用了该线程的interrupt()方法中断了该线程 会在该线程调用sleep()方法的地方抛出InterruptedException而返回
        Thread thread = new Thread(() -> {
            try {
                System.out.println("child thread is in sleep");
                Thread.sleep(10000);
                System.out.println("child thread is in awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        //主线程休眠2S
        Thread.sleep(2000);
        //主线程中断子线程
        thread.interrupt();
    }

}
