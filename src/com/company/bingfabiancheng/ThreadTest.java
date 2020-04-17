package com.company.bingfabiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException{
        //创建线程
        MyThread thread = new MyThread();
        //thread.start();
        thread.run();

        RunableTask runableTask = new RunableTask();
        new Thread(runableTask).start();
        new Thread(runableTask).start();

        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try {
            //等待任务执行完毕，返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException e){
            e.printStackTrace();
        }

    }

    //继承Thraed类并重写run方法
    public static class MyThread extends Thread{
        //继承的好处在于在当前run()方法内获取当前线程直接使用this就可以了
        //不好之处在于java的单继承限制，而且任务与代码没有分离，

        @Override
        public void run(){
            System.out.println("i am child thread");
        }
    }

    public static class RunableTask implements Runnable{
        //任务与实现分离，多份相同的逻辑可以复用一个接口
        @Override
        public void run(){
            System.out.println("RunableTask");
        }
    }

    public static class CallerTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello CallerTask";
        }
    }
}
