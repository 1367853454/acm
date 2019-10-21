package com.company.bingfabiancheng;

import java.util.Random;
import java.util.Scanner;

public class Hello {


    public synchronized void helloA(){
        System.out.println("helloA");
    }

    public synchronized void helloB(){
        System.out.println("helloB");
        helloA();
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                Hello helloA = new Hello();
                helloA.helloA();
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                Hello helloB = new Hello();
                helloB.helloB();
            }
        });

        threadA.start();
        threadB.start();

        Random random = new Random();

        String m = "";
        boolean x = m == null ? true : false;

        if (!x){
            System.out.println(x);
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double r,v;
//        double pi = 3.14;
//        r = sc.nextDouble();
//        v = (4.0 / 3) * pi * r * r * r;
//        System.out.printf("体积是%.3f",v);
//    }
}
