package com.company.Java;

import java.util.Date;

public class TestDate {

    public static void main(String[] args) {

        Date date = new Date(2000);
        System.out.println(date);

        System.out.println(date.getTime());

        Date date1 = new Date();
        System.out.println(date1.getTime());

        System.out.println(date1.after(date));

        //遇到日期处理:使用Canlendar日期类
        Date date2 = new Date(2020-1900,3,10);//2020年4月10日
        System.out.println(date2);
    }
}
