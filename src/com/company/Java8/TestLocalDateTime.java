package com.company.Java8;

import java.time.LocalDateTime;

public class TestLocalDateTime {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime dateTime = LocalDateTime.of(2015,10,19,13,22,22);
        System.out.println(dateTime);

        LocalDateTime ldt3 = localDateTime.plusYears(2);
        System.out.println(ldt3);

        LocalDateTime ldt4 = localDateTime.minusMonths(2);
        System.out.println(ldt4);


        System.out.println("-------------------------------------");
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
    }
}
