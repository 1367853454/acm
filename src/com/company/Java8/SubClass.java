package com.company.java8;

/*
* 类优先原则
*
* 多接口时相同方法必须覆盖重写
*
* */
public class SubClass /*extends MyClass*/ implements MyFun, MyInterface{
    @Override
    public String getName() {
        return MyInterface.super.getName();
    }
}
