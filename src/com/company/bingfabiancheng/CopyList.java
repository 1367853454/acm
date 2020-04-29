package com.company.bingfabiancheng;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ZHANGWJ
 * @date 2020/4/29 17:09
 */
public class CopyList {

    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
    private static volatile CopyOnWriteArraySet<String> arraySet= new CopyOnWriteArraySet<>();

    public static void main(String[] args) throws InterruptedException{

        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(() -> {
            //修改list下标为1的元素为aaaa
            arrayList.set(1,"aaaa");
            //删除元素
            arrayList.remove(2);
            arrayList.remove(2);
        });
        //使用该迭代器元素时，其他线程对该list的增删改查不可念，因为它们操作的是两个不同的数组，这就是弱一致性
        //保证早修改线程启动钱获取的迭代器
        Iterator<String> iterator = arrayList.iterator();
        //启动线程
        threadOne.start();
        //Iterator<String> iterator = arrayList.iterator();
        //等待子线程执行完毕
        threadOne.join();
        //迭代元素
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
