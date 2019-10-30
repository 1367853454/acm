package com.company.Java8;

import java.util.*;
import java.util.stream.Collectors;
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
                new Employee("张三",18,9999.99, Employee.Status.BUSY),
                new Employee("李四",18,9999.99, Employee.Status.FREE),
                new Employee("王五",8,4000.22, Employee.Status.vocation),
                new Employee("赵六",118,4000.22, Employee.Status.FREE),
                new Employee("赵六",118,4000.22, Employee.Status.FREE),
                new Employee("赵六",118,4000.22, Employee.Status.FREE),
                new Employee("赵六",118,4000.22, Employee.Status.FREE),
                new Employee("田七",188,4000.22, Employee.Status.vocation)
        );

        Stream<Employee> employees = employeeList.stream()
                .filter((e) -> {
                    System.out.println("Stream的中间操作");
                    return e.getAge() > 18;
                });
        employees.forEach(System.out::println);

        System.out.println("-----------------------------------");

        //map 接收一个函数作为参数，该函数会被应用到每个元素，并将其映射成一个新的元素，返回一个流
        //flatMap 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        List<String> list = Arrays.asList("fff","aaa","bbb","ccc");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("-----------------------------------");

        //排序 自然排序
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("-----------------------------------");

        //自定义排序
        employeeList.stream()
                .sorted((e1,e2) -> {
                    if (e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                })
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        //是否匹配所有元素
        boolean b1 = employeeList.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        System.out.println("--------------------------------------");

        //至少匹配一个
        boolean b2 = employeeList.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        System.out.println("---------------------------------------");

        //都不匹配
        boolean b3 = employeeList.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);

        System.out.println("------------------------------------------");

        //Optional为了防止空指针异常  有可能为空的值封装到Optional
        Optional<Employee> op =employeeList.stream()
                .sorted((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()))
                .findFirst();
        System.out.println(op.get());
        System.out.println("-------------------------------------------");

        //stream 串行流
        Optional<Employee> op2 = employeeList.stream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(op2.get());
        //parallelStream 并行流
        Optional<Employee> op3 = employeeList.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(op3.get());
        System.out.println("--------------------------------------------");

        Long count = employeeList.stream().count();
        System.out.println(count);
        System.out.println("--------------------------------------------");

        Optional<Employee> op4 = employeeList.stream()
                .max((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(op4.get());

        Optional<Double> op5 =employeeList.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(op5.get());
        System.out.println("------------------------------------------------");

        //归约
        //reduce(T, identity起始值, BinaryOperator二元运算) / reduce(BinaryOperator)
        //可以将流中元素反复结合起来，得到一个值
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list1.stream().reduce(0,(x,y) -> x + y);
        System.out.println(sum);
        System.out.println("----------------------------------------------");

        Optional<Double> salary = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(salary.get());
        System.out.println("----------------------------------------------");

        //收集
        //collect 将流转换成其他形式，接收一个Collector接口的实现，用于给Stream元素做汇总
        List<String> list2 = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list2.forEach(System.out::println);
        System.out.println("List name------------");

        Set<String> set = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("set name-----------------------");

        HashSet<String> hashSet = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
        System.out.println("Hashset name--------------------");

        Long counts = employeeList.stream()
                .collect(Collectors.counting());
        System.out.println("总数" + counts);

        Double salaryAvg = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("平均工资" + salaryAvg);

        Double sumSalary = employeeList.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("总工资" + sumSalary);

        Optional<Employee> max = employeeList.stream()
                .collect(Collectors.maxBy((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary())));
        System.out.println("最大工资" + max.get());

        Optional<Double> min = employeeList.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println("最小工资" + min.get());
        System.out.println("------------------------------------------------------");

        //分组
        Map<Employee.Status,List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
        System.out.println("----------------------------------------------------------");

        //多级分组
        Map<Employee.Status,Map<String,List<Employee>>> mapMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((e) -> {
                    if (((Employee)e).getAge() <= 35){
                        return "青年";
                    }else {
                        return "老年";
                    }
                })));
        System.out.println(mapMap);
        System.out.println("-----------------------------------");

        //分区
        Map<Boolean,List<Employee>> booleanListMap = employeeList.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(booleanListMap);
        System.out.println("--------------------------------------------------");

        //集成了很多函数
        DoubleSummaryStatistics dss = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
        System.out.println(dss.getAverage());
        System.out.println(dss.getCount());
        System.out.println(dss.getMin());
        System.out.println(dss.getSum());
        System.out.println("------------------------------------------");

        //连接字符串
        String str = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(str);
    }

}
