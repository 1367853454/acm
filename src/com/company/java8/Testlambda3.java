package com.company.Java8;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
*
* 方法引用：若lambda体中的内容有方法已经实现了，我们可以只使用方法引用
*
* 对象::实例方法名
*
* 对象::静态方法名
*
* 类::实例方法名
*
* ! 参数列表和返回值需要一致
*
* 构造器引用
*
* ClassName::new
*
* 数组引用
*
* Type[] :: new
*
* */
public class Testlambda3 {

    public static void main(String[] args) {

        Consumer<String> com = (x) -> System.out.println(x);
        com.accept("xx");

        //对象::实例方法名
        Consumer com1 = System.out::println;
        com1.accept("xxx");

        //对象::静态方法名
        Comparator<Integer> comparator1 = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> comparator = Integer::compare;

        //类::实例方法名
        //需要(第一个参数实施了方法的调用者，第二个参数数这个实例方法的参数)
        BiPredicate<String,String> biPredicate = (x,y) -> x.equals(y);
        BiPredicate<String,String> biPredicate1 = String::equals;

        Supplier<Employee> supplier = () -> new Employee();
        supplier.get();
        //构造器引用  默认无参
        Supplier<Employee> supplier1 = Employee::new;
        Employee employee = supplier1.get();
        System.out.println(employee);

        //数组引用
        Function<Integer,String[]> function = (x) -> new String[x];
        String[] strings = function.apply(10);
        System.out.println(strings.length);

        Function<Integer,String[]> function1 = String[]::new;
        String[] strings1 = function1.apply(20);
        System.out.println(strings1.length);
    }
}
