package com.company.annTest;

public interface Person {

    public String name();

    public int age();

    //方法已经过时，使用这个注解警告
    @Deprecated
    public void sing();

}
