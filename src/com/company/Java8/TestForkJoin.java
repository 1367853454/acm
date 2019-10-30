package com.company.Java8;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    public static void main(String[] args) {


        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0,100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("ForkJoin框架耗费时间为:" + Duration.between(start,end).toMillis());

        Instant instant = Instant.now();
        long sum1 = 0L;
        for (long i = 0 ; i <= 10000000L; i++){
            sum1 += i;
        }
        System.out.println(sum1);
        Instant end_ = Instant.now();

        System.out.println("For耗费时间为:" + Duration.between(start,end).toMillis());

        //java8并行流
        Instant java8_start = Instant.now();
        LongStream.rangeClosed(0,100000000L)
                  .parallel()
                  .reduce(0,Long::sum);
        Instant j_end = Instant.now();
        System.out.println("耗费时间为:" + Duration.between(java8_start,j_end).toMillis());

    }
}
