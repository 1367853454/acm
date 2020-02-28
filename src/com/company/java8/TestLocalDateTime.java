package com.company.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class TestLocalDateTime {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime dateTime = LocalDateTime.of(2015,10,19,13,22,22);
        System.out.println(dateTime);

        //add
        LocalDateTime ldt3 = localDateTime.plusYears(2);
        System.out.println(ldt3);

        //sub
        LocalDateTime ldt4 = localDateTime.minusMonths(2);
        System.out.println(ldt4);


        System.out.println("-------------------------------------");
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());

        System.out.println("---------------------------------------");

        Instant instant = Instant.now();
        //默认获取UTC时期
        System.out.println("世界协调时间,本初子午线:" + instant);

        OffsetDateTime odt = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(instant.toEpochMilli());
        System.out.println("---------------------------------------------");

        //Duration 计算两个时间之间的间隔LocalDateTime
        //Period 计算两个日期之间的间隔LocalDate
        Instant instant1 = Instant.now();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1,instant2);
        System.out.println(duration.toMillis());
        System.out.println("-------------------------------------------");

        //时间校正器
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt1 = ldt.withDayOfMonth(10);
        System.out.println(ldt1);

        LocalDateTime ddt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ddt3);

        //自定义: 下一个工作日
        LocalDateTime ldt5 = ldt.with((L) ->{
            LocalDateTime lldt4 = (LocalDateTime) L;
            DayOfWeek dow = lldt4.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)){
                return lldt4.plusDays(3);
            }else if (dow.equals(DayOfWeek.SATURDAY)){
                return lldt4.plusDays(2);
            }else {
                return lldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
        System.out.println("-------------------------------------------------");

        //格式化时间/日期
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt6 = LocalDateTime.now();

        String strDate = ldt6.format(dtf);
        System.out.println(strDate);

        //自定义
        DateTimeFormatter dtf_2 = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
        String str = dtf_2.format(ldt6);
        System.out.println("自定义" + str);
        System.out.println("------------------------------------------");

        LocalDateTime dd = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(dd);

        LocalDateTime dd1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = dd1.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zonedDateTime);


    }
}
