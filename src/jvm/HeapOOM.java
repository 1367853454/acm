package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHANGWJ
 * @date 2020/7/29 11:06
 */
public class HeapOOM {

    static class OOMObject {

    }

    //-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\dump
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
