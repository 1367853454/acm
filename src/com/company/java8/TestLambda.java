package com.company.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee("张三",18,9999.99),
                new Employee("lisi",1,9999.99),
                new Employee("wangwu",8,4000.22),
                new Employee("zhaoliu",118,4000.22),
                new Employee("tianqi",188,4000.22)
        );

        employeeList.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .forEach(System.out::println);

        employeeList.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        Collections.sort(employeeList,(e1,e2) -> {
            if (e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            } else{
                //return -Integer.compare(e1.getAge(),e2.getAge());
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for (Employee emp: employeeList) {
            System.out.println(emp);
        }
    }

}
