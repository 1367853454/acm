package com.company.annTest;

public class Test {

    public void sing(){
        //忽略警告,就要使用这个过时的方法。
        @SuppressWarnings("deprecation")
        Person person = new Child();
        person.sing();
    }
}
