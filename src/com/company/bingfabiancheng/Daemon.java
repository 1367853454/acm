package com.company.bingfabiancheng;

public class Daemon {

//    public static void main(String[] args) {
//        Thread daemonThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        //设置为守护线程
//        daemonThread.setDaemon(true);
//        daemonThread.start();
//    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {

                }
            }
        });

        thread.start();
        System.out.println("main thread is over");
        //打印结束以后你会发现启动界面的红色方块还在说明JVM进程没有退出 因为thread还没有结束
    }

}
