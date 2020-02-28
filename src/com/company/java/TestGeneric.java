package com.company.java;

public class TestGeneric {

    public static void main(String[] args) {

        MyCollection<String> mc = new MyCollection<>();

        mc.set("haha",0);
        mc.set("wuwu",1);

        String ha = mc.get(0);
        System.out.println(ha);


    }
}

class MyCollection<E>{

    Object[] object = new Object[5];

    public void set(E e, int index){
        object[index] = e;
    }

    public E get(int index){
        return (E) object[index];
    }
}
