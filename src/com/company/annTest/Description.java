package com.company.annTest;

import java.lang.annotation.*;
//作用域
@Target({ElementType.METHOD,ElementType.TYPE})
//生命周期
@Retention(RetentionPolicy.RUNTIME)
//标识性的元注解，允许继承
@Inherited
//生成javadoc时会包含注解
@Documented
public @interface Description {

    String desc();

    int age() default 18;
}
