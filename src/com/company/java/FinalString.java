package com.company.java;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * 将类声明为final,这样它就不能被继承
 * 将所有的成员声明为私有的,这样就不允许直接访问这些成员
 * 对变量不用提供setter方法
 * 将所有可变的成员声明为final,这样只能对它们赋值一次
 * 通过构造器初始化所有成员，进行深拷贝
 * 在getter方法中,不要直接返回对象本身，而是克隆对象,并返回对象的拷贝
 *
 */
public final class FinalString {

    private final int id;

    private final String name;

    private final HashMap map;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    /**
     * 可变对象的访问方法
     */
    public HashMap getMap(){
        return (HashMap) map.clone();
    }

    /**
     * 实现深拷贝的构造器
     * @param id
     * @param name
     * @param hashMap
     */
//    public FinalString(int id, String name, HashMap hashMap){
//        this.id  = id;
//        this.name = name;
//
//        HashMap tempMap = new HashMap();
//        String key;
//        Iterator iterator = hashMap.keySet().iterator();
//        while (iterator.hasNext()){
//            key = (String) iterator.next();
//            tempMap.put(key,hashMap.get(key));
//        }
//
//        this.map = tempMap;
//    }

    /**
     * 实现浅拷贝的构造器
     * @param id
     * @param name
     * @param hashMap
     */
    public FinalString(int id, String name, HashMap hashMap){
        this.id = id;
        this.name = name;
        this.map = hashMap;
    }

    public static void main(String[] args) {

        String s1 = "java" + "hello";
        String s2 = "javahello";
        System.out.println(s1 == s2);

        HashMap h1 = new HashMap();
        h1.put("1","first");
        h1.put("2","second");

        String name = "original";
        int id = 10;

        FinalString ce = new FinalString(id,name,h1);

        System.out.println(name == ce.getName());
        System.out.println(id == ce.getId());
        System.out.println(h1 == ce.getMap());

        System.out.println("ce id :" + ce.getId());
        System.out.println("ce name :" + ce.getName());
        System.out.println("ce map :" + ce.getMap());

        id = 20;
        name = "change";
        h1.put("3","third");

        System.out.println("after: " + ce.getId());
        System.out.println("after: " + ce.getName());
        System.out.println("after: " + ce.getMap());

        HashMap hashMapTest = ce.getMap();
        hashMapTest.put("4","new");
        System.out.println(ce.getMap());
        System.out.println(LocalDateTime.now());

    }


}
