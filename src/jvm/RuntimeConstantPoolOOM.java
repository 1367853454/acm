package jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZHANGWJ
 * @date 2020/7/29 20:46
 */
public class RuntimeConstantPoolOOM {

    /*//-XX:PermSize=6M -XX:MaxPermSize=6M JDK6下才能OOM
    public static void main(String[] args) {
        //使用set保持着常量池的引用 以免full GC 回收常量池行为
        Set<String> set = new HashSet<String>();
        //在short范围内足以让6MB的PermSize产生OOM
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }*/

    /**
     * 在JDK6 -- 两个false和JDK7-- 一个true一个false
     * String::intern 是个本地方法 首次遇到时会添加至常量池
     * @param args
     */
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

}
