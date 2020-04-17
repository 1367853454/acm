package com.company.bingfabiancheng;

public class Synchronized {

    private  static volatile Object resourceA = new Object();
    private  static volatile Object resourceB = new Object();

    /*// 当前线程调用共享变量的wait()方法只会释放当前共享变量上的锁，而不会释放还持有的其他共享变量的锁。
    public static void main(String[] args) throws InterruptedException{
        //创建线程  lambda表达式实现Runnable写法
        Thread threadA = new Thread(() -> {
            try {
                //获取resourceA共享资源的监视器锁
                synchronized (resourceA){
                    System.out.println("threadA get resourceA lock");
                    //获取resourceB共享资源的监视器锁
                    synchronized (resourceB){
                        System.out.println("ThreadA get resourceB lock");
                        //线程A阻塞，并释放获取到的resourceA的锁
                        System.out.println("threadA release resourceA lock");
                        resourceA.wait();
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //休眠1S 为了让线程A先行获取到锁
                    Thread.sleep(1000);
                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA){
                        System.out.println("threadB get resoueceA lock");
                        System.out.println("threadB try get resoueceB lock...");
                        //获取resourceB
                        synchronized (resourceB){
                            System.out.println("threadB get resourceB lock");
                            //线程B阻塞，并释放获取到的resourceA的锁
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();

        //等待线程结束
        threadA.join();
        threadB.join();

        System.out.println("main over");
    }*/

    //验证notify() notifyAll()
    public static void main(String[] args) throws InterruptedException{

        Thread threadA = new Thread(() -> {

            //获取resourceA共享自愿的监视器锁
            synchronized (resourceA) {
                System.out.println("threadA get resourceA lock");
                try {
                    System.out.println("threadA begin wait");
                    resourceA.wait();
                    System.out.println("threadA end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(() -> {

            synchronized (resourceA) {
                System.out.println("threadB get theandA lock");
                try {
                    System.out.println("threadB begin wait");
                    resourceA.wait();
                    System.out.println("threadB end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {

            synchronized (resourceA) {
                System.out.println("threadC begin notify");
                resourceA.notifyAll();
            }
        });

        //启动线程
        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        //等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
