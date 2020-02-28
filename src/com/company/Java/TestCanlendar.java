package com.company.java;

import java.util.*;

public class TestCanlendar {

    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar(2000,10,3,22,0,32);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        /*calendar.DATE;
        calendar.DAY_OF_WEEK;*/
        System.out.println(year);
        System.out.println(month);

        //设置日期相关元素
        Calendar c2 = new GregorianCalendar();
        c2.set(Calendar.YEAR,2019);

        System.out.println(c2);

        //日期计算
        Calendar c3 = new GregorianCalendar();
        c3.add(Calendar.YEAR, -100);
        System.out.println(c3);

        //日期对象和时间对象的转化
        System.out.println("--------------------------------");
        Date date = c3.getTime();
        System.out.println(date);
        Calendar c4 = new GregorianCalendar();
        c4.setTime(new Date());
        System.out.println(c4);

        String producesList = "21,21,";

        List<String> producesIdList = Arrays.asList(producesList.split(","));
        System.out.println(producesIdList);

    }
}
