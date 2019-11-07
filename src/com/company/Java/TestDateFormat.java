package com.company.Java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {

    public static void main(String[] args) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String date = df.format(new Date());
        System.out.println(date);

        Date time = df.parse("1998-11-12 12:21:21");
        System.out.println(time);

        //今年的第几天
        DateFormat df1 = new SimpleDateFormat("D");
        System.out.println(df1.format(new Date()));
    }
}
