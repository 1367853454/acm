package com.company.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamApi1 {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee("张三",18,9999.99, Employee.Status.BUSY),
                new Employee("李四",18,9999.99, Employee.Status.FREE),
                new Employee("王五",8,4000.22, Employee.Status.vocation),
                new Employee("赵六",118,4000.22, Employee.Status.FREE),
                new Employee("赵六",118,4000.22, Employee.Status.FREE),
                new Employee("赵六",118,4000.22, Employee.Status.FREE),
                new Employee("赵六",118,4000.22, Employee.Status.FREE),
                new Employee("田七",188,4000.22, Employee.Status.vocation)
        );

        Integer [] nums = new Integer[]{1,2,3,4,5};

        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
        System.out.println("-----------------------------");

        Optional<Integer> count = employeeList.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());


    }
}
