package com.company.bingfabiancheng.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ZHANGWJ
 * @date 2020/5/14 14:29
 */
public class LockSupportTest {

   /* public static void main(String[] args) {

        System.out.println("begin");
        //使得当前线程拿到许可证  默认是不持有的
        LockSupport.unpark(Thread.currentThread());
        //因调用park()方法而被阻塞的线程被其他线程中断而返回时不会抛出interruptedException
        LockSupport.park();

        System.out.println("end");
    }*/

    public static void main(String[] args) throws InterruptedException{

        Thread thread = new Thread(() -> {
            System.out.println("child thread begin park");
            //调用park方法 挂起自己 因为默认没有持有许可证  只有被中断才会退出循环
            while (!Thread.currentThread().isInterrupted()) {
                LockSupport.park();
            }
            System.out.println("child thread unpark");
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread begin unpark");
        //调用unpark方法让线程持有许可证，然后park方法返回。
        //LockSupport.unpark(thread);
        thread.interrupt();
    }

}
