package zaqizaba;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class StudentListLearnStream {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge(i);
            student.setName(String.valueOf(i));
            students.add(student);
        }
        students.add(new Student("1",111));
        //数组中元素的最大值，最小值，平均值，个数，元素总和
        IntSummaryStatistics studentAgeSum = students.stream()
                .collect(Collectors.summarizingInt(Student::getAge));

        System.out.println("IntSummaryStatistics: " + studentAgeSum);
        System.out.println("IntSummaryStatistics.max: " + studentAgeSum.getMax());
        //合并相同的key 保留后者
        Map<String, Student> oldMap = students.parallelStream()
                //筛选出不为空的部分
                .filter(Objects::nonNull)
                //需要是个Predicate<? super T> predicate
                .filter(demo -> demo != null && demo.getAge() != 10)
                //合并key冲突的部分 保留后者
                .collect(Collectors.toMap(Student::getName, nothing -> nothing, (o1, o2) -> o2));

        Map<String, Long> listMap = students.stream()
                //分组后统计
                .collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        listMap.forEach((key, value) -> {
            System.out.print("姓名为:" + key +" ⼈数有: " + value + "--");
        });
        System.out.println();
        System.out.println("-------------------------");

        Map<String,List<Student>> stringListMap = students.stream()
                //简单分组
                .collect(Collectors.groupingBy(Student::getName));
        stringListMap.forEach((key, value) -> {
            System.out.print("姓名为:" + key);
            value.forEach(obj -> {
                System.out.print("数组年龄为" + obj.getAge());
            });
            System.out.println();
        });

        List<BigDecimal> bigDecimalList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(i));
            bigDecimalList.add(bigDecimal);
        }
        //规约
        BigDecimal bigDecimalSum = bigDecimalList.stream()
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        System.out.println("bigDecimalSum: " + bigDecimalSum);


    }

}
