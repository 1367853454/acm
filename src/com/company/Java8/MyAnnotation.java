package com.company.java8;

import java.lang.annotation.*;

@Repeatable(MyAnnotations.class)
@Target({ElementType.TYPE, ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hah";
}
