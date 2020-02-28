package com.company.Java;

public class TestException {

    public static void main(String[] args) {

        Person person = new Person();
        person.setAge(-10);

    }

}

class Person{
    private int age;

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        if (age < 0){
            throw  new IllegalAgeException("年龄不能为负数");
        }
        this.age = age;
    }
}

//extends Exception 的话需要编译器处理，throws或者try-catch
class IllegalAgeException extends RuntimeException{

    public IllegalAgeException(){
    }

    public IllegalAgeException(String msg){
        super(msg);
    }
}
