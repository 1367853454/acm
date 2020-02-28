package com.company.Java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamApi1 {

//    public static void main(String[] args) {
//
//        List<Employee> employeeList = Arrays.asList(
//                new Employee("张三",18,9999.99, Employee.Status.BUSY),
//                new Employee("李四",18,9999.99, Employee.Status.FREE),
//                new Employee("王五",8,4000.22, Employee.Status.vocation),
//                new Employee("赵六",118,4000.22, Employee.Status.FREE),
//                new Employee("赵六",118,4000.22, Employee.Status.FREE),
//                new Employee("赵六",118,4000.22, Employee.Status.FREE),
//                new Employee("赵六",118,4000.22, Employee.Status.FREE),
//                new Employee("田七",188,4000.22, Employee.Status.vocation)
//        );
//
//        Integer [] nums = new Integer[]{1,2,3,4,5};
//
//        Arrays.stream(nums)
//                .map((x) -> x * x)
//                .forEach(System.out::println);
//        System.out.println("-----------------------------");
//
//        Optional<Integer> count = employeeList.stream()
//                .map((e) -> 1)
//                .reduce(Integer::sum);
//        System.out.println(count.get());
//
//
//    }

    public static void main(String[] args) {

//        BigDecimal bg = new BigDecimal("10.2250");
//        System.out.println(bg.setScale(2,BigDecimal.ROUND_HALF_UP));
//
//        String s = new String("哈哈");

//        List<List<String>> listList = new ArrayList<>();
//        List<String> list = new ArrayList<>();
//        listList.add(list);
//
//        String name = "haha";
//        list.add(name);
//        System.out.println(listList);

        String [] arr = "1,2,3".split(",");
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println(arr.length);
    }
}
