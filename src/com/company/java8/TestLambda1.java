package com.company.java8;

import java.util.Comparator;
import java.util.function.Consumer;
/*
* 左侧 lambda表达式的参数列表
* 右侧 lambda表达式需要执行的功能
*
* 语法格式
* 无参数无返回值
* () -> System.out.println("hello")
* */

public class TestLambda1 {

    public static void main(String[] args) {

        //无参数无返回值
        // () -> System.out.println("hello")
        Runnable runnable = () -> System.out.println("hello lambda");
        runnable.run();

        //若只有一个参数，()可以省略
        //一个参数 无返回值
        Consumer<String> com = (x) -> System.out.println(x);
        com.accept("hahahah");

        //多个参数，并且lambda体中有多条语句
        //lambda体必须加{}
        Comparator<Integer> co = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };

        //多个参数，一条语句，可以省略return
        Comparator<Integer> c = (x, y) -> Integer.compare(x, y);

        //lambda的表达式的参数列表的数据类型可以省略不写
        //JVM通过上下文推断
    }

}
