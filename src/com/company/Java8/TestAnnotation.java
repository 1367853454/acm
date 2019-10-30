package com.company.Java8;

import java.lang.reflect.Method;

/*
* 重复注解与类型注解
* */
public class TestAnnotation {


    public static void main(String[] args) throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");

        MyAnnotation[] ma = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : ma){
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(){

    }

}
