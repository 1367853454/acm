package com.company.Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/*
*
* filter  接收Lambda，从中排除某些元素
*
* limit   截断流，使其不超过给定数量
*
* skip 跳过元素，返回一个扔掉了前n个元素的流，若流中的元素不足n个，则返回一个空流
*
* distinct  筛选 通过流所生成的元素的hashcode()，equals()去重
*
* */
public class TestStreamApi {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee("张三",18,9999.99),
                new Employee("lisi",1,9999.99),
                new Employee("wangwu",8,4000.22),
                new Employee("zhaoliu",118,4000.22),
                new Employee("tianqi",188,4000.22)
        );

        Stream<Employee> employees = employeeList.stream()
                .filter((e) -> {
                    System.out.println("Stream的中间操作");
                    return e.getAge() > 18;
                });
        employees.forEach(System.out::println);
    }

}
