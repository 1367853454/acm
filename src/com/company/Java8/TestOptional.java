package com.company.Java8;

import java.util.Optional;

/*
* Optional容器类的常用方法
* Optional.of(T t) 创建一个Optional实例
* Optional.empty() 创建一个空的Optional实例
* Optional.ofNullable(T t) 若t不为null，创建Optional，否则创建空实例
* isPresent() 判断是否包含值
* orElse(T t) 如果调用对象包含值，返回该值，否则返回t
* orElseGet(Supplier s) 如果调用对象包含值，返回值，否则返回s获取的值
* map(Function f) 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty
* flatMap(Function mapper) 与map类似，要求返回值必须是Optional
* */
public class TestOptional {

    public static void main(String[] args) {

       // Optional<Employee> op_1 = Optional.ofNullable(new Employee());
        Optional<Employee> op_1 = Optional.ofNullable(null);
        if (op_1.isPresent()){
            System.out.println(op_1.get());
        }else {
            System.out.println("|||||||||");
        }
        System.out.println("---------------------------------");

        Employee employee_1 =op_1.orElse(new Employee("张三",18,1888.88,Employee.Status.FREE));
        System.out.println(employee_1);

        System.out.println("--------------------------");

        Employee employee_2 = op_1.orElseGet(() -> {
            return new Employee("李四",18,1888.88,Employee.Status.FREE);
        });
        System.out.println(employee_2);
        System.out.println("----------------------------------");

//        Optional<Employee> op_2 = Optional.ofNullable(null);
//        System.out.println(op_2.get());

        System.out.println("--------------------------------------");

//        Optional<Employee> op = Optional.of(null);
//        Employee employee = op.get();
//        System.out.println(employee);

        System.out.println("-------------------------------------");

//        Optional<Employee> op1 = Optional.empty();
//        System.out.println(op1.get());

        System.out.println("--------------------------------------");

        Optional<Employee> op_op = Optional.ofNullable(new Employee("王五",5,5555, Employee.Status.vocation));
        Optional<String> str = op_op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(str.get());

        System.out.println("------------------------------------");

        //例题 获取名字
        Man man = new Man();
        String name = getGodName(man);
        System.out.println(name);

        System.out.println("--------------------------");

       Optional<NewMan> optionalNewMan = Optional.ofNullable(null);
        System.out.println(getGodNameByNewMan(optionalNewMan));


    }

    public static String getGodName(Man man){
        if (man != null){
         Godness godness = man.getGodness();
         if (godness != null){
             return godness.getName();
         }
        }
        return "hh";
    }

    public static String getGodNameByNewMan(Optional<NewMan> newMan){
        return newMan.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("haha"))
                .getName();
    }
}
