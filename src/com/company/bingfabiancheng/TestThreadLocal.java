package com.company.bingfabiancheng;

public class TestThreadLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello world");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread: " + threadLocal.get());
            }
        });
        //start()以后，线程只是进入了就绪态，什么时候获取到cpu的时间片什么时候才会执行，与主线程一起被调度，顺序无法确定
        //run以后，就相当于调用普通方法，从上向下执行。
        thread.start();

        System.out.println("main:" +threadLocal.get());
    }
}
