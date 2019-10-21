package com.company.zaqizaba;


public class Child extends Parents {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {

        Child son = new Child();
        son.age = 10;
        son.setName("hh");
        System.out.println(son.getAge() + son.getName());

        Parents p = new Child();
        Child child = (Child) p;
        ((Child) p).setAge(1);
        p.setName("jjaj");
        System.out.println(((Child) p).getAge() + p.getName());

    }

}
