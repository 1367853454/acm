package com.company.java8;

public interface MyInterface {

    default String getName(){
        return "abc";
    }

    public static void show(){
        System.out.println("接口中的静态方法");
    }
}
