package com.company.java8;

public class TestDefaultInterface {

    public static void main(String[] args) {
        //默认类优先
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());
    }
}
