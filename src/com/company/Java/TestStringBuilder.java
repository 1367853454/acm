package com.company.Java;

import java.util.ArrayList;
import java.util.List;

public class TestStringBuilder {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <26; i++){
            stringBuilder.append((char)('a' + i));
        }
        System.out.println(stringBuilder);

        //倒序
        stringBuilder.reverse();
        System.out.println(stringBuilder);

        stringBuilder.setCharAt(3,'高');
        System.out.println(stringBuilder);

        //return this
        stringBuilder.insert(0,'我').insert(6, '爱').insert(10, '你');
        System.out.println(stringBuilder);

        //return this
        stringBuilder.delete(3,4);
        System.out.println(stringBuilder);

        for (int i = 0; i < 5000; i++){
            stringBuilder.append(i);
        }

        System.out.println("-----------------------------------------------");

        String oldUrl = "https://ofp5pv6s7.qnssl.com/headthumb/male_1.jpg";
        String newUrl = "jb-avatar.jianbaolife.com";

        String[] str = oldUrl.split("/");
        str[2] = newUrl;
        System.out.println(String.join("/", str));


        List<String> names=new ArrayList<String>();
        names.add("1");
        names.add("2");
        names.add("3");
        System.out.println(String.join("-", names));

        String[] arrStr=new String[]{"a","b","c"};
        System.out.println(String.join("-", arrStr));
    }


}
