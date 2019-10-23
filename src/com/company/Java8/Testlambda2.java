package com.company.Java8;

import java.util.function.Consumer;

/*
* java8 内置四大核心函数式接口
*
* Consumer<T>:消费型接口
*   void accept(T t)
*
* Supplier<T> 供给型接口
*   T get()
*
* Function<T,R> 函数型接口
*   R apply(T t)
*
* Predicate<T> 断言型接口
*   boolean test(T t)
*
* */
public class Testlambda2 {

    public static void main(String[] args) {
          happy(100, m -> System.out.printf("消费" + m + "元"));
    }

    public static void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
}
